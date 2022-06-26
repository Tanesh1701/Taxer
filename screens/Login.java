package screens;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;
import models.*;
import java.awt.*;
import javax.swing.*;
import models.Button;
import java.awt.Color;
import java.awt.Dimension;
import Database.UserDaoAccesser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JPanel{

    private Text header = new Text("Login", 18);
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    private JPanel panelBtnBack = new JPanel();
    BackButton backBtn;
    Constants constants = new Constants();
    UserDaoAccesser uda = new UserDaoAccesser();
    User user = new User();

    public Login(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        panelBtnBack.setLayout(new FlowLayout());
        panelBtnBack.setPreferredSize(new Dimension(100, 50));
        panelBtnBack.setBorder(BorderFactory.createEmptyBorder(0, 0, -70, 620));
        panelBtnBack.setBackground(constants.getPrimaryColor());
        panelBtnBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
        ImageIcon pic1 = new ImageIcon("./Assets/Images/back.png");
        JLabel img1 = new JLabel(pic1);
        img1.setBorder(BorderFactory.createEmptyBorder(0,0,0,-10));
        panelBtnBack.add(img1);

        backBtn = new BackButton("Back");
        backBtn.getBackButton().setPreferredSize(new Dimension(60,40));
        backBtn.getBackButton().setBorder(BorderFactory.createEmptyBorder(0, -25, 0, 0));
        panelBtnBack.add(backBtn.getBackButton());
        ButtonHandler handler1 = new ButtonHandler();
        backBtn.getBackButton().addActionListener(handler1);

        headerPanel.add(header.getTitle());
        headerPanel.setBackground(constants.getPrimaryColor());

        panel.setBackground(constants.getPrimaryColor());
        tfPanel.setBackground(constants.getPrimaryColor());

        tfPanel.setLayout(new GridBagLayout());             
        GridBagConstraints gbc = new GridBagConstraints();

        Field textFieldUsername = new Field("Username");
        Field textFieldPassword = new Field("Password");

        gbc.insets = new Insets(0, 0, 60, 0);

        gbc.gridx = 0; gbc.gridy = 1; tfPanel.add(textFieldUsername.getTextfieldPanel(), gbc);
        gbc.gridx = 0; gbc.gridy = 2; tfPanel.add(textFieldPassword.getTextfieldPanel(), gbc);
        
        ButtonHandler2 handler2 = new ButtonHandler2();

        Button loginBtn = new Button("Login");
        loginBtn.getButton().setPreferredSize(new Dimension(80,40));
        loginBtn.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.getButton().addActionListener(e -> {
            String username = textFieldUsername.getTextfield().getText();
            String password = textFieldPassword.getTextfield().getText();
            Text errorMsg = new Text("You cannot leave any empty fields!", 14);
            if(password.isEmpty() || username.isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    user = uda.getUser(username, password);
                    if (user != null) {
                        if (user.getType().equals("user")) {
                            Main.getFrame().dispose();
                            Dashboard dashboard = new Dashboard(user);
                            dashboard.setVisible(true);
                        } else {
                            Main.getFrame().dispose();
                            AdminDashboard adminDashboard = new AdminDashboard(user);
                            adminDashboard.setVisible(true);
                        }
                    } else {
                        errorMsg = new Text("There was an issue in logging you in. Please try again in some time or check your credentials!", 14);
                        JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e1) {
                    System.out.println(e1);
                }
            }
            
        });
        JPanel containerBtn = new JPanel();
        containerBtn.setBackground(Color.WHITE);        
        containerBtn.add(loginBtn.getButton());
        

        Text getStarted = new Text("Don't have an account yet? Get started", 12);
        Text here = new Text("here.", 12);
        here.getTitle().setForeground(constants.getSecondaryColor());
        here.getTitle().addMouseListener(handler2);
        here.getTitle().setCursor(new Cursor(Cursor.HAND_CURSOR));

        Font font = here.getTitle().getFont();

        @SuppressWarnings("unchecked") //suppress check for unchecked cast(type safety) 
        Map<TextAttribute, Integer> attributes = (Map<TextAttribute, Integer>) font.getAttributes(); //type safety map to get all attributes of font

        attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON); //set jlabel text to underlined
        here.getTitle().setFont(font.deriveFont(attributes));

        JPanel containerContinue = new JPanel();
        containerContinue.setBackground(Color.WHITE);
        containerContinue.add(getStarted.getTitle());
        containerContinue.add(here.getTitle());

        panel.add(panelBtnBack);
        panel.add(headerPanel);
        panel.add(tfPanel);
        panel.add(containerBtn); //adding to a new panel and then adding to the main panel centers component automatically
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(containerContinue);
        panel.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (Main.getCards().getLayout());
            cl.show(Main.getCards(), "HomeScreen");
        }
    }

    private class ButtonHandler2 implements MouseListener { //mouse listener takes in mandatory all mouse events

        @Override
        public void mouseClicked(MouseEvent e) {
            CardLayout cl = (CardLayout) (Main.getCards().getLayout());
            cl.show(Main.getCards(), "Register");
        }

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {}

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    }

    public JPanel getPanel(){
        return panel;
    }
}