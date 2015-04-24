/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import CustomSwing.CustomUserTable;
import DAO.Registries;
import models.CustomerModel;
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
    
    
}
