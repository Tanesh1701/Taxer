package screens;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Main extends JFrame{
    static JPanel cards;
    private CardLayout cardLayout;

    public Main() {
        super("Taxer");
        ImageIcon img = new ImageIcon(getClass().getResource("../Assets/Logo/1024.png"));
        setIconImage(img.getImage());
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        Register register = new Register();
        HomeScreen homeScreen = new HomeScreen();
        Login login = new Login();
        cards.add(homeScreen.getMainPanel(), "HomeScreen");
        cards.add(login.getPanel(), "Login");
        cards.add(register.getPanel(), "Register");
        cards.setOpaque(true);
        add(cards);
        setSize(750,600);
        setResizable(false);
        setVisible(true);
    }

    public static JPanel getCards() {
        return cards;
    }

    public static void main(String[] args) {
        new Main();
    }
}
