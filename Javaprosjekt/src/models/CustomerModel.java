/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.Registries;
import java.util.HashSet;
import java.util.Iterator;
import models.objects.Customer;


/**
 *
 * @author rudiwyu
 */
public class CustomerModel {
    
    HashSet<Customer> customers;
    
    public CustomerModel(Registries r)
    {
        this.customers = r.getCustomers();
    }
    
    public boolean newCustomer(Customer c)
    {
        if(findById(c.getId())!=null)
            return false;
        
        customers.add(c);
        
        return true;
    }
    public HashSet<Customer> getCustomers()
    {
        return customers;
    }

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
}
