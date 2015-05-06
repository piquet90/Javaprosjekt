package models.objects.insurances;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import DAO.Constants;
import models.objects.insurances.VehicleInsurance;
import java.util.Calendar;

/**
 *
 * @author rudiwyu
 */
public class CarInsurance extends VehicleInsurance{
    
    /**
     * TODO: Comment and refactor
     * @param price
     * @param coverage
     * @param conditions
     * @param other
     * @param dateofcreation
     * @param viechleOwner
     * @param registrationNumber
     * @param type
     * @param model
     * @param power
     */
    public CarInsurance(int id, int price, int coverage, String conditions, String other, Calendar dateofcreation, String viechleOwner, String registrationNumber, String type, String model, int power) {
        super(id, price, coverage, conditions, other, dateofcreation, viechleOwner, registrationNumber, type, model, power);
        
    }

    public String getType()
    {
        return Constants.CAR_INSURANCE;
    }
    
}
