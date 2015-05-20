/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
import DAO.Registries;
import javax.swing.JOptionPane;
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
        //v.setSearch("f");
        JOptionPane.showMessageDialog(null, v.getSearch());
        /*int p = Integer.parseInt(v.getSearch());
        Insurance in = i.findById(p);
        
        if(in == null)
            JOptionPane.showMessageDialog(null, "Fant ingen treff");
        else
            JOptionPane.showMessageDialog(null, in.getType());*/
        
    }

    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction() == Constants.SEARCH_INSURANCE)
        {
            findById();
        }
            
    }
}
