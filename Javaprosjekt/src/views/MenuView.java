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

    private JMenu customer, statistics, search, report;
    private JMenuItem newCustomer, viewCustomer, newReport, viewReport, showStats, advancedSearch;
    private MainController controller;
    
    /**
     * MenuViews contstructor
     * @param c controller
     */
    public MenuView(MainController c)
    {
        super();
        Font f = new Font("Arial", Font.PLAIN, 14);
        UIManager.put("Menu.font", f);
        controller = c;
        
        
        customer = new JMenu("Kunder");
        statistics = new JMenu("Statistikk");
        search = new JMenu("Søk");
        report = new JMenu("Skademelding");
        
        
        newCustomer = new JMenuItem("Ny kunde");
        viewCustomer = new JMenuItem("Vis alle kunder");
        customer.add(newCustomer);
        customer.add(viewCustomer);
        
        newReport = new JMenuItem("Ny skademelding");
        viewReport = new JMenuItem("Vis alle skademeldinger");
        report.add(newReport);
        report.add(viewReport);
        
        showStats = new JMenuItem("Vis statistikk");
        statistics.add(showStats);
        
        advancedSearch = new JMenuItem("Avansert søk");
        search.add(advancedSearch);
        
        
        this.add(customer);
        this.add(search);
        this.add(statistics);
        this.add(report);
        
        
        
        newCustomer.addActionListener((e)->{controller.regController.newUser();});
        showStats.addActionListener((e) -> c.popUp(new StatisticsView()));
        advancedSearch.addActionListener((e) -> c.popUp(new AdvancedSearchPanel()));
    }
    
}
