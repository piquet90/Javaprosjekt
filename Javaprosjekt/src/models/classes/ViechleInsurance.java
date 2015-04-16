/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes;

import java.util.Date;

/**
 *
 * @author rudiwyu
 */
public class ViechleInsurance extends Insurance{
    
    private String viechleOwner;
    private String registrationNumber;
    private String type;
    private String model;
    private int power;
    
    /**
     *
     * @param price the value of price
     * @param coverage the value of coverage
     * @param conditions the value of conditions
     * @param other the value of other
     * @param dateofcreation the value of dateofcreation
     */
    public ViechleInsurance(int price, int coverage, String conditions, String other, 
            Date dateofcreation, String viechleOwner, String registrationNumber, String type, String model, int power)
    {
        super(price, coverage, conditions, other, dateofcreation);
        this.viechleOwner = viechleOwner;
        this.registrationNumber = registrationNumber;
        this.type = type;
        this.model = model;
        this.power = power;
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
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
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
