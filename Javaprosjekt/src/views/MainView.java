/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;
    
    /**
     * @author Rudi Yu
     */

import CustomSwing.CustomButton;
import CustomSwing.CustomPanel;
import DAO.Constants;
import controllers.Controller;
import controllers.MainController;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import javax.swing.table.JTableHeader;

public class MainView extends JFrame{
    
    private JScrollPane scroll;
    
    // instance variables
    MainController controller;
    CustomPanel activepanel, toppanel;
    CustomButton nybrukerpanel, nyforskerpanel, viewCustomers;
    JMenuBar menubar;

    /**
     * Initalizes components
     */

    
    /**
     * MainViews constructor
     */
    public MainView() 
    {
        super(Constants.APP_NAME);
        
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setVisible(true);
        
        this.setIconImage(new ImageIcon(getClass().getResource("/resources/evil_icon.png")).getImage()); 
    }

    /**
     * Adds controller to MainView
     * @param c controller
     * @return true for success, false for failed
     */
    public boolean addController(Controller c) {
        if(c instanceof MainController)
        {
            this.controller = (MainController)c;
            return true;
        }
        return false;
    }
    
    
    public void addCenter(Component tpanel)
    {
        
        JTable t = (JTable) tpanel;
        JTableHeader tableHeader = t.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        t.setAutoCreateRowSorter(true);
        
        JScrollPane panel = new JScrollPane(tpanel);
        Container c = getContentPane();
        c.add(panel, BorderLayout.CENTER);
        c.revalidate();
        c.repaint();
    }
    
    public void addTop(CustomPanel tpanel)
    {
        Container c = getContentPane();
        c.add(tpanel, BorderLayout.NORTH);
    }
    
    
}
