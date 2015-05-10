/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
import DAO.Registries;
import java.util.regex.Pattern;
import models.Customer;
import models.CustomerModel;
import views.CustomEvent;
import views.CustomListener;
import views.registrations.NewCustomerPanel;
import views.registrations.NewInsurancePanel;

/**
 *
 * @author Rudi
 */
public class RegistrationController implements CustomListener{

    private NewCustomerPanel regCustomerView;
    private NewInsurancePanel regInsuranceView;
    private MainController mc;
    private Registries registries;
    private CustomerModel m;
    
    
    public RegistrationController(Registries r, MainController m)
    {
        this.mc = m;
        this.registries = r;
    }
    
    public void newInsurance(int id)
    {
        regInsuranceView = new NewInsurancePanel();
        mc.popUp(Constants.NEW_INSURANCE_TEXT, regInsuranceView);
    }
    
    public void newUser()
    {
        regCustomerView = new NewCustomerPanel();
        regCustomerView.addCustomListener(this);
        mc.popUp(Constants.NEW_CUSTOMER_TEXT, regCustomerView);
    }
    public void registerUser()
    {
        if(regCustomerView==null)
            return;
        String s = "";
        
        
        String fornavn = regCustomerView.getFornavn();
        String etternavn = regCustomerView.getEtternavn();
        String adresse = regCustomerView.getAdresse();
        String poststed = regCustomerView.getPostSted();
        String postnr = regCustomerView.getPostNr();
        

        // field validation
        if(fornavn.equals("")) // validation of names is silly
            s += "Fornavn \n";          
        if(etternavn.equals(""))
            s += "Etternavn \n";
        if(adresse.equals(""))
            s += "Adresse \n";
        if(!Pattern.matches(Constants.AREA_CODE, postnr)) // validation of areacode makes sense.
            s += "Poststed \n";
        if(!s.equals(""))
        {
            regCustomerView.showError("Manglende felter: \n\n"+s+"\nVennligst fyll inn alle felter");
        }
        else {
            
            Customer c = new Customer(fornavn, etternavn, adresse, poststed, postnr);
            m = new CustomerModel(registries);
            if(m.newCustomer(c))
            {
                mc.vcController.update();
                regCustomerView.clearAll();
                regCustomerView.showError("Bruker registert. \n\n"+
                        "Fornavn: "+fornavn+"\n"+
                        "Etternavn: "+etternavn+"\n"+
                        "Adresse: "+adresse+"\n"+
                        "Poststed: "+poststed+"\n"+
                        "Postnummer: "+postnr);
                
            }
            else
                regCustomerView.showError(Constants.GENERAL_ERROR_MESSAGE);
            
            
        }
    }  // end of register()
    
    
    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction()==Constants.REGISTER_BUTTON_PRESSED)
        {
            if(i.getValue()==Constants.NEW_CUSTOMER)
                registerUser();
        }        
    }
    
}