package screens;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import models.Button;
import models.Constants;
import models.Field;
import models.Text;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Register extends JPanel{
    private Text header = new Text("Register Now", 18);
    private JPanel panel = new JPanel();
    private JPanel headerPanel = new JPanel();
    private JPanel tfPanel = new JPanel();
    Button registerButton;
    Constants constants = new Constants();

    public Register() {
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.setBackground(Color.white);

        headerPanel.add(header.getTitle());
        headerPanel.setBorder(new EmptyBorder(0, 200, 0, 0)); //make title center
        headerPanel.setBackground(constants.getPrimaryColor());
        
        Field textfieldFullName = new Field("Full Name:");
        Field textfieldUserName = new Field("Username:");
        Field textfieldEmail = new Field("Email:");
        Field textfieldPassword = new Field("Password:");
        tfPanel.setBorder(new EmptyBorder(0, -250, 0, 0));
        tfPanel.setLayout(new BoxLayout(tfPanel, BoxLayout.PAGE_AXIS));
        tfPanel.add(headerPanel);
        tfPanel.add(textfieldFullName.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40))); //create some space between elements
        tfPanel.add(textfieldUserName.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tfPanel.add(textfieldEmail.getTextfieldPanel());
        tfPanel.add(Box.createRigidArea(new Dimension(0, 40)));
        tfPanel.add(textfieldPassword.getTextfieldPanel());


        registerButton = new Button("Register");
        registerButton.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        registerButton.getButton().setPreferredSize(new Dimension(100,40));
        ButtonHandler handler = new ButtonHandler();
        registerButton.getButton().addActionListener(handler);
        JPanel containerBtn = new JPanel();
        containerBtn.setBackground(Color.WHITE);        
        containerBtn.add(registerButton.getButton());

        tfPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        panel.add(tfPanel);
        panel.add(containerBtn);
        tfPanel.setBackground(constants.getPrimaryColor());
        panel.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (Main.getCards().getLayout());
            cl.show(Main.getCards(), "HomeScreen");
        }
    }

    public JPanel getPanel() {
        return panel;
    }

}