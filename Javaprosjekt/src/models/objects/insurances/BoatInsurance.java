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
public class BoatInsurance extends VehicleInsurance{

    
    public String getType()
    {
        return Constants.BOAT_INSURANCE;
    }


    
}
