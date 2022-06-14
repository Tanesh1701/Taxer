package screens;
import javax.swing.JPanel;
import models.Button;
import models.Constants;
import models.Text;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;

public class HomeScreen extends JPanel{
    Constants constants = new Constants();
    private JPanel mainPanel = new JPanel();
    Register register = new Register();
    Button getStartedBtn;

    public HomeScreen() {
        //mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setLayout(new BorderLayout());
        Text homeScreenHeader = new Text("Taxer", 18);
        homeScreenHeader.getTitle().setForeground(constants.getSecondaryColor());
        getStartedBtn = new Button("Get Started");
        ButtonHandler handler = new ButtonHandler();
        getStartedBtn.getButton().addActionListener(handler);
        mainPanel.add(homeScreenHeader.getTitle(), BorderLayout.NORTH);
        mainPanel.add(getStartedBtn.getButton(), BorderLayout.SOUTH);
        mainPanel.setVisible(true);
        mainPanel.setBackground(constants.getPrimaryColor());
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout) (Main.getCards().getLayout());
            cl.show(Main.getCards(), "Login");
        }
    }

    public  JPanel getMainPanel() {
        return mainPanel;
    }
}
