/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import TableModels.CustomerTable;
import DAO.Registries;
import javax.swing.JOptionPane;
import models.*;
import views.*;
import models.Customer;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerController extends Controller {
    
    
    private MainController mc;
    private Registries registries;
    private ViewCustomerTable view;
    private CustomerModel umodel;
    
    
    public ViewCustomerController(Registries r, MainController c)
    {
        this.mc = c;
        this.registries = r;
        
        umodel = new CustomerModel(registries);
        
        
        
    }
    
    public void showAllCustomers()
    {
        CustomerTable table = new CustomerTable(umodel.getCustomers());
        view = new ViewCustomerTable(table);
        view.addController(this);
        view.initComponents();
        
        
        mc.view.addCenter(view);
        mc.view.revalidate();
        mc.view.repaint();
    }
    
    
    public void ViewCustomer(int i)
    {
        System.out.println(i);
        Customer customer = umodel.findById(i);
        
        CustomerView cus = new CustomerView(customer.getFirstname(), customer.getLastname(), customer.getAddressStreet(), customer.getCity(), Integer.toString(customer.getAreacode()));
        System.out.println("test");
        mc.popUp(cus);
        
    }
    
    
}
