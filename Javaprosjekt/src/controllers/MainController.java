
/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Registries;
import java.util.HashSet;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import models.*;
import models.Customer;
import views.*;

/**
 *
 * @author Rudi
 */
public class MainController extends Controller{
    
    
    public MainView view;
    private Registries r;
    
    private JMenuBar menubar;
    
    
    // controller references
    public ViewCustomerController vcController;
    public CustomerController ncController;
    public ReportController rController;
    
    /**
     * MainController
     * 
     * Has resposibility of creating and managing all other controllers.
     * This controller usually passes itself to all the controllers it creates.
     * 
     * @param MainView The main-view class.
     */
    public MainController(MainView f)
    {
        // init main view and controller
        
        view = f;
        view.initComponents();
        view.addController(this);
        
        
        // setting the menubar 
        menubar = new MenuView(this);
        view.setJMenuBar(menubar);
        
        
        // passing registries to controllers. Controllers can get the models it needs for itself.
        r = new Registries();
        
        // creating all controllers and and passing registries and maincontroller for access to other parts of the program.
        vcController = new ViewCustomerController(r, this);
        ncController = new CustomerController(r, this);
        rController = new ReportController(r, this);
        
        // start with ViewCustomerController
        vcController.showAllCustomers();
        
    }
    
    public void popUp(Object v)
    {
        
        JOptionPane.showOptionDialog(null, v, "Test", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    
    }
    
    

    public void save()
    {
        r.save();
    }
    
    
}
