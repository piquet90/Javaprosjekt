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

    JMenu customer, submenu;
    JMenuItem newCustomer, viewCustomer;
    JRadioButtonMenuItem rbMenuItem;
    JCheckBoxMenuItem cbMenuItem;
    
    private MainController controller;
    
    public MenuView(MainController c)
    {
        super();
        controller = c;
        customer = new JMenu("Kunder");
        
        newCustomer = new JMenuItem("Ny Kunde");
        viewCustomer = new JMenuItem("Vis alle Kunder");
        
        customer.add(newCustomer);
        customer.add(viewCustomer);
        
        this.add(customer);
        
        newCustomer.addActionListener((e)->{controller.nybrukerpanel();});
        viewCustomer.addActionListener((e)->{controller.viewCustomerPanel();});
    }
    
}
