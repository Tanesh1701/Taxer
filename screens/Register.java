package screens;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Constants;
import models.Field;
import models.Title;

public class Register extends JPanel{
    private Title header = new Title("Register Now");
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    Constants constants = new Constants();

    public Register() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        headerPanel.add(header.getTitle());
        headerPanel.setBorder(new EmptyBorder(0, 250, 0, 0)); //make title center
        headerPanel.setBackground(constants.getPrimaryColor());
        panel.setBackground(Color.white);
        Field textfieldFullName = new Field("Full Name:");
        Field textfieldUserName = new Field("Username:");
        Field textfieldEmail = new Field("Email:");
        Field textfieldPassword = new Field("Password:");
        tfPanel.setBorder(new EmptyBorder(0, -250, 0, 0));
        tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.PAGE_AXIS));
        tfPanel.add(headerPanel);
        tfPanel.add(textfieldFullName.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tfPanel.add(textfieldUserName.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tfPanel.add(textfieldEmail.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tfPanel.add(textfieldPassword.getTextfieldPanel());
        panel.setBorder(new EmptyBorder(20, 0, 0, 0));
        panel.add(tfPanel);
        tfPanel.setBackground(constants.getPrimaryColor());
        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}