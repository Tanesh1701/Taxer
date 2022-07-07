package screens.AdminDashboardScreens;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Database.UserDaoAccesser;
import java.awt.*;
import java.sql.SQLException;
import models.Constants;
import models.Table;

public class Users extends JPanel {
    private JPanel usersPanel = new JPanel();
    private Table usersTable = new Table();
    Constants constants = new Constants();
    UserDaoAccesser uda = new UserDaoAccesser();
    
    public Users() throws SQLException {
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.PAGE_AXIS));

        Object[] users = new Object[5]; 
        Object[] columns = {"ID", "Full name", "Username", "Email", "HasFilledTaxes"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        for(int i = 0; i<uda.getUsers().size(); i++) {
            users[0] = uda.getUsers().get(i).getId();
            users[1] = uda.getUsers().get(i).getFullName();
            users[2] = uda.getUsers().get(i).getUserName();
            users[3] = uda.getUsers().get(i).getEmail();
            users[4] = uda.getUsers().get(i).getHasFilledTaxes();
            tableModel.addRow(users);
        }

        usersTable.getTable().setModel(tableModel); 
        JScrollPane scrollPane = new JScrollPane(usersTable.getTable());

        usersPanel.add(scrollPane);
        usersPanel.setBackground(new Constants().getPrimaryColor());
        usersPanel.setVisible(true);
    }

    public JPanel getUsersPanel() {
        return usersPanel;
    }
}
