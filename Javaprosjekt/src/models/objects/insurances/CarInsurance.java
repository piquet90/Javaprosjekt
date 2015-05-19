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
    private double pricePrKm;
    private int kmPerYear;
    private int kmDriven;
    private int bonus;
    private String carType;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

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

    public double getPricePrKm() {
        return pricePrKm;
    }

    public void setPricePrKm(double pricePrKm) {
        this.pricePrKm = pricePrKm;
    }

    public int getKmPerYear() {
        return kmPerYear;
    }

    public void setKmPerYear(int kmPerYear) {
        this.kmPerYear = kmPerYear;
    }
    
}
