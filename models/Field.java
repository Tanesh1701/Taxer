package models;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Field extends JPanel{ //model class for textfields
    private JTextField textfield;
    private JPanel textfieldPanel;
    private String label;
    Constants constants = new Constants();

    public Field(String label) {
        this.label = label;
        textfieldPanel = new JPanel();
        textfieldPanel.setLayout(new BoxLayout(textfieldPanel, BoxLayout.PAGE_AXIS));
        textfieldPanel.setBackground(constants.getPrimaryColor());
        JLabel textfieldLabel = new JLabel(label);
        textfieldLabel.setForeground(constants.getFontColor());
        textfieldLabel.setHorizontalAlignment(JLabel.CENTER);
        textfieldLabel.setVerticalAlignment(JLabel.CENTER);
        textfieldPanel.add(textfieldLabel);
        textfield = new JTextField(40);
        textfield.setHorizontalAlignment(JTextField.CENTER);
        //textfield.setVerticalAlignment(JTextField.CENTER);
        textfield.setMaximumSize(new Dimension(textfield.getPreferredSize()));
        textfield.setBackground(constants.getPrimaryColor());
        textfield.setForeground(constants.getFontColor());
        textfield.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.decode("#565656")));
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            textfield.setFont(font.deriveFont(Font.PLAIN, 14f));
            textfieldLabel.setFont(font.deriveFont(Font.PLAIN, 15f));
        } catch (Exception e) {
            System.out.println(e);
        }
        textfieldPanel.add(Box.createRigidArea(new Dimension(0, 8)));
        textfieldPanel.add(textfield);
        textfieldPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        textfieldPanel.setVisible(true);
    }

    public JTextField getTextfield() {
        return textfield;
    }

    public void setTextfield(JTextField textfield) {
        this.textfield = textfield;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public JPanel getTextfieldPanel() {
        return textfieldPanel;
    }
}