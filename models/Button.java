package models;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JButton;

public class Button extends JButton {
    private JButton button;
    Constants constants = new Constants();

    public Button(String buttonText) {
        button = new JButton(buttonText);
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(60,40));
        button.setBackground(constants.getSecondaryColor());
        button.setForeground(constants.getPrimaryColor());
        button.setBorderPainted(false);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(Color.black);
            }
        
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(constants.getSecondaryColor());
            }
        });    
    }
    public JButton getButton() {
        return button;
    }
}
