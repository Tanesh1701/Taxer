package screens;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Main extends JFrame{
    static JPanel cards;
    private CardLayout cardLayout;

    public Main() {
        super("Taxer");
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        Register register = new Register();
        HomeScreen homeScreen = new HomeScreen();
        //main.add(register.getPanel());
        cards.add(homeScreen.getMainPanel(), "HomeScreen");
        cards.add(register.getPanel(), "Register");
        cards.setOpaque(true);
        add(cards);
        setSize(750,600);
        setVisible(true);
    }

    public static JPanel getCards() {
        return cards;
    }

    public static void main(String[] args) {
        new Main();
    }
}
