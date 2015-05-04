
/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;


import CustomSwing.CustomPanel;
import CustomSwing.CustomUserTable;
import DAO.Registries;
import java.util.HashSet;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import models.*;
import models.objects.Customer;
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
    
    private ViewCustomerTable ctable;
    private ViewCustomerController vccontroller;
    
    private CustomerModel customerModel;
    private HashSet<Customer> customers;
    
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
        
        customerModel = new CustomerModel(r);
        
        customers = customerModel.getCustomers();
        
        CustomUserTable table = new CustomUserTable(customers);
        
        ctable = new ViewCustomerTable(table);
        
        view.addCenter(ctable);
        
        
        
        
    }
    
    // under-controller TODO: write more meaningful comments
    public void newUserPanel()
    {
        CustomPanel newview = new NewCustomerPanel();
        NewCustomerController newcontroller = new NewCustomerController(r, (View) newview);
        
        
        JOptionPane.showConfirmDialog(null, newview, "Test", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
    }
    // under-controller
    public void save()
    {
        r.save();
    }
    
    
}
