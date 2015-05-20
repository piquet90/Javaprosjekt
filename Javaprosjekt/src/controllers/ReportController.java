/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Registries;
import views.CustomEvent;
import views.CustomListener;

import views.registrations.NewReportPanel;


/**
 *
 * @author Rudi
 */
public class ReportController implements CustomListener{
    
    private Registries dataAccessObject;
    private NewReportPanel view;
    private MainController mc;
    private int customerId;
    
    /**
     *
     * @param r
     * @param c
     */
    public ReportController(Registries r, MainController c)
    {
        this.dataAccessObject = r;
        this.mc = c;
        
    }
    
    /**
     *
     */
    public void newReport(int id)
    {
        this.customerId = id;
        this.view = new NewReportPanel();
        //view.addCustomListener(this);
        mc.popUp(view);
    }

    @Override
    public void customActionPerformed(CustomEvent i) {
        
    }
}
