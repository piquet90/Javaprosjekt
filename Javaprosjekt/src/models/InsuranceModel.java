/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import models.objects.insurances.*;
/**
 *
 * @author rudiwyu
 */
public class InsuranceModel {
    
    HashSet<Insurance> insurances;
    CustomerModel customers;
    
    /**
     * InsuranceModels constructor
     * @param r registries
     */
    public InsuranceModel(Registries r)
    {
        this.insurances = r.getInsurances();
        this.customers = new CustomerModel(r);
    }
    
    /**
     * Finds an insurance by insurance id
     * @param id insurance id
     * @return insurance matching the recieved id
     */
    public Insurance findById(int id)
    {
        Iterator<Insurance> i = insurances.iterator();
        
        while(i.hasNext())
        {
            Insurance obj = i.next();
            if(obj.getId()==id)
                return obj;
        }
        return null;
    }
    
    /**
     * Finds all insurances registered to a customer
     * @param id customer id
     * @return the customers insurances
     */
    public HashSet<Insurance> findByOwnerId(int id)
    {
        Iterator<Insurance> i = insurances.iterator();
        HashSet<Insurance> result = new HashSet<>();
        while(i.hasNext())
        {
            Insurance obj = i.next();
            if(obj.getOwnerId()==id)
                result.add(obj);
        }
        
        return result;
        
    }
    
    /**
     * Adds an insurance
     * @param i insurance
     */
    public void addInsurance(Insurance i)
    {
        /*
        HashSet<Insurance> ins = findByOwnerId(i.getOwnerId());
        
        Count<Object, Integer> result = new Count<>();
        
        Iterator<Insurance> it = ins.iterator();
        
        while(it.hasNext())
        {
            result.add(it.next().getType());
        }
        
        if(result.size()>=Constants.TOTALCUSTOMER_REQUIRMENT)
        {
            Customer c = customers.findById(i.getOwnerId());
            c.setTotalCustomer(true);
        }
        */
        
        insurances.add(i);
    }
    
    /**
     * Returns all car insurances
     * @return car insurances
     */
    public HashSet<CarInsurance> getCarInsurances()
    {
        Iterator i = insurances.iterator();
        HashSet<CarInsurance> result = new HashSet<>();
        while(i.hasNext())
        {
            Object obj = i.next();
            if(obj instanceof CarInsurance)
            {
                result.add((CarInsurance)obj);
            }
        }
        return result;
    }
    
    
    private class Count<K, V> extends HashMap {
        public void add(K o) {
            int count = this.containsKey(o) ? ((Integer)this.get(o)).intValue() + 1 : 1;
            super.put(o, (V) new Integer(count));
        }
    }
}
