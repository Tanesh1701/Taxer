package screens;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import models.Field;
import models.Title;

public class Register extends JPanel{
    private Title header = new Title("Register Now");
    private JPanel panel = new JPanel();

    public Register() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(header.getTitle());
        panel.setBackground(Color.white);
        Field textfieldFullName = new Field();
        Field textfieldUserName = new Field();
        Field textfieldEmail = new Field();
        Field textfieldPassword = new Field();
        panel.add(textfieldFullName.getTextfield());
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(textfieldUserName.getTextfield());
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(textfieldEmail.getTextfield());
        panel.add(Box.createRigidArea(new Dimension(0, 40)));
        panel.add(textfieldPassword.getTextfield());
        
        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }
}