/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import models.objects.insurances.Insurance;

/**
 *
 * @author rudiwyu
 */
public class VehicleInsurance extends Insurance{
    
    private String vehicleOwner;
    private String registrationNumber;
    private String type;
    private String model;
    private int power;
    
    /**
     * VehicleInsurances constructor
     */
    public VehicleInsurance()
    {
        
    }

    /**
     * Returns the vehicle owner
     * @return vehicle owners name
     */
    public String getVehicleOwner() {
        return vehicleOwner;
    }

    /**
     * Sets the
     * @param vehicleOwner the vehicleOwner to set
     */
    public void setVehicleOwner(String vehicleOwner) {
        this.vehicleOwner = vehicleOwner;
    }

    /**
     * Returns the vehicles registration number
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * Sets the registration number
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * Returns the vehicle type
     * @return the type
     */
    public String getVehicleType() {
        return type;
    }

    /**
     * Sets the vehicle type
     * @param type the type to set
     */
    public void setVehicleType(String type) {
        this.type = type;
    }

    /**
     * Returns the vehicles moel
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the vehicles model
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Returns the vehicle power
     * @return vehicles power in horsepower
     */
    public int getPower() {
        return power;
    }

    /**
     * Sets the vehicle power
     * @param power vehicle power in horsepower
     */
    public void setPower(int power) {
        this.power = power;
    }
    
}
