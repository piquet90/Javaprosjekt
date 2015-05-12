/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.*;
import java.util.HashSet;
import java.util.Iterator;
import models.objects.insurances.*;
/**
 *
 * @author rudiwyu
 */
public class InsuranceModel {
    
    HashSet<Insurance> insurances;
    
    // todo: write comments
    public InsuranceModel(Registries r)
    {
        this.insurances = r.getInsurances();
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
}
