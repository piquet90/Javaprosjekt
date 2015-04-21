/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;
import java.util.Calendar;

/**
 * LeisureHouseInsuranceClass.
 *
 * @author rudiwyu
 */
public class LeisureHouseInsurance extends PropertyInsurance{

    /**
     * Constructor for LeisureHouseInsurance
     * Is the same as PropertyInsurance
     * @see PropertyInsurance
     * 
     */
    public LeisureHouseInsurance(String address, String type, String construtionmaterial, String standard, int squaremeter, int yearofconstruction, double buildingcoverage, double contentscoverage, int price, String conditions, String other, Calendar dateofcreation) {
        super(address, type, construtionmaterial, standard, squaremeter, yearofconstruction, buildingcoverage, contentscoverage, price, conditions, other, dateofcreation);
    }




    
}
