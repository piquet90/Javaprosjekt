/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.Registries;
import java.util.HashSet;
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
}
