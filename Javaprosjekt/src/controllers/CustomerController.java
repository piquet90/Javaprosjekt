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
import models.objects.insurances.CarInsurance;
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
    
    // Views
    private CustomerView view;
    
    // model 
    private CustomerModel m;
    
    private Customer customer;
    
    
    // constructor
    public CustomerController(Registries r, MainController m)
    {
        this.registries = r;
        this.mc = m;
        this.m = new CustomerModel(r);
    }
    
    public void viewCustomer(int i)
    {
        // find customer
        customer = m.findById(i);
        
        // make view
        CustomerView cus = new CustomerView();
        cus.addCustomListener(this);
        this.view = cus;
        // fill Customer info
        cus.setfNavn(customer.getFirstname());
        cus.seteNavn(customer.getLastname());
        cus.setAdresse(customer.getAddressStreet());
        cus.setPostNr(customer.getAreacode());
        cus.setPostSted(customer.getCity());
        
        // fill insurances
        HashSet<Insurance> set = m.findInsuranceByUserId(i);
        InsuranceTable table = new InsuranceTable(set);
        ViewTable viewTable = new ViewTable(table);
        cus.addTable("Forsikringer", viewTable);
        
        // show view
        mc.popUp(customer.getName(), cus);
        
    }// end of viewCustomer
    
    public void newInsurance()
    {
        mc.regController.newInsurance(customer.getId());
    }
    public void newReport()
    {
        System.out.println("new report for ID: "+customer.getId());
    }
    public void save()
    {
        
        String s = "";
        
        
        String fornavn = view.getfNavn();
        String etternavn = view.geteNavn();
        String adresse = view.getAdresse();
        String poststed = view.getPostSted();
        String postnr = view.getPostNr();
        

        // field validation
        if(fornavn.equals("")) // validation of names is silly
            s += "Fornavn \n";          
        if(etternavn.equals(""))
            s += "Etternavn \n";
        if(adresse.equals(""))
            s += "Adresse \n";
        if(!Pattern.matches(Constants.AREA_CODE, postnr)) // validation of areacode makes sense.
            s += "Poststed \n";
        if(poststed.equals(""))
            s += "Poststed \n";
        if(!s.equals(""))
        {
            view.showError("Manglende felter: \n\n"+s+"\nVennligst fyll inn alle felter");
        }
        else {
            customer.setFirstName(fornavn);
            customer.setLastName(etternavn);
            customer.setAddressStreet(adresse);
            customer.setAreacode(postnr);
            customer.setCity(poststed);
            mc.vcController.update();
            view.endre();
        }
    }
    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction()==Constants.NEW_CUSTOMER)
            save();
        if(i.getAction()==Constants.NEW_INSURANCE)
        {
            if(i.getValue()==Constants.BOAT_INSURANCE_INT)
                mc.insController.newBoatInsurance();
            if(i.getValue()==Constants.CAR_INSURANCE_INT)
                mc.insController.newCarInsurance();
            if(i.getValue()==Constants.HOUSE_INSURANCE_INT)
                mc.insController.newHouseInsurance();
            if(i.getValue()==Constants.LEISUREHOUSE_INSURANCE_INT)
                mc.insController.newLeisureHouseInsurance();
            if(i.getValue()==Constants.TRAVEL_INSURANCE_INT)
                mc.insController.newTravelInsurance();
        }
        if(i.getAction()==Constants.NEW_REPORT)
            newReport();
    }
}// end of class
