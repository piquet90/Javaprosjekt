/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.*;
import TableModels.InsuranceTable;
import TableModels.ReportTable;
import java.util.HashSet;
import java.util.regex.Pattern;
import models.CustomerModel;
import models.Customer;
import models.InsuranceModel;
import models.Report;
import models.ReportModel;
import models.objects.insurances.Insurance;
import views.CustomerView;
import views.CustomEvent;
import views.CustomListener;
import views.ViewTable;

/**
 * CustomerController
 * Responsible for creating and viewing customers.
 * 
 * @author rudiwyu
 */
public class CustomerController extends Controller implements CustomListener{
    
    
    // Maincontroller
    private MainController mc;
    
    // Views
    private CustomerView view;
    
    // model 
    private CustomerModel m;
    private InsuranceModel i;
    private ReportModel r;
    
    private Customer customer;
    
    private ViewTable insuranceTable, reportTable;
    
    private CustomerView cus;
    
    
    /**
     * CustomerControllers constructor
     * @param r registries
     * @param m maincontroller
     */
    public CustomerController(Registries r, MainController m)
    {

        this.mc = m;
        this.m = new CustomerModel(r);
        this.i = new InsuranceModel(r);
        this.r = new ReportModel(r);
    }
    
    /**
     * Finds a customer and the customers insurances and reports
     * @param i customer id
     */
    public void viewCustomer(int i)
    {
        // find customer
        customer = m.findById(i);
        
        // make view
        cus = new CustomerView();
        cus.addCustomListener(this);
        this.view = cus;
        // fill Customer info
        cus.setFName(customer.getFirstname());
        cus.setLName(customer.getLastname());
        cus.setAdress(customer.getAddressStreet());
        cus.setZip(customer.getAreacode());
        cus.setCity(customer.getCity());
        if(customer.isTotalCustomer())
            cus.setTotalCustomer("Ja");
        else
            cus.setTotalCustomer("Nei");
        
        
        // fill insurances
        HashSet<Insurance> set = this.i.findByOwnerId(customer.getId());
        InsuranceTable table = new InsuranceTable(set);
        insuranceTable = new ViewTable(table);
        insuranceTable.addCustomListener(this);
        cus.addTable("Forsikringer", insuranceTable);
        

        HashSet<Report> repSet = this.r.getReportsByCustomerId(i);
        ReportTable repTable = new ReportTable(repSet);
        reportTable = new ViewTable(repTable);
        cus.addTable("Skademeldinger", reportTable);
        
        // show view
        mc.popUp(customer.getName(), cus);
        
    }// end of viewCustomer
    
    
    /**
     * Updates the customers insurance table
     */
    public void refresh()
    {
        HashSet<Insurance> set = this.i.findByOwnerId(customer.getId());
        insuranceTable.setModel(new InsuranceTable(set));
        HashSet<Report> repSet = this.r.getReportsByCustomerId(customer.getId());
        reportTable.setModel(new ReportTable(repSet));
        if(customer.isTotalCustomer())
            cus.setTotalCustomer("Ja");
        else
            cus.setTotalCustomer("Nei");
        view.revalidate();
        view.repaint();
    }
    
    /**
     * Adds a new insurance to the customer
     */
    public void newInsurance()
    {
        mc.regController.newInsurance();
    }
     
    /**
     * Saves the customer information
     */
    public void save()
    {
        
        String s = "";
        
        
        String firstName = view.getFName();
        String lastName = view.getLName();
        String adress = view.getAdress();
        String city = view.getCity();
        String zip = view.getZip();
        

        // field validation
        if(firstName.equals("")) // validation of names is silly
            s += "Fornavn \n";          
        if(lastName.equals(""))
            s += "Etternavn \n";
        if(adress.equals(""))
            s += "Adresse \n";
        if(!Pattern.matches(Constants.AREA_CODE, zip)) // validation of areacode makes sense.
            s += "Postnummer \n";
        if(city.equals(""))
            s += "Poststed \n";
        if(!s.equals(""))
        {
            view.showError("Manglende felter: \n\n"+s+"\nVennligst fyll inn alle felter");
        }
        else {
            customer.setFirstName(firstName);
            customer.setLastName(lastName);
            customer.setAddressStreet(adress);
            customer.setAreacode(zip);
            customer.setCity(city);
            mc.vcController.update();
            view.change();
        }
    }
    
    /**
     * ActionListener
     * @param i CustomEvent
     */
    @Override
    public void customActionPerformed(CustomEvent i) {
        
        if(i.getAction()==Constants.DOUBLECLICK)
            mc.insController.viewInsurance(i.getValue());
        if(i.getAction()==Constants.NEW_CUSTOMER)
            save();
        if(i.getAction()==Constants.NEW_INSURANCE)
        {
            if(i.getValue()==Constants.BOAT_INSURANCE_INT)
                mc.insController.newBoatInsurance(customer.getId());
            if(i.getValue()==Constants.CAR_INSURANCE_INT)
                mc.insController.newCarInsurance(customer.getId());
            if(i.getValue()==Constants.HOUSE_INSURANCE_INT)
                mc.insController.newHouseInsurance(customer.getId());
            if(i.getValue()==Constants.LEISUREHOUSE_INSURANCE_INT)
                mc.insController.newLeisureHouseInsurance(customer.getId());
            if(i.getValue()==Constants.TRAVEL_INSURANCE_INT)
                mc.insController.newTravelInsurance(customer.getId());
        }
        if(i.getAction()==Constants.NEW_REPORT)
            mc.rController.newReport(customer.getId());
    }
}// end of class
