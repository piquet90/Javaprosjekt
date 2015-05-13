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
    
    
    private int registrationYear;
    private int kmDriven;
    private int bonus;

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getKmDriven() {
        return kmDriven;
    }

    public void setKmDriven(int kmDriven) {
        this.kmDriven = kmDriven;
    }

    public int getRegistrationYear() {
        return registrationYear;
    }

    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }
    
    public CarInsurance()
    {
        
    }

    public String getType()
    {
        return Constants.CAR_INSURANCE;
    }
    
}
