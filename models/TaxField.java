package models;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;

public class TaxField {
    JPanel taxFieldPanel = new JPanel();
    JTextField taxTextField = new JTextField(20);
    Constants constants = new Constants();
    
    public TaxField(String text) {
        taxFieldPanel.setLayout(new GridLayout(1,0));
        taxFieldPanel.setBackground(Color.WHITE);

        // JLabel textLabel = new JLabel(text);
        Text taxFieldLabel = new Text(text, 12);

        taxTextField.setBackground(Color.white);
        taxTextField.setMaximumSize(new Dimension(taxTextField.getPreferredSize()));
        taxTextField.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#565656")));

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            taxTextField.setFont(font.deriveFont(Font.PLAIN, 12f));
        } catch (Exception e) {
            System.out.println(e);
        }

        taxFieldPanel.add(taxFieldLabel.getTitle());
        taxFieldPanel.add(taxTextField);
    }

    public JPanel getTaxFieldPanel() {
        return taxFieldPanel;
    }
    public JTextField getTaxTextField() {
        return taxTextField;
    }
}
