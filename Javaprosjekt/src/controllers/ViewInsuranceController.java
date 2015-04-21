/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Registries;
import views.View;
import views.ViewInsurancePanel;

/**
 *
 * @author rudiwyu
 */
public class ViewInsuranceController extends Controller {
    
    private Registries registries;
    private ViewInsurancePanel view;
    
    
    public ViewInsuranceController(Registries r, View v)
    {
        this.registries = r;
        this.view = (ViewInsurancePanel)v;
        
        view.addController(this);
        view.initComponents();
        
    }
}
