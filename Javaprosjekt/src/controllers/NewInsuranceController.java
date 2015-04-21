/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import views.NewInsurancePanel;
import views.View;
/**
 *
 * @author rudiwyu
 */


public class NewInsuranceController extends Controller{
    
    Registries dataAccessObject;
    NewInsurancePanel newCustomerView;
    
    
    
    public NewInsuranceController(Registries r, View v)
    {
        this.dataAccessObject = r;
        this.newCustomerView = (NewInsurancePanel) v;
        this.newCustomerView.addController(this);
        this.newCustomerView.initComponents();
        
    }
    
    public void test()
    {
        System.out.println("trykk");
    }
}
