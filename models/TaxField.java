package models;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;

public class TaxField {
    JPanel taxFieldPanel = new JPanel();
    JTextField taxTextField = new JTextField(20);
    
    public TaxField(String text) {
        taxFieldPanel.setLayout(new GridLayout(1,0));
        taxFieldPanel.setBackground(Color.WHITE);

        JLabel textLabel = new JLabel(text);

        taxTextField.setBackground(Color.white);
        taxTextField.setMaximumSize(new Dimension(taxTextField.getPreferredSize()));
        taxTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#565656")));

        taxFieldPanel.add(textLabel);
        taxFieldPanel.add(taxTextField);
    }

    public JPanel getTaxFieldPanel() {
        return taxFieldPanel;
    }
    public JTextField getTaxTextField() {
        return taxTextField;
    }
}
