/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;


import controllers.MainController;
import java.awt.Font;
import javax.swing.*;
import views.registrations.NewReportPanel;

/**
 *
 * 
 * @author Rudi
 */
public class MenuView extends JMenuBar{

    JMenu customer, insurance, report;
    JMenuItem newCustomer, viewCustomer;
    JMenuItem newInsurance, viewInsurance;
    JMenuItem newReport, viewReport;
     
    
    private MainController controller;
    
    public MenuView(MainController c)
    {
        super();
        Font f = new Font("Arial", Font.PLAIN, 16);
        UIManager.put("Menu.font", f);
        controller = c;
        
        
        customer = new JMenu("Kunder");
        insurance = new JMenu("Forsikringer");
        report = new JMenu("Skademelding");
        
        newCustomer = new JMenuItem("Ny kunde");
        viewCustomer = new JMenuItem("Vis alle kunder");
        
        customer.add(newCustomer);
        customer.add(viewCustomer);
        
        newInsurance = new JMenuItem("Ny forsikring");
        viewInsurance = new JMenuItem("Vis alle forsikringer");
        
        insurance.add(newInsurance);
        insurance.add(viewInsurance);
        
        newReport = new JMenuItem("Ny skademelding");
        viewReport = new JMenuItem("Vis alle skademeldinger");
        
        report.add(newReport);
        report.add(viewReport);
        
        //TODO: remove before production bugbug
        
        JMenu test = new JMenu("Testing");
        JMenuItem refresh = new JMenuItem("Refresh");
        
        
        
        
        this.add(customer);
        this.add(insurance);
        this.add(report);
        this.add(test);
        
        newReport.addActionListener((e)->{controller.rController.newReport();});
        newCustomer.addActionListener((e)->{controller.ncController.newCustomer();});
    }
    
}
