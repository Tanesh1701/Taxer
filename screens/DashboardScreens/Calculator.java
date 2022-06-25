package screens.DashboardScreens;
import models.*;
import models.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.awt.Color;

public class Calculator extends JPanel{

    private JPanel numberKeysPanel, panel;
    private GridLayout numberKeysGrid;
    private JTextField calculationArea;
    private JButton numberKey;
    String s0, s1, s2;

    public Calculator(){
        s0 = s1 = s2 = "";
        numberKeysGrid = new GridLayout( 4, 4, 0, 0);
        calculationArea = new JTextField(30);
        calculationArea.setHorizontalAlignment(JTextField.RIGHT);
        calculationArea.setEditable(false);
        numberKeysPanel = new JPanel();
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createEmptyBorder(0,1,0,0));

        Text title = new Text("Calculator", 20);
        panel.add(title.getTitle(), BorderLayout.NORTH);
        title.getTitle().setBorder(BorderFactory.createEmptyBorder(30,0,50,10));

        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            calculationArea.setFont(font.deriveFont(Font.PLAIN, 24f));
        } catch (Exception e) {
            System.out.println(e);
        }

        String[] labels = {"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
        ButtonHandler bh = new ButtonHandler();

        for(int counter = 0; counter < labels.length; counter++){
            numberKey = new JButton(labels[counter]);
            numberKey.setFocusable(false);
            numberKey.setBackground(new Constants().getPrimaryColor());
            numberKey.setForeground(new Constants().getSecondaryColor());
            numberKey.addActionListener(bh);
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

    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            String s = e.getActionCommand();

            if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
                // if operand is present then add to second no
                if (!s1.equals(""))
                    s2 = s2 + s;
                else
                    s0 = s0 + s;
     
                // set the value of text
                calculationArea.setText(s0 + s1 + s2);
            }
            else if (s.charAt(0) == '=') {
     
                double te;
     
                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
     
                // set the value of text
                calculationArea.setText(s0 + s1 + s2 + "=" + te);
     
                // convert it to string
                s0 = Double.toString(te);
     
                s1 = s2 = "";
            }
            else {
                // if there was no operand
                if (s1.equals("") || s2.equals(""))
                    s1 = s;
                // else evaluate
                else {
                    double te;
     
                    // store the value in 1st
                    if (s1.equals("+"))
                        te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                    else if (s1.equals("-"))
                        te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                    else if (s1.equals("/"))
                        te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                    else
                        te = (Double.parseDouble(s0) * Double.parseDouble(s2));
     
                    // convert it to string
                    s0 = Double.toString(te);
     
                    // place the operator
                    s1 = s;
     
                    // make the operand blank
                    s2 = "";
                }
     
                // set the value of text
                calculationArea.setText(s0 + s1 + s2);
            }
        }
    }

    public JPanel getPanel() {
        return panel;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        Calculator tr = new Calculator();

        f.add(tr.getPanel());
        f.setSize(new Dimension(600,600));
        f.setVisible(true);
    }
}