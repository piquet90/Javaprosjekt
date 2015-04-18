/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.util.HashSet;
import models.objects.Customer;
import models.objects.insurances.Insurance;

/**
 *
 * @author rudiwyu
 */
public class Registries {
    
    
    private HashSet<Insurance> insurances;
    private HashSet<Customer> customers;
    
    public Registries()
    {
        insurances = new HashSet<>();
        customers = new HashSet<>();
    }
    
    public HashSet<Insurance> getInsurances()
    {
        return this.insurances;
    }
    
    public HashSet<Customer> getCustomers()
    {
        return this.customers;
    }
    
    
}
