package screens;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import models.Text;
import java.awt.*;

public class Dashboard extends JFrame{
    String menuItems[] = {"Home", "Tax Return", "Calculator", "Settings", "Logout"};
    JLabel[] menuLabels = new JLabel[5];
    JPanel[] panels = new JPanel[5];
    JPanel avatarPanel = new JPanel();
    JPanel containerPanel = new JPanel();
    JPanel menuPanel = new JPanel();
    JPanel homePanel = new JPanel();
    JPanel taxForm = new JPanel();
    JPanel calculatorPanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JPanel logoutPanel = new JPanel();
    static JFrame  dashboardFrame = new JFrame();

    public Dashboard() {
        dashboardFrame.setTitle("Dashboard");

        dashboardFrame.setLayout(new BorderLayout());

        menuPanel.setBackground(Color.decode("#5200ff"));
        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setPreferredSize(new Dimension(200, 100));

        Text username = new Text("Tanesh Chuckowree", 14);
        username.getTitle().setForeground(Color.WHITE);
        menuPanel.add(username.getTitle());
        menuPanel.add(Box.createRigidArea(new Dimension(0,100)));

        containerPanel.setBackground(Color.WHITE);
        containerPanel.setPreferredSize(new Dimension(700, 500));

        JLabel homeLabel = new JLabel("Hello Home");
        homePanel.add(homeLabel);

       
        JLabel taxLabel = new JLabel("Hello Tax");
        //taxForm.setPreferredSize(new Dimension(650,650));
        taxForm.add(taxLabel);

       
        JLabel calculatorLabel = new JLabel("Hello Calculator");
        calculatorPanel.add(calculatorLabel);

        
        JLabel settingsLabel = new JLabel("Hello Settings");
        settingsPanel.add(settingsLabel);

        
        JLabel logoutLabel = new JLabel("Hello Logout");
        logoutPanel.add(logoutLabel);

        for(int i = 0; i < menuLabels.length; i++) {
            Text text = new Text(menuItems[i], 14);
            text.getTitle().setForeground(Color.WHITE);
            menuLabels[i] = text.getTitle();
            menuPanel.add(menuLabels[i], BorderLayout.CENTER);
            menuPanel.add(Box.createRigidArea(new Dimension(10,30)));
        }

        panels[0] = homePanel;
        panels[1] = taxForm;
        panels[2] = calculatorPanel;
        panels[3] = settingsPanel;
        panels[4] = logoutPanel;

        for(int i = 0; i < panels.length; i++) {
            containerPanel.add(panels[i], BorderLayout.CENTER);
        }

        containerPanel.setVisible(false);

        addActionToMenuLabels();

        dashboardFrame.add(menuPanel, BorderLayout.WEST);
        dashboardFrame.add(containerPanel, BorderLayout.CENTER);

        dashboardFrame.setSize(750, 600);
        dashboardFrame.setVisible(true);
        dashboardFrame.setLocation(null);
        //setResizable(false);
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
                            case "Home":
                                   showPanel(homePanel);
                                   break;
                                   
                            case "Tax Return":
                                   showPanel(taxForm);
                                   taxForm.setBackground(Color.red);
                                   break;
                                   
                            case "Calculator":
                                   showPanel(calculatorPanel);
                                   calculatorPanel.setBackground(Color.BLUE);
                                   break;
                                   
                                   case "Settings":
                                   showPanel(settingsPanel);
                                   settingsPanel.setBackground(Color.GRAY);
                                   break;
                                   
                                   case "Logout":
                                //    showPanel(logoutPanel);
                                //    logoutPanel.setBackground(Color.GREEN);
                                      Dashboard.getDashboardFrame().dispose();
                                    //   CardLayout cl = (CardLayout) (Main.getCards().getLayout());
                                    //   cl.show(Main.getCards(), "Register");
                                   break;
                                   
                    }
                        
                }

                    @Override
                    public void mousePressed(MouseEvent e) {
                     }

                    @Override
                    public void mouseReleased(MouseEvent e) {
                      }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                        // on the mouse entred event
                        // set the border to yellow
                        
                        
                      }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        // on the mouse exited event
                        // reset to the default border
                        
                        
                      }
                });
                
            }
        }
    }

    public static JFrame getDashboardFrame() {
        return dashboardFrame;
    }
}
