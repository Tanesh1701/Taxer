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

public class Register extends JPanel{
    private Text header = new Text("Register Now", 18);
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    Button registerButton;
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

        headerPanel.add(header.getTitle());
        headerPanel.setBackground(constants.getPrimaryColor());

        tfPanel.setLayout(new GridBagLayout());     
        tfPanel.setBackground(constants.getPrimaryColor());  
        GridBagConstraints gbc = new GridBagConstraints();

        textfieldFullName = new Field("Full Name:");
        textfieldUserName = new Field("Username:");
        textfieldEmail = new Field("Email:");
        textfieldPassword = new Field("Password:");

        gbc.insets = new Insets(0, 0, 30, 0);

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

        registerButton = new Button("Register");
        registerButton.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.getButton().setPreferredSize(new Dimension(100,40));
        ButtonHandler handler = new ButtonHandler();
        registerButton.getButton().addActionListener(handler);
        JPanel containerBtn = new JPanel();
        containerBtn.setBackground(Color.WHITE);        
        containerBtn.add(registerButton.getButton());

        panel.add(headerPanel);
        panel.add(tfPanel);
        panel.add(containerBtn);
        panel.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        
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

            if(fullname.isEmpty() || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (password.length() >= 8) {
                    if (!(fullname.matches(".*\\d.*"))) {
                        if (email.contains("@")) {
                            try {
                                uda.insert(user);
                                UserRegistered = uda.getUser(username, password);
                                if (UserRegistered != null) {
                                    Main.getFrame().dispose();
                                    Dashboard dashboard = new Dashboard(UserRegistered);
                                    dashboard.setVisible(true);
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