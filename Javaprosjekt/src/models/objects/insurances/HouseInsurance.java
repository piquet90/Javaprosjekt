/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import java.util.Date;

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
            String address, String type, String construtionmaterial, String standard, int squaremeter, int yearofconstruction, double buildingcoverage, double contentscoverage, int price, String conditions, String other, Date dateofcreation) {
        super(address, type, construtionmaterial, standard, squaremeter, yearofconstruction, buildingcoverage, contentscoverage, price, conditions, other, dateofcreation);
    }



   


}
