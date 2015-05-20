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
import models.Customer;
import models.CustomerModel;
import views.AdvancedSearchPanel;
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
    private SimpleSearchPanel simple;
    private AdvancedSearchPanel advanced;
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
        simple = new SimpleSearchPanel();
        simple.addCustomListener(this);
        
        
        
        mc.addTop(simple);
    }
    
    public void advancedSearch()
    {
        advanced = new AdvancedSearchPanel();
        advanced.addCustomListener(this);
        mc.addTop(advanced);
    }
    
    /**
     * Method that finds out if search word is for customerID or customer name and finds matching
     */
    public void findCustomer()
    {
        String search = simple.getSearch();
        HashSet<Customer> r = new HashSet<>();
        Customer c = null;
        
        if(!search.equals(""))
        {
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
            
            table = new CustomerTable(r);
            mc.vcController.update(table);
        }
        else if(r.size() == 0)
            simple.showError("Tomt søk");
        else
            simple.showError("Feltene er ikke fylt inn korrekt");
    }

    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction() == Constants.SEARCH_CUSTOMER)
        {
            findCustomer();
        }
        else if(i.getAction() == Constants.SHOW_ALL_CUSTOMERS)
        {
            mc.vcController.update();
        }
        else if(i.getAction() == Constants.ADVANCED_SEARCH)
        {
            advancedSearch();
        }
            
    }
}
