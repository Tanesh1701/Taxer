package models;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class Title extends JLabel{ //model class for headers
    private String titleText;
    private JLabel title;

    public Title(String titleText) {
        this.titleText = titleText;
        title = new JLabel();
        title.setText(titleText);
        title.setForeground(Color.decode("#565656"));
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Title.class.getResourceAsStream("./assets/Fonts/VarelaRound-Regular.TTF"));
            title.setFont(font.deriveFont(Font.PLAIN, 17f));
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
