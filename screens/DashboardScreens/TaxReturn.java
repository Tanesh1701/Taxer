package screens.DashboardScreens;
import java.io.*;
import java.awt.*;
import models.Text;
import javax.swing.*;

import Database.UserDaoAccesser;
import models.Button;
import models.TaxField;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.math.BigDecimal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    Formatter outfile;

    JTextField textFieldRate = new JTextField(10);

    JRadioButton radioButton1 = new JRadioButton("Mr."), radioButton2 = new JRadioButton("Mrs."), 
    radioButton3 = new JRadioButton("Miss.");

    JCheckBox checkBox1 = new JCheckBox(), checkBox2 = new JCheckBox();

    Button btnSubmit;

    JSeparator separator = new JSeparator();

    TaxField taxFieldName = new TaxField("Full name");
    TaxField taxfieldAddress = new TaxField("Address");
    TaxField taxFieldContact = new TaxField("Contact num");
    TaxField taxFieldNIC = new TaxField("National Identity Card (NIC)");
    TaxField taxFieldTAN = new TaxField("Tax Account Number (TAN)");
    TaxField taxFieldTypeEmp = new TaxField("Type Of Employment");
    TaxField taxFieldIncome = new TaxField("Yearly Income");

    double tax = 0, chargeableIncome = 0, dependent0 = 275000, dependent1 = 385000;
    String gender;

    UserDaoAccesser uda = new UserDaoAccesser();
    int id = 0;
    public TaxReturn(int userId){
        //radioBtnPanel and its components
        id = userId;
        radioBtnPanel = new JPanel();
        radioBtnPanel.setLayout(new FlowLayout());
        ButtonGroup bgRadio = new ButtonGroup();
        radioBtnPanel.add(radioButton1);
        radioBtnPanel.add(radioButton2);
        radioBtnPanel.add(radioButton3);
        bgRadio.add(radioButton1);
        bgRadio.add(radioButton2);
        bgRadio.add(radioButton3);
        RadioButtonHandler rbh = new RadioButtonHandler();
        radioButton1.addItemListener(rbh);
        radioButton2.addItemListener(rbh);
        radioButton3.addItemListener(rbh);

        ButtonGroup bgCheck = new ButtonGroup();
        bgCheck.add(checkBox1);
        bgCheck.add(checkBox2);
        CheckBoxHandler cbh = new CheckBoxHandler();
        checkBox1.addItemListener(cbh);
        checkBox2.addItemListener(cbh);
        
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            radioButton1.setFont(font.deriveFont(Font.PLAIN, 12f));
            radioButton2.setFont(font.deriveFont(Font.PLAIN, 12f));
            radioButton3.setFont(font.deriveFont(Font.PLAIN, 12f));
        } catch (Exception e) {
            System.out.println(e);
        }
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

        gbc1.gridx = 0;
        gbc1.gridy = 2;
        fieldPanel.add(taxFieldName.getTaxFieldPanel(), gbc1);

        
        gbc1.gridx = 0;
        gbc1.gridy = 3;
        fieldPanel.add(taxfieldAddress.getTaxFieldPanel(), gbc1);


        gbc1.gridx = 0;
        gbc1.gridy = 4;
        fieldPanel.add(taxFieldContact.getTaxFieldPanel(), gbc1);

       
        gbc1.gridx = 0;
        gbc1.gridy = 5;
        fieldPanel.add(taxFieldNIC.getTaxFieldPanel(), gbc1);


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


        gbc1.gridx = 0;
        gbc1.gridy = 10;
        fieldPanel.add(taxFieldTypeEmp.getTaxFieldPanel(), gbc1);

        
        gbc1.gridx = 0;
        gbc1.gridy = 11;
        fieldPanel.add(taxFieldIncome.getTaxFieldPanel(), gbc1);

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

        CheckBoxHandler handlerCheckBox = new CheckBoxHandler();
        checkBox1.addItemListener(handlerCheckBox);
        checkBox2.addItemListener(handlerCheckBox);
        
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

    private class RadioButtonHandler implements ItemListener{

        public void itemStateChanged(ItemEvent e){

            if(radioButton1.isSelected()){
                gender = radioButton1.getText();
            } else if (radioButton2.isSelected()) {
                gender = radioButton2.getText();
            } else if (radioButton3.isSelected()) { 
                gender = radioButton3.getText();
            }
        }
    }

    private class CheckBoxHandler implements ItemListener{

        public void itemStateChanged(ItemEvent e){
            
            if(checkBox1.isSelected()){
                chargeableIncome = Double.parseDouble(taxFieldIncome.getTaxTextField().getText()) - dependent0;  
                tax = (0.1/12) * chargeableIncome;
                textFieldRate.setText(new BigDecimal(chargeableIncome).toPlainString());   
            } else{
                chargeableIncome = Double.parseDouble(taxFieldIncome.getTaxTextField().getText()) - dependent1;
                tax = (0.1/12) * chargeableIncome;
                textFieldRate.setText(new BigDecimal(chargeableIncome).toPlainString());
            }
        }
    }

    private class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){

            String fullname = taxFieldName.getTaxTextField().getText();
            String address = taxfieldAddress.getTaxTextField().getText();
            String num = taxFieldContact.getTaxTextField().getText();
            String nic = taxFieldNIC.getTaxTextField().getText();
            String tan = taxFieldTAN.getTaxTextField().getText();
            String employment = taxFieldTypeEmp.getTaxTextField().getText();
            String income = taxFieldIncome.getTaxTextField().getText();
            Text errorMsg = new Text("You cannot leave any empty fields!", 14);

            Pattern p = Pattern.compile("[^A-Za-z0-9\s]");
            Matcher m = p.matcher(fullname);
            Matcher m2 = p.matcher(employment);
            boolean nameHasInvalidChar = m.find();
            boolean jobHasInvalidChar = m2.find();

            if(fullname.isEmpty() || address.isEmpty() || num.isEmpty() || nic.isEmpty() || tan.isEmpty() || employment.isEmpty() || income.isEmpty()){

                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
            
            } else {
                
                if(!(fullname.matches(".*\\d.*") && !(nameHasInvalidChar) && !(jobHasInvalidChar) && employment.matches(".*\\d.*"))){

                    if(num.matches("[0-9]+") && income.matches("[0-9]+")){

                        if(nic.length() == 14){
                            
                            if(tan.matches("[0-9]+") && tan.length() == 8){
                                
                                try {
                                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                                    LocalDateTime currentTime = LocalDateTime.now();

                                    BufferedWriter bw = Files.newBufferedWriter(Paths.get("./screens/taxReturn.txt"));
                                    bw.write("TAXER" + "               " + dtf.format(currentTime) + "\n");
                                    bw.write("____________________________________" + "\n" + "\n");
                                    bw.write("Full name: " + gender + " " + fullname + "\n");
                                    bw.write("Address: " + address + "\n");
                                    bw.write("Contact Number: " + num + "\n");
                                    bw.write("National Identity Card(NIC): " + nic + "\n");
                                    bw.write("Tax Account Number(TAN): " + tan + "\n");
                                    bw.write("Type of Employment: " + employment + "\n");
                                    bw.write("Yearly Income: Rs " + income + "\n");
                                    bw.write("Tax: Rs " + tax + "\n");

                                    errorMsg = new Text("You have succesfully submitted your tax return form!", 14);
                                    JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Success", JOptionPane.INFORMATION_MESSAGE);
                                    uda.updateTaxInfo(id, fullname, employment, Long.parseLong(nic), Integer.parseInt(tan),tax); 
                                    bw.close();
                                } catch (Exception exception) {
                                    System.out.println(exception);
                                }
                            }else {
                                errorMsg = new Text("Your TAN cannot be less than or greater than 8 digits!", 14);
                                JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            errorMsg = new Text("Your NIC cannot be less than or greater than 14 digits!", 14);
                            JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        errorMsg = new Text("Your contact number cannot contain any alphabets or special characters!", 14);
                        JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    errorMsg = new Text("Your name cannot contain any numbers or special characters!", 14);
                    JOptionPane.showMessageDialog(null, errorMsg.getTitle(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public JPanel getPanel(){
        return frame;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}