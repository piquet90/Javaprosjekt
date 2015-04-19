/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author rudiwyu
 */

import java.util.Date;
import DAO.*;
import java.util.HashSet;
import java.util.Iterator;
import models.objects.insurances.*;
import models.*;

public class RegistriesTest {
    
    
    public static void main(String[]args)
    {
        Registries r = new Registries();
        HashSet<Insurance> i = r.getInsurances();
        InsuranceModel m = new InsuranceModel(r);
        // testing compare by changing ID to an ID that is already in the registry and inserting.
        
        Insurance s = new HouseInsurance("Address 1", "Type 1", "Material1", "Standard1", 100, 2015, 5000000, 400000, 3000, "CONDITIONS1", "Other1", new Date());
        Insurance b = new HouseInsurance("Address 1", "Type 1", "Material1", "Standard1", 100, 2015, 5000000, 400000, 3000, "CONDITIONS2", "Other1", new Date());
        i.add(new HouseInsurance("Address 1", "Type 1", "Material1", "Standard1", 100, 2015, 5000000, 400000, 3000, "CONDITIONS3", "Other1", new Date()));
        b.setId(1);
        i.add(b);
        i.add(s);
        
        System.out.println("Insurance added to HashSet");
        
        
        Iterator iter = i.iterator();
        while(iter.hasNext())
        {
            System.out.println(((Insurance)iter.next()).getId());
        }
        
        System.out.println("Now using model to get data");
        
        System.out.println(m.findById(1).getConditions());
        System.out.println(m.findById(1).getId());
        System.out.println(m.findById(3).getConditions());
        System.out.println(m.findById(3).getId());

        
        
        
        
        
        
        
    }
    
}
