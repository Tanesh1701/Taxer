package screens.DashboardScreens;
import models.*;
import java.awt.*;
import javax.swing.*;
import models.Button;
import java.awt.Color;
import java.awt.Dimension;
import Database.UserDaoAccesser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Settings extends JPanel {
    private Text header = new Text("Change user details", 18);
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    private JPanel panelBtnBack = new JPanel();
    Button updateButton;
    Constants constants = new Constants();
    User updateUser = new User();
    UserDaoAccesser uda = new UserDaoAccesser();
    Field textfieldFullName;
    Field textfieldEmail;
    Field textfieldPassword;
    int id = 0;

    public Settings(User user) {
        id = user.getId();
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

        headerPanel.add(header.getTitle());
        headerPanel.setPreferredSize(new Dimension(100, 50));
        headerPanel.setBackground(constants.getPrimaryColor());

        tfPanel.setLayout(new GridBagLayout());     
        tfPanel.setBackground(constants.getPrimaryColor());  
        GridBagConstraints gbc = new GridBagConstraints();

        textfieldFullName = new Field("Full Name:");
        textfieldEmail = new Field("Email:");
        textfieldPassword = new Field("Password:");

        gbc.insets = new Insets(0, 0, 20, 0);

        gbc.gridx = 0; 
        gbc.gridy = 1; 
        tfPanel.add(textfieldFullName.getTextfieldPanel(), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 2; 
        
        gbc.gridx = 0; 
        gbc.gridy = 3; 
        tfPanel.add(textfieldEmail.getTextfieldPanel(), gbc);
        
        gbc.gridx = 0; 
        gbc.gridy = 4; 
        tfPanel.add(textfieldPassword.getTextfieldPanel(), gbc);      

        tfPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        updateButton = new Button("Update");
        updateButton.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        updateButton.getButton().setPreferredSize(new Dimension(100,40));
        ButtonHandler2 handler = new ButtonHandler2();
        updateButton.getButton().addActionListener(handler);
        JPanel containerBtn = new JPanel();
        containerBtn.setBackground(Color.WHITE);
        containerBtn.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));        
        containerBtn.add(updateButton.getButton());

        panel.add(panelBtnBack);
        panel.add(headerPanel);
        panel.add(tfPanel);
        panel.add(containerBtn);
        panel.setVisible(true);
    }

    private class ButtonHandler2 implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            String fullname = textfieldFullName.getTextfield().getText();
            String email = textfieldEmail.getTextfield().getText();
            String password = textfieldPassword.getTextfield().getText();
            updateUser.setFullName(fullname);
            updateUser.setEmail(email);
            updateUser.setPassword(password);
            Text errorMsg = new Text("You cannot leave any empty fields!", 14);

            if(fullname.isEmpty() || email.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (password.length() >= 8) {
                    if (!(fullname.matches(".*\\d.*"))) {
                        if (email.contains("@")) {
                            try {
                                uda.update(updateUser, id);
                                errorMsg = new Text("Your details have successfully been updated!", 14);
                                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Success", JOptionPane.INFORMATION_MESSAGE);
                                textfieldFullName.getTextfield().setText("");
                                textfieldEmail.getTextfield().setText("");
                                textfieldPassword.getTextfield().setText("");
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
