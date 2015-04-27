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
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

public class MainView extends JFrame implements View{
    
    private JScrollPane scroll;
    
    // instance variables
    MainController controller;
    CustomPanel activepanel, toppanel;
    CustomButton nybrukerpanel, nyforskerpanel, viewCustomers;
    JMenuBar menubar;

    public void initComponents()
    {    
        
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
       
     
       
       activepanel = new CustomPanel();
       
       // add scrollpane around elemnt incase needed. Also fixes scrollspeed issues.
       scroll = new JScrollPane(activepanel);
       scroll.getVerticalScrollBar().setUnitIncrement(Constants.SCROLL_SPEED);
       c.add(scroll, BorderLayout.CENTER);
       
       c.setVisible(true);
       
    }
    
    public MainView()
    {
        super("Insurance Co. ver=Alpha");
        
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setVisible(true);
    }

    public boolean addController(Controller c) {
        if(c instanceof MainController)
        {
            this.controller = (MainController)c;
            return true;
        }
        return false;
    }
    /**
     * Adds a new panel to the BorderLayout.CENTER area.
     * 
     * @param panel the panel to be added. 
     */
    public void newPanel(CustomPanel panel)
    {
        activepanel.removeAll();
        activepanel.add(panel, BorderLayout.CENTER);
        
        this.repaint();
        this.revalidate();       
    }
    public void newPanel(View panel)
    {
        if(panel instanceof CustomPanel)
        {
            newPanel((CustomPanel)panel);
        }
    }
    
    
}
