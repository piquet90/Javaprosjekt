/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import java.util.Date;

/**
 *
 * @author rudiwyu
 */
public class HouseInsurance extends PropertyInsurance{

    public HouseInsurance(int price, int coverage, String conditions, String other, Date dateofcreation) {
        super(price, coverage, conditions, other, dateofcreation);
    }
    
}
