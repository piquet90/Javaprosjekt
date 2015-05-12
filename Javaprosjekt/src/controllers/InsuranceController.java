/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Registries;
import models.CustomerModel;
import models.InsuranceModel;
import views.CustomEvent;
import views.CustomListener;
import views.registrations.*;

/**
 *
 * @author Rudi
 */
public class InsuranceController implements CustomListener{
    
    private MainController mc;
    private Registries registries;
    private InsuranceModel imodel;
    
    
    public InsuranceController(Registries r, MainController c)
    {
        this.mc = c;
        this.registries = r;
    }
    
    public void newCarInsurance()
    {
        mc.popUp(new NewCarInsurance());
    }
    public void newHouseInsurance()
    {
        mc.popUp(new NewHouseInsurance());
    }
    public void newBoatInsurance()
    {
        mc.popUp(new NewBoatInsurance());
    }
    public void newTravelInsurance()
    {
        mc.popUp(new NewTravelInsurance());
    }
    public void newLeisureHouseInsurance()
    {
        mc.popUp(new NewLeisureHouseInsurance());
    }
    
    
    
    @Override
    public void customActionPerformed(CustomEvent i) {
        
    }
    
}
