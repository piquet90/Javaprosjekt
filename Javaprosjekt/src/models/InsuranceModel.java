/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.*;
import java.util.ArrayList;
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
    
    // todo: write comments
    public InsuranceModel(Registries r)
    {
        this.insurances = r.getInsurances();
        this.customers = new CustomerModel(r);
    }
    
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
        return  result;
    }
    private class Count<K, V> extends HashMap{
        public void add(K o) {
            int count = this.containsKey(o) ? ((Integer)this.get(o)).intValue() + 1 : 1;
            super.put(o, (V) new Integer(count));
        }
    }
}
