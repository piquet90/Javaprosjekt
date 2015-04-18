
/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;


import CustomSwing.CustomPanel;
import DAO.Registries;
import javax.swing.*;
import models.*;
import views.*;

/**
 *
 * @author Rudi
 */
public class MainController implements Controller{
    
    
    private MainFrame view;
    private MainModel model;
    private Registries r;
    
    /**
     *
     * @param f
     * @param m
     */
    public MainController(MainFrame f, MainModel m)
    {
        view = f;
        model = m;
        
        r = new Registries();
        
        view.addController(this);
    }
    
    public void nybrukerpanel()
    {
        View newview = new NyBrukerPanel();
        NewCustomerController newcontroller = new NewCustomerController(r, newview);
        
        
        view.newPanel(newview);
    }
    
    public void button2()
    {
        CustomPanel panel2 = new CustomPanel();
        panel2.add(new JLabel("Panel2 works as fuck!"));
        view.newPanel(panel2);
    }
}
