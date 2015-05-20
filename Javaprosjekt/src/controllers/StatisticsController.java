/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Registries;
import models.CustomerModel;
import models.InsuranceModel;
import models.ReportModel;
import views.CustomEvent;
import views.CustomListener;
import views.StatisticsView;


/**
 *
 * @author Audun
 */
public class StatisticsController implements CustomListener {
    
    private MainController mc;
    private CustomerModel cus;
    private InsuranceModel ins;
    private ReportModel rep;
    private StatisticsView v;
    
    public StatisticsController(Registries r, MainController m)
    {
        mc = m;
        cus = new CustomerModel(r);
        ins = new InsuranceModel(r);
        rep = new ReportModel(r);
        
        
    }
    
    public void startView()
    {
        v = new StatisticsView();
        v.addCustomListener(this);
        mc.popUp("Statistics View", v);
    }
    
    public void amountInsurances()
    {
        ins.getCarInsurances();
    }

    @Override
    public void customActionPerformed(CustomEvent i) {
        
    }
}


