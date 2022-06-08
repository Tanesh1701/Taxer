package screens;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import models.Button;
import models.Constants;
import models.Title;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class HomeScreen extends JPanel{
    Constants constants = new Constants();
    private JPanel mainPanel = new JPanel();
    Register register = new Register();
    Button getStartedBtn;

    public HomeScreen() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        Title homeScreenHeader = new Title("Welcome to Taxer");
        getStartedBtn = new Button("Get Started");
        mainPanel.add(homeScreenHeader.getTitle());
        mainPanel.add(getStartedBtn.getButton());
        mainPanel.setVisible(true);
        mainPanel.setBackground(constants.getPrimaryColor());
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (Main.getCards().getLayout());
            cl.show(Main.getCards(), "Register");
        }
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
