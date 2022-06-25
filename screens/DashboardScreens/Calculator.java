package screens.DashboardScreens;
import models.*;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class Calculator extends JPanel{

    private JPanel numberKeysPanel, panel;
    private GridLayout numberKeysGrid;
    private JTextField calculationArea;
    private JButton numberKey;

    public Calculator(){

        numberKeysGrid = new GridLayout( 4, 4, 0, 0);
        calculationArea = new JTextField(30);
        numberKeysPanel = new JPanel();
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(0,1,0,0));

        Text title = new Text("Calculator", 20);
        panel.add(title.getTitle(), BorderLayout.NORTH);
        title.getTitle().setBorder(BorderFactory.createEmptyBorder(50,0,50,10));

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            calculationArea.setFont(font.deriveFont(Font.PLAIN, 24f));
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] labels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};

        for(int counter = 0; counter < labels.length; counter++){
            numberKey = new JButton(labels[counter]);
            numberKeysPanel.add(numberKey);
        }
        numberKeysPanel.setLayout(numberKeysGrid);
        numberKeysPanel.setPreferredSize(new Dimension(600, 500));
        numberKeysPanel.setBorder(BorderFactory.createEmptyBorder(-1,0,-2,0));

        calculationArea.setPreferredSize(new Dimension(600, 60));
        panel.add(calculationArea, BorderLayout.CENTER);
        panel.add(numberKeysPanel, BorderLayout.SOUTH);
        panel.setVisible(true);
    }

    public JPanel getPanel() {
        return panel;
    }

    // public static void main(String[] args) {
    //     JFrame f = new JFrame();
    //     Calculator tr = new Calculator();

    //     f.add(tr.getPanel());
    //     f.setSize(new Dimension(600,600));
    //     f.setVisible(true);
    // }
}