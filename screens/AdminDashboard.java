package screens;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import models.Text;
import models.User;
import screens.AdminDashboardScreens.Admins;
import screens.AdminDashboardScreens.Users;
import screens.AdminDashboardScreens.UsersTax;

import java.awt.*;

public class AdminDashboard extends JFrame {
    String menuItems[] = {"Users", "Admins", "Get user details", "Exit"};
    JLabel[] menuLabels = new JLabel[4];
    JPanel[] panels = new JPanel[3];
    JPanel avatarPanel = new JPanel();
    Users userPanel;
    Admins adminPanel;
    UsersTax usersTax;
    JPanel containerPanel = new JPanel();
    JPanel menuPanel = new JPanel();

    static JFrame adminDashboard = new JFrame();

    public AdminDashboard(User user) {
        try {
            userPanel = new Users();
            adminPanel = new Admins();
            usersTax = new UsersTax();
        } catch (Exception e) {
            System.out.println(e);
        }
        adminDashboard.setTitle("Admin Dashboard");
        adminDashboard.setLayout(new BorderLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        menuPanel.setBackground(Color.decode("#5200ff"));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, 100));

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime currentTime = LocalDateTime.now();
        Text time  = new Text((dtf.format(currentTime)), 12);
        time.getTitle().setForeground(Color.white);
        time.getTitle().setBorder(BorderFactory.createEmptyBorder(10, 75, 20, 5));

        String username = user.getFullName().split(" ")[0];

        Text welcome = new Text("Welcome " + username, 15);
        welcome.getTitle().setForeground(Color.WHITE);
        welcome.getTitle().setBorder(BorderFactory.createEmptyBorder(20, 32, 5, 0));

        menuPanel.add(time.getTitle());
        menuPanel.add(welcome.getTitle());
        menuPanel.add(Box.createRigidArea(new Dimension(0,100)));

        containerPanel.setLayout(new GridBagLayout());

        for(int i = 0; i < menuLabels.length; i++) {
            Text text = new Text(menuItems[i], 14);
            text.getTitle().setForeground(Color.WHITE);
            menuLabels[i] = text.getTitle();
            menuPanel.add(menuLabels[i], BorderLayout.CENTER);
            menuPanel.add(Box.createRigidArea(new Dimension(10,30)));
        }

        panels[0] = userPanel.getUsersPanel();
        panels[1] = adminPanel.getAdminsPanel();
        panels[2] = usersTax.getUsersPanel();
        
        for(int i = 0; i < panels.length; i++) {
            containerPanel.add(panels[i], gbc);
        }

        containerPanel.setVisible(false);

        addActionToMenuLabels();

        adminDashboard.add(menuPanel, BorderLayout.WEST);
        adminDashboard.add(containerPanel, BorderLayout.CENTER);

        adminDashboard.setSize(750, 600);
        adminDashboard.setVisible(true);
        adminDashboard.setLocation(null); //gives an exception for some reason
        adminDashboard.pack();
    }

    public void setLabelBackround(JLabel label)
    {
        for (JLabel menuItem : menuLabels)
        {
           menuItem.setForeground(Color.white); 
        }
                
        label.setBackground(Color.white);

        label.setForeground(Color.decode("#C6C3D5"));
    }

    public void showPanel(JPanel panel)
    {
        // hide panels
        for (JPanel pnl : panels) 
        {
            pnl.setVisible(false);
        }
        
        // and show only this panel
        containerPanel.setVisible(true);
        panel.setVisible(true);
    }

    public void addActionToMenuLabels()
    {
        // get labels in the jpanel menu
        Component[] components = menuPanel.getComponents();
        
        for (Component component : components) {
            if(component instanceof JLabel)
            {
                JLabel label = (JLabel) component;
                
                 // add action to the labels
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        
                        setLabelBackround(label);
                        
                        switch (label.getText().trim()){
                            case "Users":
                                showPanel(userPanel.getUsersPanel());
                                break;
                                   
                            case "Admins":
                                showPanel(adminPanel.getAdminsPanel());
                                break;
                            case "Get user details":
                                showPanel(usersTax.getUsersPanel());
                                break;
                            case "Exit":
                                AdminDashboard.getDashboardFrame().dispose();
                            break;
                                          
                    }
                        
                }

                    @Override
                    public void mousePressed(MouseEvent e) {}

                    @Override
                    public void mouseReleased(MouseEvent e) {}

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        setCursor(new Cursor(Cursor.HAND_CURSOR));
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {}
                });
                
            }
        }
    }

    public static JFrame getDashboardFrame() {
        return adminDashboard;
    }
}
