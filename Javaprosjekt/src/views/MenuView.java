/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;


import controllers.MainController;
import javax.swing.*;

/**
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
        
        
        
        
        
        this.add(customer);
        this.add(insurance);
        
        newCustomer.addActionListener((e)->{controller.nybrukerpanel();});
        viewCustomer.addActionListener((e)->{controller.viewCustomerPanel();});
    }
    
}
