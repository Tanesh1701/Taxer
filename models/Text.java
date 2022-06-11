package models;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Text extends JLabel{ //model class for headers
    private String titleText;
    private JLabel title;

    public Text(String titleText, int fontSize) {
        this.titleText = titleText;
        title = new JLabel();
        title.setText(titleText);
        title.setForeground(Color.decode("#565656"));
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            title.setFont(font.deriveFont(Font.PLAIN, fontSize));
        } catch (Exception e) {
            System.out.println(e);
        } 
    }

    public String getTitleText() {
        return titleText;
    }

    public void setTitleText(String titleText) {
        this.titleText = titleText;
    }

    public JLabel getTitle() {
        return title;
    }
}
