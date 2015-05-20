/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
import DAO.Registries;
import javax.swing.JOptionPane;
import models.InsuranceModel;
import models.Report;
import models.ReportModel;
import views.CustomEvent;
import views.CustomListener;

import views.registrations.NewReportPanel;


/**
 *
 * @author Rudi
 */
public class ReportController implements CustomListener{
    
    private NewReportPanel view;
    private MainController mc;
    private InsuranceModel iModel;
    private ReportModel rModel;
    private int  insuranceId, reportId;
    
    /**
     *
     * @param r
     * @param c
     */
    public ReportController(Registries r, MainController c)
    {
        iModel = new InsuranceModel(r);
        rModel = new ReportModel(r);
        this.mc = c;
    }
    
    
    
    
    /**
     *
     */
    public void newReport(int id)
    {
        this.insuranceId = id;
        this.view = new NewReportPanel();
        
        view.setType(iModel.findById(insuranceId).getType());
        view.setInsNumber(Integer.toString(insuranceId));
        

        view.addCustomListener(this);

        mc.popUp(view);
    }
    private void saveReport()
    {
        if(!view.isViewMode())
            save(new Report());
        else
            save(rModel.findById(reportId));
    }
    private void save(Report r)
    {
        String s = "";
        
        if(view.getDate().equals(""))
            s+="Dato";
        s+=validateDouble(view.getEstimation(), "Taksering av skade\n");
        s+=validateDouble(view.getPaid(), "Utbetalt\n");
        s+=(view.getDescription().equals("")?"Beskrivelse\n":"");
        if(iModel.findById(insuranceId)==null)
            s+="Ugyldig forsikringsID\n";  
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(view,  "Vennligst korriger følgende felter:\n\n"+s);
        else {
            
            r.setEstimated(Double.parseDouble(view.getEstimation()));
            r.setDescription(view.getDescription());
            r.setPaid(Double.parseDouble(view.getPaid()));
            r.setType(view.getType());
            r.setInsuranceId(insuranceId);
            r.setDate(view.getDate());
            //r.setWitness1(view.get);
            
            
            if(!view.isViewMode())
            {  
                r.setOwnerId(iModel.findById(insuranceId).getOwnerId());
                rModel.addReport(r);
            }
            
            mc.ncController.refresh();
            JOptionPane.showMessageDialog(view, "Rapporten er registrert");
        }
    }
    
    public void viewReport(int id)
    {
        Report r = rModel.findById(id);
        this.reportId= r.getId();
        this.insuranceId = r.getInsuranceId();
        
        view = new NewReportPanel();
        view.setDate(r.getDate());
        view.setDescription(r.getDescription());
        
        
    }
    
    private String validateDouble(String s, String err)
    {
        try{
            Double.parseDouble(s);
            
            return "";
        }
        catch(NumberFormatException ex)
        {
            return err;
        }
    }
    
    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction()==Constants.NEW_REPORT)
            saveReport();
    }
}
