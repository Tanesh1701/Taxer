package models;
import java.awt.Color;

public class Constants {
    private final Color fontColor = Color.decode("#565656");
    private final Color primaryColor = Color.WHITE;
    private final Color secondaryColor = Color.decode("#5200FF");
    
    public Color getFontColor() {
       return fontColor;
    }

    public Color getPrimaryColor() {
        return primaryColor;
    }

    public Color getSecondaryColor() {
        return secondaryColor;
    }
}
