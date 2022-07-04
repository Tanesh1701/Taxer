package screens.AdminDashboardScreens;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Database.UserDaoAccesser;
import java.awt.*;
import java.sql.SQLException;
import models.Constants;
import models.Table;

public class UsersTax extends JPanel{
    private JPanel usersPanel = new JPanel();
    private Table usersTable = new Table();
    Constants constants = new Constants();
    UserDaoAccesser uda = new UserDaoAccesser();
    
    public UsersTax() throws SQLException {
        usersPanel.setLayout(new BoxLayout(usersPanel, BoxLayout.PAGE_AXIS));

        Object[] users = new Object[6]; 
        Object[] columns = {"ID", "Full Name", "Job", "NIC", "TAN", "TAX"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        for(int i = 0; i<uda.getUserDetails().size(); i++) {
            users[0] = uda.getUserDetails().get(i).getId();
            users[1] = uda.getUserDetails().get(i).getFullname();
            users[2] = uda.getUserDetails().get(i).getJob();
            users[3] = uda.getUserDetails().get(i).getNic();
            users[4] = uda.getUserDetails().get(i).getTan();
            users[5] = uda.getUserDetails().get(i).getTax();
            tableModel.addRow(users);
        }

        usersTable.getTable().setModel(tableModel); 
        JScrollPane scrollPane = new JScrollPane(usersTable.getTable());

        usersPanel.add(scrollPane);
        usersPanel.setBackground(Color.WHITE);
        usersPanel.setVisible(true);
    }

    public JPanel getUsersPanel() {
        return usersPanel;
    }
}
