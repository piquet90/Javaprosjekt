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
    
    private Registries registries;
    private ViewCustomerTable view;
    private CustomerModel model;
    
    
    public ViewCustomerController(Registries r, ViewCustomerTable v)
    {
        this.registries = r;
        this.view = v;
        model = new CustomerModel(r);
        
        view.addController(this);
        view.initComponents();
        
        CustomerTable table = new CustomerTable(model.getCustomers());
        
    }
    
    public void ViewCustomer(int i)
    {
        System.out.println(i);
        Customer customer = model.findById(i);
        
        CustomerView cus = new CustomerView(customer.getFirstname(), customer.getLastname(), customer.getAddressStreet(), customer.getCity(), Integer.toString(customer.getAreacode()));
        
        JOptionPane.showConfirmDialog(null, cus, customer.getName(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
    }
    
    
}
