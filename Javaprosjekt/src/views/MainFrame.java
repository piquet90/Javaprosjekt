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
import controllers.Controller;
import controllers.MainController;
import javax.swing.*;
import helpers.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MainFrame extends JFrame implements View{
    
    
    
    
    // instance variables
    MainController controller;
    CustomPanel activepanel, toppanel;
    CustomButton button1, button2;
    
    
    
    
    private void initComponents()
    {    
        toppanel = new CustomPanel();
        
        button1 = new CustomButton("NyBrukerPanel");
        button2 = new CustomButton("Button2");
        
        toppanel.add(button1);
        toppanel.add(button2);
        
        button1.addActionListener((e)->{ controller.nybrukerpanel();});
        button2.addActionListener((e)->{ controller.button2();});
        
        
       
        
        
        
       Container c = getContentPane();
       c.setLayout(new BorderLayout());
       
       
       
       
       
       
       activepanel = new CustomPanel();
       c.add(toppanel, BorderLayout.NORTH);
       c.add(activepanel, BorderLayout.CENTER);
       c.setVisible(true);
       
       
    }
    
    public MainFrame()
    {
        super("Frame title");
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
