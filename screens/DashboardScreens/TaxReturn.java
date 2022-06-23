package screens.DashboardScreens;
import javax.swing.*;
import models.Button;
import models.TaxField;
import models.Text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class TaxReturn extends JPanel{

    JPanel frame = new JPanel();
    JPanel fieldPanel, mainPanel, radioBtnPanel, ratePanel;

    Text employeeID = new Text("Employee Identification", 12);
    Text employeeLabel = new Text("Job Position", 12);
    Text iet = new Text("Income Exemptions Threshold", 12);
    Text noDependent = new Text("An employee with no dependents", 12);
    Text oneDependent = new Text("An employee with dependent(s)", 12);
    Text noDependentAmt = new Text("Rs 275, 000", 12);
    Text oneDependentAmt = new Text("Rs 385, 000", 12);
    Text taxRate;


    JTextField textFieldRate = new JTextField(10);

    JRadioButton radioButton1 = new JRadioButton("Mr."), radioButton2 = new JRadioButton("Mrs."), 
    radioButton3 = new JRadioButton("Miss");

    JCheckBox checkBox1 = new JCheckBox(), checkBox2 = new JCheckBox();

    Button btnSubmit;
        

    JSeparator separator = new JSeparator();


    public TaxReturn(){
        //radioBtnPanel and its components
        radioBtnPanel = new JPanel();
        radioBtnPanel.setLayout(new FlowLayout());
        ButtonGroup bgRadio = new ButtonGroup();
        ButtonGroup bgCheck = new ButtonGroup();
        bgCheck.add(checkBox1);
        bgCheck.add(checkBox2);
        bgRadio.add(radioButton1);
        bgRadio.add(radioButton2);
        bgRadio.add(radioButton3);
        radioBtnPanel.add(radioButton1);
        radioBtnPanel.add(radioButton2);
        radioBtnPanel.add(radioButton3);
        radioButton1.setBackground(Color.WHITE);
        radioButton2.setBackground(Color.WHITE);
        radioButton3.setBackground(Color.WHITE);
        radioBtnPanel.setBackground(Color.WHITE);
        radioBtnPanel.setBorder(BorderFactory.createEmptyBorder(0,250,0,0));

        JSeparator js = new JSeparator();
        js.setBackground(Color.decode("#BBBBBB"));

        //fieldPanel and its components
        fieldPanel = new JPanel();
        fieldPanel.setBackground(Color.WHITE);
        fieldPanel.setLayout(new GridBagLayout());
        fieldPanel.setBorder(BorderFactory.createEmptyBorder(20,10,20,10));

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.insets = new Insets(5, 10, 5, 20);
        gbc1.fill = GridBagConstraints.HORIZONTAL;

        gbc1.gridx = 0; 
        gbc1.gridy = 1; 
        fieldPanel.add(employeeID.getTitle(), gbc1);
        gbc1.gridx = 0; 
        gbc1.gridy = 1; 
        fieldPanel.add(radioBtnPanel, gbc1);        

        TaxField taxFieldName = new TaxField("Full Name");
        gbc1.gridx = 0;
        gbc1.gridy = 2;
        fieldPanel.add(taxFieldName.getTaxFieldPanel(), gbc1);

        TaxField taxfieldAddress = new TaxField("Address");
        gbc1.gridx = 0;
        gbc1.gridy = 3;
        fieldPanel.add(taxfieldAddress.getTaxFieldPanel(), gbc1);

        TaxField taxFieldContact = new TaxField("Contact num");
        gbc1.gridx = 0;
        gbc1.gridy = 4;
        fieldPanel.add(taxFieldContact.getTaxFieldPanel(), gbc1);

        TaxField taxFieldNIC = new TaxField("National Identity Card (NIC)");
        gbc1.gridx = 0;
        gbc1.gridy = 5;
        fieldPanel.add(taxFieldNIC.getTaxFieldPanel(), gbc1);

        TaxField taxFieldTAN = new TaxField("Tax Account Number (TAN)");
        gbc1.gridx = 0;
        gbc1.gridy = 6;
        fieldPanel.add(taxFieldTAN.getTaxFieldPanel(), gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 7;
        fieldPanel.add(Box.createVerticalStrut(10), gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 8;
        fieldPanel.add(new JSeparator(), gbc1);

        gbc1.gridx = 0; 
        gbc1.gridy = 9; 
        fieldPanel.add(employeeLabel.getTitle(), gbc1);

        TaxField taxFieldTypeEmp = new TaxField("Type Of Employment");
        gbc1.gridx = 0;
        gbc1.gridy = 10;
        fieldPanel.add(taxFieldTypeEmp.getTaxFieldPanel(), gbc1);

        TaxField taxFieldYIncome = new TaxField("Yearly Income");
        gbc1.gridx = 0;
        gbc1.gridy = 11;
        fieldPanel.add(taxFieldYIncome.getTaxFieldPanel(), gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 12;
        fieldPanel.add(Box.createVerticalStrut(10), gbc1);

        gbc1.gridx = 0;
        gbc1.gridy = 13;
        fieldPanel.add(new JSeparator(), gbc1);
        
        gbc1.gridx = 0; gbc1.gridy = 14; fieldPanel.add(iet.getTitle(), gbc1);

        noDependentAmt.getTitle().setBorder(BorderFactory.createEmptyBorder(0,300,0,0));
        gbc1.gridx = 0; 
        gbc1.gridy = 15; 
        fieldPanel.add(noDependent.getTitle(), gbc1);
        gbc1.gridx = 0; 
        gbc1.gridy = 15; 
        fieldPanel.add(noDependentAmt.getTitle(), gbc1);
        gbc1.insets  = new Insets(0,405,0,0);
        gbc1.gridx = 0; 
        gbc1.gridy = 15; 
        fieldPanel.add(checkBox1, gbc1);

        gbc1.insets = new Insets(5, 10, 5, 20);

        oneDependentAmt.getTitle().setBorder(BorderFactory.createEmptyBorder(0,300,0,0));
        gbc1.gridx = 0; 
        gbc1.gridy = 16; 
        fieldPanel.add(oneDependent.getTitle(), gbc1);
        gbc1.gridx = 0; 
        gbc1.gridy = 16; 
        fieldPanel.add(oneDependentAmt.getTitle(), gbc1);
        gbc1.insets  = new Insets(0,405,0,0);
        gbc1.gridx = 0; 
        gbc1.gridy = 16; 
        fieldPanel.add(checkBox2, gbc1);

        
        checkBox1.setBackground(Color.WHITE);
        checkBox2.setBackground(Color.WHITE);

        //mainPanel and its components
        mainPanel = new JPanel();
        mainPanel.setBorder(BorderFactory.createEmptyBorder(5,25,25,25));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        Text mainTitle = new Text("Employee Declaration Form - Income year 2022", 15);
        mainTitle.getTitle().setAlignmentX(JLabel.CENTER_ALIGNMENT);
        
        //ratePanel to display tax rate
        ratePanel = new JPanel();
        ratePanel.setLayout(new FlowLayout());
        taxRate = new Text("Tax Rate:", 12);
        ratePanel.add(taxRate.getTitle());
        ratePanel.add(textFieldRate);
        ratePanel.setBackground(Color.WHITE);
        ratePanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        btnSubmit = new Button("Submit");
        ButtonHandler handler = new ButtonHandler();
        btnSubmit.getButton().addActionListener(handler);
        btnSubmit.getButton().setAlignmentX(Component.CENTER_ALIGNMENT);

        mainPanel.add(mainTitle.getTitle());
        mainPanel.add(fieldPanel);
        mainPanel.add(ratePanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        mainPanel.add(btnSubmit.getButton());

        //final frame settings
        frame.setBackground(Color.WHITE);
        frame.add(mainPanel); 
        frame.setVisible(true);
    }

    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e){
            
        }
    }

    public JPanel getPanel(){
        return frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

}