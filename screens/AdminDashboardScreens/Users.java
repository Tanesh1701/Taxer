package screens.AdminDashboardScreens;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Database.UserDaoAccesser;

import java.awt.*;
import java.sql.SQLException;

import models.Constants;
import models.Text;

public class Users extends JPanel {
    private JPanel usersPanel = new JPanel();
    private JTable usersTable = new JTable();
    Constants constants = new Constants();
    UserDaoAccesser uda = new UserDaoAccesser();
    
    public Users() throws SQLException {
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.PAGE_AXIS));

        Object[] users = new Object[4]; 
        Object[] columns = {"ID", "Full name", "Username", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        for(int i = 0; i<uda.getUsers().size(); i++) {
            users[0] = uda.getUsers().get(i).getId();
            users[1] = uda.getUsers().get(i).getFullName();
            users[2] = uda.getUsers().get(i).getUserName();
            users[3] = uda.getUsers().get(i).getEmail();

            tableModel.addRow(users);
        }

        usersTable.setModel(tableModel);
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
