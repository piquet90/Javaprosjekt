
/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
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
public class MainController extends Controller {
    
    
    public MainView view;
    private Registries r;
    
    private JMenuBar menubar;
    
    
    // controller references
    public ViewCustomerController vcController;
    public CustomerController ncController;
    public ReportController rController;
    public RegistrationController regController;
    public InsuranceController insController;
    
    
    /**
     * MainController
     * 
     * Has resposibility of creating and managing all other controllers.
     * This controller usually passes itself to all the controllers it creates.
     * 
     * @param f The main-view class.
     */
    public MainController(MainView f)
    {
        // init main view and controller
        
        view = f;
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
        regController = new RegistrationController(r, this);
        insController = new InsuranceController(r, this);
        
        // start with ViewCustomerController
        vcController.showAllCustomers();
        
    }
    
    
    /**
     * Displays a given panel to the user, without title
     * @param v a panel
     */
    public void popUp(Object v)
    {
        popUp("", v);
    }
    
    /**
     * Displayes a given panel to the user, with title
     * @param title dialog title
     * @param v a panel
     */
    public void popUp(String title,Object v)
    {
        
        JOptionPane.showOptionDialog(view, v, Constants.APP_NAME+" - "+title, JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{}, null);
    
    }
    
    /**
     * Saves the data
     */
    public void save()
    {
        r.save();
    }
    
    
}
