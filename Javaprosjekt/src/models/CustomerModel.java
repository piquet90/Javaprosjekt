/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.Registries;
import java.util.HashSet;
import java.util.Iterator;
import models.objects.insurances.Insurance;


/**
 *
 * @author rudiwyu
 */
public class CustomerModel {
    
    HashSet<Customer> customers;
    HashSet<Insurance> insurances;
    
    /**
     * CustomerModels constructor recieves a registries object
     * @param r registries
     */
    public CustomerModel(Registries r)
    {
        this.customers = r.getCustomers();
        this.insurances = r.getInsurances();
    }
    
    /**
     * Creates a new customer if the ID doesnt exist
     * @param c customer object
     * @return true for success, false for failure
     */
    public boolean newCustomer(Customer c)
    {
        if(findById(c.getId())!=null)
            return false;
        
        customers.add(c);
        
        return true;
    }
    
    /**
     * Returns a list of all customers
     * @return hashset of customers
     */
    public HashSet<Customer> getCustomers()
    {
        return customers;
    }

    /**
     * Finds a customer with ID-number matching the incoming parameter
     * @param id customer id to be searched for
     * @return customer object if the id number matches, null if not
     */
    public Customer findById(int id)
    {
        Iterator<Customer> i = customers.iterator();
        
        while(i.hasNext())
        {
            Customer obj = i.next();
            if(obj.getId()==id)
                return obj;
        }
        return null;
    }
    
    /**
     * Finds one or more customer(s) with name matching the incoming parameter
     * @param s the search word to be searched for
     * @return customer object(s) that matches the search word
     */
    public HashSet<Customer> searchName(String s)
    {
        Iterator<Customer> i = customers.iterator();
        s = s.toLowerCase();
        HashSet<Customer> result = new HashSet<>();
        
        while(i.hasNext())
        {
            Customer obj = i.next();
            if(obj.getName().toLowerCase().contains(s))
                result.add(obj);
        }
        
        return result;
    }
    
    /**
     * Finds insurances to the customer with customer id matching the incoming parameter
     * @param id customer id to find insurances to
     * @return hashset of customers insurances
     */
    public HashSet<Insurance> findInsuranceByUserId(int id)
    {
        Iterator<Insurance> i = insurances.iterator();
        
        HashSet<Insurance> result = new HashSet<>();
        while(i.hasNext())
        {
            Insurance obj = i.next();
            
            if(obj.getOwnerId() == id )
                result.add(obj);
            
        }
        
        return result;
        
        
    }
}
