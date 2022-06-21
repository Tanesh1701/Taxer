package screens;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Main extends JFrame{
    static JPanel cards;
    static JFrame frame =  new JFrame();
    private CardLayout cardLayout;

    public Main() {
        frame.setTitle("Taxer");
        ImageIcon img = new ImageIcon(getClass().getResource("../Assets/Logo/1024.png"));
        frame.setIconImage(img.getImage());
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        Register register = new Register();
        HomeScreen homeScreen = new HomeScreen();
        Login login = new Login();
        cards.add(homeScreen.getMainPanel(), "HomeScreen");
        cards.add(login.getPanel(), "Login");
        cards.add(register.getPanel(), "Register");
        cards.setOpaque(true);
        frame.add(cards);
        frame.setSize(750,600);
        //setResizable(false);
        frame.setVisible(true);
    }

    public static JPanel getCards() {
        return cards;
    }

    public static JFrame getFrame() {
        return frame;
    }

    public static void main(String[] args) {
        new Main();
    }
}
