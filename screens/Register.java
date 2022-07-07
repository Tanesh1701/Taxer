package screens;
import models.*;
import java.awt.*;
import javax.swing.*;
import models.Button;
import java.awt.Color;
import java.awt.Dimension;
import Database.UserDaoAccesser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends JPanel{
    private Text header = new Text("Register Now", 18);
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    private JPanel panelBtnBack = new JPanel();
    Button registerButton;
    BackButton backBtn;
    Constants constants = new Constants();
    User user = new User();
    UserDaoAccesser uda = new UserDaoAccesser();
    Field textfieldFullName;
    Field textfieldUserName;
    Field textfieldEmail;
    Field textfieldPassword;

    public Register() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.white);

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
        headerPanel.setPreferredSize(new Dimension(100, 50));
        headerPanel.setBackground(constants.getPrimaryColor());

        tfPanel.setLayout(new GridBagLayout());     
        tfPanel.setBackground(constants.getPrimaryColor());  
        GridBagConstraints gbc = new GridBagConstraints();

        textfieldFullName = new Field("Full Name:");
        textfieldUserName = new Field("Username:");
        textfieldEmail = new Field("Email:");
        textfieldPassword = new Field("Password:");

        gbc.insets = new Insets(0, 0, 20, 0);

        gbc.gridx = 0; 
        gbc.gridy = 1; 
        tfPanel.add(textfieldFullName.getTextfieldPanel(), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        tfPanel.add(textfieldUserName.getTextfieldPanel(), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 3; 
        tfPanel.add(textfieldEmail.getTextfieldPanel(), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        tfPanel.add(textfieldPassword.getTextfieldPanel(), gbc);      

        tfPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        registerButton = new Button("Register");
        registerButton.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.getButton().setPreferredSize(new Dimension(100,40));
        ButtonHandler2 handler = new ButtonHandler2();
        registerButton.getButton().addActionListener(handler);
        JPanel containerBtn = new JPanel();
        containerBtn.setBackground(constants.getPrimaryColor());
        containerBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));        
        containerBtn.add(registerButton.getButton());

        panel.add(panelBtnBack);
        panel.add(headerPanel);
        panel.add(tfPanel);
        panel.add(containerBtn);
        panel.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (Main.getCards().getLayout());
            cl.show(Main.getCards(), "Login");
        }
    }

    private class ButtonHandler2 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            String fullname = textfieldFullName.getTextfield().getText();
            String username = textfieldUserName.getTextfield().getText();
            String email = textfieldEmail.getTextfield().getText();
            String password = textfieldPassword.getTextfield().getText();
            user.setFullName(fullname);
            user.setUserName(username);
            user.setEmail(email);
            user.setPassword(password);
            Text errorMsg = new Text("You cannot leave any empty fields!", 14);
            User UserRegistered = new User();
            Pattern p = Pattern.compile("[^A-Za-z0-9]");
            Matcher m = p.matcher(fullname);
            boolean nameHasInvalidChar = m.find();

            if(fullname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (password.length() >= 8) {
                    if (!(fullname.matches(".*\\d.*")) && !(nameHasInvalidChar)) {
                        if (email.contains("@")) {
                            try {
                                uda.insert(user);
                                UserRegistered = uda.getUser(username, password);
                                if (UserRegistered != null) {
                                    if (UserRegistered.getType().equals("user")) {
                                        Main.getFrame().dispose();
                                        Dashboard dashboard = new Dashboard(UserRegistered);
                                        dashboard.setVisible(true);
                                    } else {
                                        Main.getFrame().dispose();
                                        AdminDashboard adminDashboard = new AdminDashboard(UserRegistered);
                                        adminDashboard.setVisible(true);
                                    }
                                }
                                
                            } catch (Exception exception) {
                                System.out.println(exception);
                            }
                        } else {
                            errorMsg = new Text("Your email is invalid!", 14);
                            JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        errorMsg = new Text("Your name cannot contain any numbers or special characters!", 14);
                        JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    errorMsg = new Text("Your password should have 8 or more characters", 14);
                    JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

}