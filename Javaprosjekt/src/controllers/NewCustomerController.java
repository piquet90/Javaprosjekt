/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import models.CustomerModel;
import models.objects.Customer;
import views.NewCustomerPanel;
import views.View;

/**
 *
 * @author rudiwyu
 */
public class NewCustomerController extends Controller{
    
    Registries dataAccessObject;
    NewCustomerPanel view;
    
    
    
    public NewCustomerController(Registries r, View v)
    {
        this.dataAccessObject = r;
        this.view = (NewCustomerPanel) v;
        this.view.addController(this);
        this.view.initComponents();
        
    }
    
    public void register()
    {
        String s = "";
        
        
        String fornavn = view.getFornavn();
        String etternavn = view.getEtternavn();
        String adresse = view.getAdresse();
        String poststed = view.getPostSted();
        int postnr = 0;
        

        
        // field validation
        if(fornavn.equals(""))
            s += "Fornavn \n";          
        if(etternavn.equals(""))
            s += "Etternavn \n";
        if(adresse.equals(""))
            s += "Adresse \n";
        
        try{
            postnr = Integer.parseInt(view.getPostNr());
        }catch(NumberFormatException e)
        {
            s+="Postnummer\n";
        }
        
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
                view.showError("Bruker registert. \n\n"+
                        "Fornavn: "+fornavn+"\n"+
                        "Etternavn: "+etternavn+"\n"+
                        "Adresse: "+adresse+"\n"+
                        "Poststed: "+poststed+
                        "Postnummer: "+postnr);
            else
                view.showError(Constants.GENERAL_ERROR_MESSAGE);
        }
        
        
        
        
        
            
        
    }
}
