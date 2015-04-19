/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import views.NyBrukerPanel;
import views.View;

/**
 *
 * @author rudiwyu
 */
public class NewCustomerController implements Controller{
    
    Registries dataAccessObject;
    NyBrukerPanel newCustomerView;
    
    
    
    public NewCustomerController(Registries r, View v)
    {
        this.dataAccessObject = r;
        this.newCustomerView = (NyBrukerPanel) v;
        this.newCustomerView.addController(this);
        this.newCustomerView.initComponents();
        
    }
    
    public void test()
    {
        System.out.println("trykk");
    }
}
