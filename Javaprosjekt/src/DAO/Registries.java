/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.io.*;
import java.io.Serializable;
import java.util.HashSet;
import models.Customer;
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
    }
    
    private void fromFile()
    {
        try{
            FileInputStream fis = new FileInputStream(new File(Constants.FILE_SAVE_PATH));
            ObjectInputStream in = new ObjectInputStream(fis);
            
            this.insurances = (HashSet<Insurance>) in.readObject();
            this.customers = (HashSet<Customer>) in.readObject();
            Customer.setNext(in.readInt());
            Insurance.setNext(in.readInt());
            in.close();

            
        }
        catch(Exception e)
        {
            this.insurances = new HashSet<>();
            this.customers = new HashSet<>();
        }
        
        
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
            
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(Constants.FILE_SAVE_PATH));
            out.writeObject(this.insurances);
            out.writeObject(this.customers);
            out.writeInt(Customer.getNext());
            out.writeInt(Insurance.getNext());
            out.close();
        
        }catch(Exception e)
        {
            System.out.println(e.toString());
        
        }
    }
    
    
}
