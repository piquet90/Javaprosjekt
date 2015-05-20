/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;


import DAO.Constants;
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

    private JMenu customer, statistics, search;
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
        
        
        newCustomer = new JMenuItem("Ny kunde");
        viewCustomer = new JMenuItem("Vis alle kunder");
        customer.add(newCustomer);
        customer.add(viewCustomer);
        
        
        
        showStats = new JMenuItem("Vis statistikk");
        statistics.add(showStats);
        
        advancedSearch = new JMenuItem("Avansert søk");
        search.add(advancedSearch);
        
        add(customer);
        add(search);
        add(statistics);
        

        newCustomer.addActionListener((e)->{controller.regController.newUser();});
        viewCustomer.addActionListener((e) -> controller.vcController.update());
        showStats.addActionListener((e) -> controller.startStatistics());
        advancedSearch.addActionListener((e) -> controller.sController.customActionPerformed(new CustomEvent(Constants.ADVANCED_SEARCH)));
    }
    
}
