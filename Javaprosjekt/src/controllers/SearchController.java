/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
import DAO.Registries;
import models.Customer;
import models.InsuranceModel;
import models.objects.insurances.Insurance;
import views.CustomEvent;
import views.CustomListener;
import views.SimpleSearchPanel;

/**
 *
 * @author Audun
 */
public class SearchController implements CustomListener{
    
    private MainController mc;
    private InsuranceModel i;
    private SimpleSearchPanel v;
    
    /**
     * SearchControllers constructor
     * @param r registries
     * @param m maincontroller
     */
    public SearchController(Registries r, MainController m)
    {
        mc = m;
        i = new InsuranceModel(r);
        v = new SimpleSearchPanel();
    }
    
    public void findById()
    {
        System.out.println(v.pølse());
        //int p = Integer.parseInt(v.getSearch());
        //Insurance in = i.findById(8);
        
        /*if(in == null)
            mc.popUp("Error", "Fant ingen treff");
        else
            mc.popUp(in.getType());*/
        
        //(in.getConditions());
        //
        
    }

    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction() == Constants.SEARCH_INSURANCES)
        {
            findById();
        }
            
    }
}
