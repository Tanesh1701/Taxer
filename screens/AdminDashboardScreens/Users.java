package screens.AdminDashboardScreens;
import javax.swing.*;
import java.awt.*;

import models.Constants;
import models.Text;

public class Users extends JPanel {
    private JPanel usersPanel = new JPanel();
    private JTable usersTable;
    Constants constants = new Constants();
    
    public Users() {
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.PAGE_AXIS));

        String[][] users = {{"1", "Tanesh Chuckowree", "Tanesh", "tan@gmail.com"}, {"2", "Zahra Oozeer", "Zahra", "zahraoozeer@gmail.com"}}; 
        String[] columns = {"ID", "Full name", "Username", "Email"};

        usersTable = new JTable(users, columns);
        usersTable.getTableHeader().setBackground(constants.getSecondaryColor());
        usersTable.getTableHeader().setForeground(constants.getPrimaryColor());
        try {
            Font font = Font.createFont(Font.TRUETYPE_FONT, Text.class.getResourceAsStream("../Assets/Fonts/VarelaRound-Regular.TTF"));
            usersTable.setFont(font.deriveFont(Font.PLAIN, 12f));
            usersTable.getTableHeader().setFont(font.deriveFont(Font.PLAIN, 13f));
        } catch (Exception e) {
            System.out.println(e);
        } 
        JScrollPane scrollPane = new JScrollPane(usersTable);

        usersPanel.add(scrollPane);
        usersPanel.setBackground(Color.WHITE);
        usersPanel.setVisible(true);
    }

    public JPanel getUsersPanel() {
        return usersPanel;
    }
}
