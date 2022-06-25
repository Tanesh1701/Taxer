package screens;
import javax.swing.*;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import models.Text;
import models.User;
import screens.AdminDashboardScreens.Admins;
import screens.AdminDashboardScreens.Users;

import java.awt.*;

public class AdminDashboard extends JFrame {
    String menuItems[] = {"Users", "Admins", "Exit"};
    JLabel[] menuLabels = new JLabel[3];
    JPanel[] panels = new JPanel[2];
    JPanel avatarPanel = new JPanel();
    Users userPanel;
    Admins adminPanel;
    JPanel containerPanel = new JPanel();
    JPanel menuPanel = new JPanel();

    static JFrame adminDashboard = new JFrame();

    public AdminDashboard(User user) {
        try {
            userPanel = new Users();
            adminPanel = new Admins();
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

        Text username = new Text(user.getFullName(), 14);
        username.getTitle().setForeground(Color.WHITE);
        menuPanel.add(username.getTitle());
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
        // reset labels to their default design
        for (JLabel menuItem : menuLabels)
        {
           // change the jlabel background color to white
           //menuItem.setBackground(new Color(46,49,49));
           // change the jlabel Foreground color to blue
           menuItem.setForeground(Color.white); 
        }
        
        // change the jlabel background color to white
        label.setBackground(Color.white);
        // change the jlabel Foreground color to blue
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
                        
                          // when we click on the jlabel
                        // change the jlabel background and Foreground
                       // using setLabelBackround function we created
                        setLabelBackround(label);
                        
                        // display the selected panel depending on the selected label
                       // using the showPanel function
                        switch (label.getText().trim()){
                            case "Users":
                                showPanel(userPanel.getUsersPanel());
                                break;
                                   
                            case "Admins":
                                showPanel(adminPanel.getAdminsPanel());
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
