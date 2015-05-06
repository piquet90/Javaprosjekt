/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import TableModels.InsuranceTable;
import java.util.HashSet;
import java.util.regex.Pattern;
import models.CustomerModel;
import models.Customer;
import models.objects.insurances.Insurance;
import views.CustomerView;
import views.CustomEvent;
import views.CustomListener;
import views.registrations.NewCustomerPanel;
import views.ViewTable;

/**
 * CustomerController
 * Responsible for creating and viewing customers.
 * 
 * @author rudiwyu
 */
public class CustomerController extends Controller implements CustomListener{
    
    
    // Maincontroller & registries
    private MainController mc;
    private Registries registries;
    
    // View class
    private NewCustomerPanel view;
    
    // model 
    private CustomerModel m;
    
    
    // constructor
    public CustomerController(Registries r, MainController m)
    {
        this.registries = r;
        this.mc = m;
        this.m = new CustomerModel(r);
    }
    
    // load new customer view
    public void newCustomer()
    {
        view = new NewCustomerPanel();
        view.addCustomListener(this);
        mc.popUp(Constants.NEW_CUSTOMER_TEXT, view);
    }
    
    
    public void register()
    {
        String s = "";
        
        
        String fornavn = view.getFornavn();
        String etternavn = view.getEtternavn();
        String adresse = view.getAdresse();
        String poststed = view.getPostSted();
        String postnr = view.getPostNr();
        

        Pattern letters = Pattern.compile(Constants.ONLY_ALPHABETIC);
        Pattern areacode = Pattern.compile(Constants.AREA_CODE);
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
            view.showError("Manglende felter: \n\n"+s+"\nVennligst fyll inn alle felter");
        }
        else {
            
            Customer c = new Customer(fornavn, etternavn, adresse, poststed, postnr);
            m = new CustomerModel(registries);
            if(m.newCustomer(c))
            {
                mc.vcController.update();
                view.clearAll();
                view.showError("Bruker registert. \n\n"+
                        "Fornavn: "+fornavn+"\n"+
                        "Etternavn: "+etternavn+"\n"+
                        "Adresse: "+adresse+"\n"+
                        "Poststed: "+poststed+"\n"+
                        "Postnummer: "+postnr);
                
            }
            else
                view.showError(Constants.GENERAL_ERROR_MESSAGE);
            
            
        }
    }  // end of register()
    
    public void viewCustomer(int i)
    {
        Customer customer = m.findById(i);
        
        CustomerView cus = new CustomerView(customer.getFirstname(), customer.getLastname(), customer.getAddressStreet(), customer.getCity(), customer.getAreacode());
        
        HashSet<Insurance> set = m.findInsuranceByUserId(i);
        InsuranceTable table = new InsuranceTable(set);
        ViewTable viewTable = new ViewTable(table);
        
        cus.addTable("Forsikringer", viewTable);
        
        mc.popUp(customer.getName(), cus);
        
    }// end of viewCustomer

    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction()==Constants.REGISTER_BUTTON_PRESSED)
            register();
    }
}// end of class
