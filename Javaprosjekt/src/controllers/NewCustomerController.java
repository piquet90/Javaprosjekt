/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import java.util.Calendar;
import views.NewUserPanel;
import views.View;

/**
 *
 * @author rudiwyu
 */
public class NewCustomerController implements Controller{
    
    Registries dataAccessObject;
    NewUserPanel newCustomerView;
    
    
    
    public NewCustomerController(Registries r, View v)
    {
        this.dataAccessObject = r;
        this.newCustomerView = (NewUserPanel) v;
        this.newCustomerView.addController(this);
        this.newCustomerView.initComponents();
        
    }
    
    public void register()
    {
        
        try{
        
        Calendar date = Calendar.getInstance();
        String fornavn = view.getFornavn();
        String etternavn = view.getEtternavn();
        String adresse = view.getAdresse();
        String poststed = view.getPostSted();
        int postnr = Integer.parseInt(view.getPostNr());
        view.showError("Success!");
        }catch(NumberFormatException e)
        {
            view.showError("Postnummer er ikke gyldig");
        }
        
    }
}
