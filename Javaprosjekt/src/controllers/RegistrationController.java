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
    
    /**
     * RegistrationControllers constructor
     * @param r registries
     * @param m maincontroller
     */
    public RegistrationController(Registries r, MainController m)
    {
        this.mc = m;
        this.registries = r;
    }
    
    /**
     * Calls maincontrollers popup and displays a new insurance form
     */
    public void newInsurance()
    {
        regInsuranceView = new NewInsurancePanel();
        mc.popUp(Constants.NEW_INSURANCE_TEXT, regInsuranceView);
    }
    
    /**
     * Calls maincontrollers popup and displays a new customer form
     */
    public void newUser()
    {
        regCustomerView = new NewCustomerPanel();
        regCustomerView.addCustomListener(this);
        mc.popUp(Constants.NEW_CUSTOMER_TEXT, regCustomerView);
    }
    
    /**
     * Validates customer fields when registering a customer, and saves it
     */
    public void registerUser()
    {
        if(regCustomerView==null)
            return;
        String s = "";
        
        
        String fornavn = regCustomerView.getFirstName();
        String etternavn = regCustomerView.getLastName();
        String adresse = regCustomerView.getAdress();
        String poststed = regCustomerView.getCity();
        String postnr = regCustomerView.getZip();
        

        // field validation
        if(fornavn.equals(""))
            s += "Fornavn \n";          
        if(etternavn.equals(""))
            s += "Etternavn \n";
        if(adresse.equals(""))
            s += "Adresse \n";
        if(!Pattern.matches(Constants.AREA_CODE, postnr))
            s += "Poststed \n";
        if(!s.equals(""))
        {
            regCustomerView.showError("Manglende felter: \n\n"+s+"\nVennligst fyll inn alle felter");
        }
        else {
            
            Customer c = new Customer(fornavn, etternavn, adresse, poststed, postnr);
            m = new CustomerModel(registries);
            m.newCustomer(c);
            mc.vcController.update();
            regCustomerView.clearAll();
            regCustomerView.showError("Bruker registert. \n\n"+
                    "Fornavn: "+fornavn+"\n"+
                    "Etternavn: "+etternavn+"\n"+
                    "Adresse: "+adresse+"\n"+
                    "Poststed: "+poststed+"\n"+
                    "Postnummer: "+postnr);
  
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
