import javax.swing.JFrame;
import screens.Register;

public class Main extends JFrame{
    public static void main(String[] args) {
        Main main = new Main();
        Register register = new Register();
        main.add(register.getPanel());
        main.setSize(750,600);
        main.setVisible(true);
        main.setResizable(false);
    }

    public Main() {
        super("Taxer");
    }
}
