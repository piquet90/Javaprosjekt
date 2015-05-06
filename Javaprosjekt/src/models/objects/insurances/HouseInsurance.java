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
     * Construct for HouseInsurance
     * Is the same as PropertyInsurance
     * 
     * @see PropertyInsurance
     */
    public HouseInsurance(
            int id, String address, String type, String construtionmaterial, String standard, int squaremeter, int yearofconstruction, double buildingcoverage, double contentscoverage, int price, String conditions, String other, Calendar dateofcreation) {
        super(id, address, type, construtionmaterial, standard, squaremeter, yearofconstruction, buildingcoverage, contentscoverage, price, conditions, other, dateofcreation);
    }


    public String getType()
    {
        return Constants.HOUSE_INSURANCE;
    }
   


}
