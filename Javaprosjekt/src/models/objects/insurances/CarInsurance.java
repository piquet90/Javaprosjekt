package models.objects.insurances;

/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */


import DAO.Constants;
import models.objects.insurances.VehicleInsurance;

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

    /**
     * Returns the car type
     * @return car type
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Sets the car type
     * @param carType car type
     */
    public void setCarType(String carType) {
        this.carType = carType;
    }

    /**
     * Returns the car insurance bonus (max 75%)
     * @return bonus in percentage
     */
    public int getBonus() {
        return bonus;
    }

    /**
     * Sets the car insurance bonus
     * @param bonus bonus in percentage
     */
    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    /**
     * Returns the cars registration year
     * @return registration year
     */
    public int getRegistrationYear() {
        return registrationYear;
    }

    /**
     * Sets the registration year
     * @param registrationYear cars registration year
     */
    public void setRegistrationYear(int registrationYear) {
        this.registrationYear = registrationYear;
    }
    
    /**
     * Cars Insurances constructor
     */
    public CarInsurance()
    {
        
    }

    /**
     * Returns the insurance type
     * @return car insurance
     */
    public String getType()
    {
        return Constants.CAR_INSURANCE;
    }

    /**
     * Returns the price per kilometer
     * @return price per kilometer in NOK
     */
    public double getPricePrKm() {
        return pricePrKm;
    }

    /**
     * Sets the price per kilometer
     * @param pricePrKm price per kilometer in NOK
     */
    public void setPricePrKm(double pricePrKm) {
        this.pricePrKm = pricePrKm;
    }

    /**
     * Returns the number of kilometer to be driven per year
     * @return kilometer to be driven per year
     */
    public int getKmPerYear() {
        return kmPerYear;
    }

    /**
     * Sets the number of kilometer to be driven per year
     * @param kmPerYear kilometer to be driven per year
     */
    public void setKmPerYear(int kmPerYear) {
        this.kmPerYear = kmPerYear;
    }
    
}
