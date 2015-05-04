/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import DAO.Registries;
import java.util.HashSet;
import models.*;
import models.objects.Customer;

/**
 *
 * @author rudiwyu
 */
public class ModelTests {
    
    
    public static void main(String[]args)
    {
        
        Registries r = new Registries();
        CustomerModel customer = new CustomerModel(r);
        InsuranceModel insurance = new InsuranceModel(r);
        
        Customer rudi = customer.findById(1);
        if(rudi.getFirstname().equals("Rudi"))
            System.out.println("Find by ID: Pass");
        
        HashSet<Customer> result = customer.searchName("brustad");
        if(result.isEmpty())
            System.out.println("Find by partial name: Fail");
        else
            System.out.println("Find by partial name: Pass");
        
        result = customer.searchName("LOLOLOLOLOL");
        if(result.isEmpty())
            System.out.println("Does not find not exist: Pass");
        else
            System.out.println("Does not find not exist: Fail");
        
        
        
    }
}
