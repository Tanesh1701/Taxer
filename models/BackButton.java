package models;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.Font;

public class BackButton {
    private JButton button;
    Constants constants = new Constants();

    public BackButton(String buttonText) {

        button = new JButton(buttonText);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(60,40));
        button.setForeground(constants.getSecondaryColor());
        button.setBackground(constants.getPrimaryColor());
        button.setBorderPainted(false);
        UIManager.put("Button.select", Color.white);
        button.setFocusable(false);
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            button.setFont(font.deriveFont(Font.PLAIN, 15));
        } catch (Exception e) {
            System.out.println(e);
        } 
        button.addMouseListener(new java.awt.event.MouseAdapter() {

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(constants.getPrimaryColor());
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button.setBackground(constants.getPrimaryColor());
            }
        });  
    }
    public JButton getBackButton() {
        return button;
    }
}
