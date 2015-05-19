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

    private String engineType;
    private int modelYear, length;

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    
    public String getType()
    {
        return Constants.BOAT_INSURANCE;
    }
    
    


    
}
