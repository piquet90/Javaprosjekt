/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import models.objects.insurances.Insurance;
import java.util.Calendar;

/**
 *
 * @author rudiwyu
 */
public class VehicleInsurance extends Insurance{
    
    private String viechleOwner;
    private String registrationNumber;
    private String type;
    private String model;
    private int power;
    
    
    public VehicleInsurance()
    {
        
    }

    /**
     * @return the viechleOwner
     */
    public String getViechleOwner() {
        return viechleOwner;
    }

    /**
     * @param viechleOwner the viechleOwner to set
     */
    public void setViechleOwner(String viechleOwner) {
        this.viechleOwner = viechleOwner;
    }

    /**
     * @return the registrationNumber
     */
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    /**
     * @param registrationNumber the registrationNumber to set
     */
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    /**
     * @return the type
     */
    public String getViechleType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setViechleType(String type) {
        this.type = type;
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * @return the power
     */
    public int getPower() {
        return power;
    }

    /**
     * @param power the power to set
     */
    public void setPower(int power) {
        this.power = power;
    }
    
}
