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
    
    
    @Override
    public double getCoverage()
    {
        return buildingcoverage + contentscoverage;
    }

    /**
     * Returns the insured address
     * @return Address in String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets the insured address
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Returns the type of property
     * @return PropertyType
     */
    public String getBuildingType() {
        return type;
    }

    /**
     * Sets the property type
     * @param type Type of property
     */
    public void setBuildingType(String type) {
        this.type = type;
    }

    /**
     * Returns the main construction material for the property
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
     * Returns the property standard
     * @return property standard
     */
    public String getStandard() {
        return standard;
    }

    /**
     * Sets the property standard
     * @param standard the standard to set
     */
    public void setStandard(String standard) {
        this.standard = standard;
    }

    /**
     * Returns the property size
     * @return size in squaremeter
     */
    public int getSquaremeter() {
        return squaremeter;
    }

    /**
     * Sets the property size
     * @param squaremeter property size
     */
    public void setSquaremeter(int squaremeter) {
        this.squaremeter = squaremeter;
    }

    /**
     * Returns the properties year of construction
     * @return the year of construction
     */
    public int getYearofconstruction() {
        return yearofconstruction;
    }

    /**
     * Sets the year of construction
     * @param yearofconstruction the yearofconstruction to set
     */
    public void setYearofconstruction(int yearofconstruction) {
        this.yearofconstruction = yearofconstruction;
    }

    /**
     * Returns the buildings coverage amount
     * @return the buildingcoverage
     */
    public double getBuildingcoverage() {
        return buildingcoverage;
    }

    /**
     * Sets the building coverage amount
     * @param buildingcoverage the buildingcoverage to set
     */
    public void setBuildingcoverage(double buildingcoverage) {
        this.buildingcoverage = buildingcoverage;
    }

    /**
     * Returns the contents coverage amount
     * @return the contentscoverage
     */
    public double getContentscoverage() {
        return contentscoverage;
    }

    /**
     * Sets the contents coverage amount
     * @param contentscoverage the contentscoverage to set
     */
    public void setContentscoverage(double contentscoverage) {
        this.contentscoverage = contentscoverage;
    }

}
