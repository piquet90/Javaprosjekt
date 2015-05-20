/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
import DAO.Registries;
import TableModels.CustomerTable;
import java.util.HashSet;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import models.Customer;
import models.CustomerModel;
import models.InsuranceModel;
import models.objects.insurances.Insurance;
import views.CustomEvent;
import views.CustomListener;
import views.SimpleSearchPanel;
import views.ViewTable;

/**
 *
 * @author Audun
 */
public class SearchController implements CustomListener{
    
    private MainController mc;
    private CustomerModel i;
    private SimpleSearchPanel v;
    private ViewTable view;
    private CustomerTable table;
    
    /**
     * SearchControllers constructor
     * @param r registries
     * @param m maincontroller
     */
    public SearchController(Registries r, MainController m)
    {
        mc = m;
        i = new CustomerModel(r);
        v = new SimpleSearchPanel();
        v.addCustomListener(this);
        mc.addTop(v);
    }
    
    public void findCustomer()
    {
        String search = v.getSearch();
        HashSet<Customer> r = new HashSet<>();
        Customer c = null;
        
        try
        {
            int id = Integer.parseInt(search);
            c = i.findById(id);
            r.add(c);
            
            
        }
        catch(NumberFormatException nfe)
        {
            r = i.searchName(search);
        }
        
        if(r.size() != 0)
            System.out.println("tttttttttttttttttt");
        
        table = new CustomerTable(r);
        // view = new ViewTable(table);
        mc.vcController.update(table);
        
    }

    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction() == Constants.SEARCH_INSURANCE)
        {
            findCustomer();
        }
            
    }
}
