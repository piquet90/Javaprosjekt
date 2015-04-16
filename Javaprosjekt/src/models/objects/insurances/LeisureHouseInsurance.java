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
public class LeisureHouseInsurance extends PropertyInsurance{

    /**
     *
     * @param address
     * @param type
     * @param construtionmaterial
     * @param standard
     * @param squaremeter
     * @param yearofconstruction
     * @param buildingcoverage
     * @param contentscoverage
     * @param price
     * @param coverage
     * @param conditions
     * @param other
     * @param dateofcreation
     */
    public LeisureHouseInsurance(
            String address, 
            String type, 
            String construtionmaterial, 
            String standard, int squaremeter, 
            int yearofconstruction, 
            double buildingcoverage, 
            double contentscoverage, 
            int price, 
            double coverage, 
            String conditions, 
            String other, 
            Date dateofcreation) 
    {
        super(address, type, construtionmaterial, standard, squaremeter, yearofconstruction, buildingcoverage, contentscoverage, price, coverage, conditions, other, dateofcreation);
    }


    
}
