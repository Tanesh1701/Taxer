package screens;
import javax.swing.*;
import java.awt.Dimension;
import javax.swing.border.EmptyBorder;
import models.Field;
import models.Title;
import models.Button;
import models.Constants;

public class Login extends JPanel{

    private Title header = new Title("Login");
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    Constants constants = new Constants();

    public Login(){
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

        headerPanel.add(header.getTitle());
        headerPanel.setBorder(new EmptyBorder(0, 200, 0, 0));
        headerPanel.setBackground(constants.getPrimaryColor());

        panel.setBackground(constants.getPrimaryColor());
        panel.setBorder(new EmptyBorder(30, 0, 80, 0));

        Field textFieldUsername = new Field("Username");
        Field textFieldPassword = new Field("Password");

        tfPanel.setBorder(new EmptyBorder(0, -200, 120, 0));
        tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.PAGE_AXIS));

        tfPanel.add(headerPanel);
        tfPanel.add(textFieldUsername.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tfPanel.add(textFieldPassword.getTextfieldPanel());

        Button loginBtn = new Button("Login");
        //tfPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        panel.add(tfPanel);
        panel.add(Box.createRigidArea(new Dimension(117, 0)));
        panel.add(loginBtn.getButton());
        //panel.add(new JLabel("Register Here"));

        tfPanel.setBackground(constants.getPrimaryColor());
        panel.setVisible(true);
    }

    public JPanel getPanel(){
        return panel;
    }
}