/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashSet;
import models.objects.Customer;
import models.objects.insurances.Insurance;

/**
 *
 * @author rudiwyu
 */
public class Registries implements Serializable{
    
    
    private static final long serialVersionUID = 123L;
    
    private HashSet<Insurance> insurances;
    private HashSet<Customer> customers;
    
    public Registries()
    {
        
        fromFile();
        insurances = new HashSet<>();
        customers = new HashSet<>();
    }
    
    private void fromFile()
    {
        
    }
    public HashSet<Insurance> getInsurances()
    {
        return this.insurances;
    }
    
    public HashSet<Customer> getCustomers()
    {
        return this.customers;
    }
    public void save()
    {
        try {
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/liste.data"));
        
        }catch(Exception e)
        {
            
        }
        
    }
    
    
}
