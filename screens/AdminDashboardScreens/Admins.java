package screens.AdminDashboardScreens;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import Database.UserDaoAccesser;
import java.awt.*;
import java.sql.SQLException;
import models.Constants;
import models.Table;

public class Admins extends JPanel {
    private JPanel adminsPanel = new JPanel();
    private Table adminsTable = new Table();
    Constants constants = new Constants();
    UserDaoAccesser uda = new UserDaoAccesser();

    public Admins() throws SQLException {
        adminsPanel.setLayout(new BoxLayout(adminsPanel, BoxLayout.PAGE_AXIS));

        Object[] admins = new Object[4]; 
        Object[] columns = {"ID", "Full name", "Username", "Email"};
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columns);

        for(int i = 0; i<uda.getAdmins().size(); i++) {
            admins[0] = uda.getAdmins().get(i).getId();
            admins[1] = uda.getAdmins().get(i).getFullName();
            admins[2] = uda.getAdmins().get(i).getUserName();
            admins[3] = uda.getAdmins().get(i).getEmail();

            tableModel.addRow(admins);
        }

        adminsTable.getTable().setModel(tableModel);
        JScrollPane scrollPane = new JScrollPane(adminsTable.getTable());

        adminsPanel.add(scrollPane);
        adminsPanel.setBackground(new Constants().getPrimaryColor());
        adminsPanel.setVisible(true);
    }

    public JPanel getAdminsPanel() {
        return adminsPanel;
    }
}
