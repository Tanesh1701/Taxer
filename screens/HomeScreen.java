package screens;
import java.awt.*;
import models.Text;
import javax.swing.*;
import models.Button;
import javax.swing.Box;
import models.Constants;
import javax.swing.BoxLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JPanel{
    Constants constants = new Constants();
    private JPanel mainPanel = new JPanel(), buttonPanel = new JPanel(), headerPanel = new JPanel(),
    middlePanel = new JPanel(), sectionPanel = new JPanel(), panel1 = new JPanel(), panel2 = new JPanel(),
    panel3 = new JPanel();
    Register register = new Register();
    Button getStartedBtn;

    public HomeScreen() {
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(constants.getPrimaryColor());

        headerPanel.setLayout(new FlowLayout());
        headerPanel.setBackground(constants.getSecondaryColor());
        Text homeScreenHeader = new Text("W e l c o m e     T o     T a x e r", 18);
        headerPanel.add(Box.createVerticalStrut(130), homeScreenHeader);
        homeScreenHeader.getTitle().setForeground(constants.getPrimaryColor());
        headerPanel.add(homeScreenHeader.getTitle());
        mainPanel.add(headerPanel, BorderLayout.PAGE_START);

        middlePanel.setLayout(new FlowLayout());
        middlePanel.setBackground(constants.getPrimaryColor());
        Text homeScreenHeader2 = new Text("Committed To Helping You Succeed.", 15);
        middlePanel.add(Box.createVerticalStrut(100), homeScreenHeader2);
        homeScreenHeader2.getTitle().setForeground(constants.getFontColor());
        middlePanel.add(homeScreenHeader2.getTitle());
        mainPanel.add(middlePanel);

        sectionPanel.setLayout(new GridBagLayout());
        sectionPanel.setBackground(constants.getPrimaryColor());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(0, 5, 0, 55);
        panel1.setLayout(new FlowLayout());
        panel1.setPreferredSize(new Dimension(170, 170));
        ImageIcon pic1 = new ImageIcon("./Assets/Images/pic1.png");
        JLabel img1 = new JLabel(pic1);
        panel1.add(img1);
        Text label1 = new Text("Experienced", 16);
        img1.setBorder(BorderFactory.createEmptyBorder(20,0,10,0) );
        panel1.add(label1.getTitle());
        gbc.gridx = 0; 
        gbc.gridy = 0;
        sectionPanel.add(panel1, gbc);

        gbc.insets = new Insets(0, 0, 0, 5);
        panel2.setLayout(new FlowLayout());
        panel2.setPreferredSize(new Dimension(170, 170));
        ImageIcon pic2 = new ImageIcon("./Assets/Images/pic2.png");
        JLabel img2 = new JLabel(pic2);
        panel2.add(img2);
        Text label2 = new Text("Well-disposed", 16);
        img2.setBorder(BorderFactory.createEmptyBorder(20,0,10,0) );
        panel2.add(label2.getTitle());
        gbc.gridx = 1; 
        gbc.gridy = 0;
        sectionPanel.add(panel2, gbc);

        gbc.insets = new Insets(0, 50, 0, 0);
        panel3.setLayout(new FlowLayout());
        panel3.setPreferredSize(new Dimension(170, 170));
        ImageIcon pic3 = new ImageIcon("./Assets/Images/pic3.png");
        JLabel img3 = new JLabel(pic3);
        panel3.add(img3);
        Text label3 = new Text("Proficient", 16);
        img3.setBorder(BorderFactory.createEmptyBorder(20,0,10,0) );
        panel3.add(label3.getTitle());
        gbc.gridx = 2; 
        gbc.gridy = 0;
        sectionPanel.add(panel3, gbc);

        mainPanel.add(sectionPanel);

        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.setBackground(Color.WHITE);
        getStartedBtn = new Button("Get Started");
        buttonPanel.add(Box.createVerticalStrut(100), getStartedBtn);
        ButtonHandler handler = new ButtonHandler();
        getStartedBtn.getButton().addActionListener(handler);
        getStartedBtn.getButton().setPreferredSize(new Dimension(170, 45));
        getStartedBtn.getButton().setCursor(new Cursor(Cursor.HAND_CURSOR));
        buttonPanel.add(getStartedBtn.getButton());
        mainPanel.add(buttonPanel, BorderLayout.PAGE_END);

        mainPanel.setVisible(true);
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