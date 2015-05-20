/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import TableModels.CustomerTable;
import DAO.*;
import TableModels.InsuranceTable;
import java.util.HashSet;
import models.*;
import views.*;
import models.Customer;
import models.objects.insurances.Insurance;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerController extends Controller implements CustomListener{
    
    
    private MainController mc;
    private Registries registries;
    private ViewTable view;
    private CustomerModel umodel;
    private CustomerTable table;
    
    /**
     * ViewCustomerControllers constructor
     * @param r registries
     * @param c maincontroller
     */
    public ViewCustomerController(Registries r, MainController c)
    {
        this.mc = c;
        this.registries = r;
        umodel = new CustomerModel(registries);
    }
    
    /**
     * Fills a table with all customers
     */
    public void showAllCustomers()
    {
        table = new CustomerTable(umodel.getCustomers());
        view = new ViewTable(table);
        view.addCustomListener(this);
        mc.view.addCenter(view);
    }
    
    /**
     * Refreshes the customer panel
     */
    public void update()
    {
        table = new CustomerTable(umodel.getCustomers());
        view.setModel(table);
    }
    
    

    @Override
    public void customActionPerformed(CustomEvent i) {        
        if(i.getAction()==Constants.DOUBLECLICK)
            mc.ncController.viewCustomer(i.getValue());
    }
}
