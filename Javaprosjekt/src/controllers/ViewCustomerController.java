/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import CustomSwing.CustomUserTable;
import DAO.Registries;
import javax.swing.JOptionPane;
import models.CustomerModel;
import models.objects.Customer;
import views.CustomerView;
import views.View;
import views.ViewCustomerPanel;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerController extends Controller {
    
    private Registries registries;
    private ViewCustomerPanel view;
    private CustomerModel model;
    
    
    public ViewCustomerController(Registries r, View v)
    {
        this.registries = r;
        this.view = (ViewCustomerPanel)v;
        model = new CustomerModel(r);
        
        view.addController(this);
        view.initComponents();
        
        CustomUserTable table = new CustomUserTable(model.getCustomers());
        view.setTable(table);
        
    }
    
    public void ViewCustomer(int i)
    {
        Customer customer = model.findById(i);
        
        CustomerView cus = new CustomerView(customer.getFirstname(), customer.getLastname(), customer.getAddressStreet(), customer.getCity(), Integer.toString(customer.getAreacode()));
        
        JOptionPane.showConfirmDialog(null, cus, customer.getName(), JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        
    }
    
    
}
