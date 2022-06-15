package screens;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Dimension;
import models.Field;
import models.Text;
import models.Button;
import models.Constants;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.util.Map;

public class Login extends JPanel{

    private Text header = new Text("Login", 18);
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    Constants constants = new Constants();

    public Login(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        headerPanel.add(header.getTitle());
        headerPanel.setBackground(constants.getPrimaryColor());

        panel.setBackground(constants.getPrimaryColor());
        tfPanel.setBackground(constants.getPrimaryColor());

        tfPanel.setLayout(new GridBagLayout());             //changements till line 52
        GridBagConstraints gbc = new GridBagConstraints();

        Field textFieldUsername = new Field("Username");
        Field textFieldPassword = new Field("Password");

        gbc.insets = new Insets(0, 0, 60, 0);

        gbc.gridx = 0; gbc.gridy = 1; tfPanel.add(textFieldUsername.getTextfieldPanel(), gbc);
        gbc.gridx = 0; gbc.gridy = 2; tfPanel.add(textFieldPassword.getTextfieldPanel(), gbc);
        
        ButtonHandler handler = new ButtonHandler();

        Button loginBtn = new Button("Login");
        loginBtn.getButton().setPreferredSize(new Dimension(80,40));
        loginBtn.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        loginBtn.getButton().addActionListener(e -> {
            Main.getFrame().dispose();
            Dashboard dashboard = new Dashboard();
            dashboard.setVisible(true);
        });
        JPanel containerBtn = new JPanel();
        containerBtn.setBackground(Color.WHITE);        
        containerBtn.add(loginBtn.getButton());
        

        Text getStarted = new Text("Don't have an account yet? Get started", 12);
        Text here = new Text("here.", 12);
        here.getTitle().setForeground(constants.getSecondaryColor());
        here.getTitle().addMouseListener(handler);
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

        panel.add(headerPanel);
        panel.add(tfPanel);
        panel.add(containerBtn); //adding to a new panel and then adding to the main panel centers component automatically
        panel.add(Box.createRigidArea(new Dimension(0,20)));
        panel.add(containerContinue);
        panel.setVisible(true);
    }


    private class ButtonHandler implements MouseListener { //mouse listener takes in mandatory all mouse events

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