/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import java.util.Calendar;
import models.CustomerModel;
import models.objects.Customer;
import views.NewUserPanel;
import views.View;

/**
 *
 * @author rudiwyu
 */
public class NewCustomerController extends Controller{
    
    Registries dataAccessObject;
    NewUserPanel view;
    
    
    
    public NewCustomerController(Registries r, View v)
    {
        this.dataAccessObject = r;
        this.view = (NewUserPanel) v;
        this.view.addController(this);
        this.view.initComponents();
        
    }
    
    public void register()
    {
        String s = "";
        try{
        
        Calendar date = Calendar.getInstance();
        String fornavn = view.getFornavn();
        String etternavn = view.getEtternavn();
        String adresse = view.getAdresse();
        String poststed = view.getPostSted();
        int postnr = Integer.parseInt(view.getPostNr());
        
        
        // field validation
        if(fornavn.equals(""))
            s += "Fornavn \n";          
        if(etternavn.equals(""))
            s += "Etternavn \n";
        if(adresse.equals(""))
            s += "Adresse \n";
        if(poststed.equals(""))
            s += "Poststed \n";
        if(!s.equals(""))
        {
            view.showError("Manglende felter: \n\n"+s+"\nVennligst fyll inn alle felter");
        }
        else {
            
            Customer c = new Customer((fornavn+" "+etternavn), adresse, poststed, postnr);
            CustomerModel m = new CustomerModel(dataAccessObject);
            if(m.newCustomer(c))
                view.showError("ALL GOOD ROGER");
            else
                view.showError("something bad happened:(");
        }
        
        
        
        }catch(NumberFormatException e)
        {
            view.showError("Postnummer er ikke gyldig");
            return;
        }
        
        
            
        
    }
}
