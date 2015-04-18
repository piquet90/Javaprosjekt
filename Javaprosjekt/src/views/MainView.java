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
import java.awt.Container;

public class MainView extends JFrame implements View{
    
    
    
    
    // instance variables
    MainController controller;
    CustomPanel activepanel, toppanel;
    CustomButton nybrukerpanel, nyforskerpanel;
    
    
    
    
    private void initComponents()
    {    
        toppanel = new CustomPanel();
        
        nybrukerpanel = new CustomButton("NyBrukerPanel");
        nyforskerpanel = new CustomButton("NyForsikringPanel");
        
        toppanel.add(nybrukerpanel);
        toppanel.add(nyforskerpanel);
        
        nybrukerpanel.addActionListener((e)->{ controller.nybrukerpanel();});
        nyforskerpanel.addActionListener((e)->{ controller.nyforskerpanel();});
        
        
       Container c = getContentPane();
       c.setLayout(new BorderLayout());
       
       
       
       
       
       
       activepanel = new CustomPanel();
       c.add(toppanel, BorderLayout.NORTH);
       c.add(activepanel, BorderLayout.CENTER);
       c.setVisible(true);
       
       
    }
    
    public MainView()
    {
        super("Insurance Co. ver=Alpha");
        initComponents();
        
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
    
    public void newPanel(CustomPanel panel)
    {
        activepanel.removeAll();
        activepanel.add(panel);
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
