/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Registries;
import views.View;
import views.registrations.NewReportPanel;


/**
 *
 * @author Rudi
 */
public class ReportController {
    
    private Registries dataAccessObject;
    private NewReportPanel view;
    private MainController mc;
    
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
    public void newReport()
    {
        this.view = new NewReportPanel();
        view.addController(this);
        view.initComponents();
        mc.popUp(view);
    }
}
