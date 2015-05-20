/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import DAO.Constants;
import java.util.Calendar;

/**
 * HouseInsurance Class.
 * 
 * @author rudiwyu
 */
public class HouseInsurance extends PropertyInsurance{


    /**
     * Returns the type of insurance
     * @return house insurance
     */
    public String getType()
    {
        return Constants.HOUSE_INSURANCE;
    }
   


}
