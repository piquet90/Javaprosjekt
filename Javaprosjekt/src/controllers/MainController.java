
/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;


import DAO.Registries;
import javax.swing.JMenuBar;
import models.*;
import views.*;

/**
 *
 * @author Rudi
 */
public class MainController extends Controller{
    
    
    private MainView view;
    private MainModel model;
    private Registries r;
    
    private JMenuBar menubar;
    
    /**
     *
     * @param f
     * @param m
     */
    public MainController(MainView f, MainModel m)
    {
        
        view = f;
        model = m;
        
        menubar = new MenuView(this);
        view.setJMenuBar(menubar);
        
        r = new Registries();
        
        view.initComponents();
        view.addController(this);
        
        defaultPanel();
    }
    
    
    
    public void defaultPanel()
    {
        viewCustomerPanel();
    }
    
    public void viewCustomerPanel()
    {
        View newview = new ViewCustomerPanel();
        new ViewCustomerController(r, newview);
        
        view.newPanel(newview);
    }
    
    
    // under-controller TODO: write more meaningful comments
    public void nybrukerpanel()
    {
        View newview = new NewCustomerPanel();
        NewCustomerController newcontroller = new NewCustomerController(r, newview);
        
        
        view.newPanel(newview);
    }
    // under-controller
    public void nyforskerpanel()
    {
        View newview = new NewInsurancePanel();

        NewInsuranceController newcontroller = new NewInsuranceController(r, newview); 
        view.newPanel(newview);
    }
    
    public void save()
    {
        r.save();
    }
    
    
}
