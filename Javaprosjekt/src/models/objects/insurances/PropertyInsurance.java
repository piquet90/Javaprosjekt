/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import models.objects.insurances.Insurance;
import java.util.Calendar;

/**
 * Abstract Base insurance class for PropertyInsurances.
 * 
 * @author rudiwyu
 */
public abstract class PropertyInsurance extends Insurance {

    private String address;
    private String type;
    private String construtionmaterial;
    private String standard;
    private int squaremeter;
    private int yearofconstruction;
    private double buildingcoverage;
    private double contentscoverage;

    /**
     * Construct for a propertyinsurance.
     * 
     * Takes all the information required by a propertyinsurance.
     *
     * @param address The Address of the property that is covered by this insurance
     * @param type The main type of building that is insured
     * @param construtionmaterial The main construction material of the building
     * @param standard The standard of the building
     * @param squaremeter The size of the building in squaremeters
     * @param yearofconstruction The year of construction
     * @param buildingcoverage How much the insurance covers on incidents to the building
     * @param contentscoverage How much the insurance covers on incidents to the contents of the building
     * @param price the price of the insurance per year
     * @param conditions The terms and conditions of the insurance
     * @param other String containing "other"-info about the insurance
     * @param dateofcreation Date-object with info about when the insurance was created
     * 
     * @see Insurance
     */
    public PropertyInsurance(
            String address, 
            String type, 
            String construtionmaterial, 
            String standard, 
            int squaremeter, 
            int yearofconstruction, 
            double buildingcoverage, 
            double contentscoverage, 
            int price, 
            String conditions, 
            String other, 
            Calendar dateofcreation)
    {
        super(price, (buildingcoverage+buildingcoverage), conditions, other, dateofcreation);
        this.address = address;
        this.type = type;
        this.construtionmaterial = construtionmaterial;
        this.standard = standard;
        this.squaremeter = squaremeter;
        this.yearofconstruction = yearofconstruction;
        this.buildingcoverage = buildingcoverage;
        this.contentscoverage = contentscoverage;
    }
    
    
    @Override
    public double getCoverage()
    {
        return buildingcoverage + contentscoverage;
    }

    /**
     * Get the insured address
     * 
     * @author Rudi Yu
     * @return Address in String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the insured address.
     * 
     * @author Rudi Yu
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the type of property
     * 
     * @return PropertyType
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the property type
     * 
     * @param type Type of property
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Returns the main construction material for the property
     * 
     * @return Main material in a string
     */
    public String getConstrutionmaterial() {
        return construtionmaterial;
    }

    /**
     * @param construtionmaterial the construtionmaterial to set
     */
    public void setConstrutionmaterial(String construtionmaterial) {
        this.construtionmaterial = construtionmaterial;
    }

    /**
     * @return the standard
     */
    public String getStandard() {
        return standard;
    }

    /**
     * @param standard the standard to set
     */
    public void setStandard(String standard) {
        this.standard = standard;
    }

    /**
     * @return the squaremeter
     */
    public int getSquaremeter() {
        return squaremeter;
    }

    /**
     * @param squaremeter the squaremeter to set
     */
    public void setSquaremeter(int squaremeter) {
        this.squaremeter = squaremeter;
    }

    /**
     * @return the yearofconstruction
     */
    public int getYearofconstruction() {
        return yearofconstruction;
    }

    /**
     * @param yearofconstruction the yearofconstruction to set
     */
    public void setYearofconstruction(int yearofconstruction) {
        this.yearofconstruction = yearofconstruction;
    }

    /**
     * @return the buildingcoverage
     */
    public double getBuildingcoverage() {
        return buildingcoverage;
    }

    /**
     * @param buildingcoverage the buildingcoverage to set
     */
    public void setBuildingcoverage(double buildingcoverage) {
        this.buildingcoverage = buildingcoverage;
    }

    /**
     * @return the contentscoverage
     */
    public double getContentscoverage() {
        return contentscoverage;
    }

    /**
     * @param contentscoverage the contentscoverage to set
     */
    public void setContentscoverage(double contentscoverage) {
        this.contentscoverage = contentscoverage;
    }

}
