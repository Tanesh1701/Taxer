package models;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Field extends JTextField{
    private JTextField textfield;
    Constants constants = new Constants();

    public Field() {
        textfield = new JTextField(30);
        textfield.setMaximumSize(new Dimension(textfield.getPreferredSize()));
        textfield.setBackground(Color.white);
        textfield.setForeground(constants.getFontColor());
        textfield.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.GRAY));
    }

    public JTextField getTextfield() {
        return textfield;
    }
}
