/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;

import java.util.Date;

/**
 *
 * @author rudiwyu
 */
public class TravelInsurance extends Insurance{


    
    private String area;

    /**
     * Constructor for TravelInsurance
     * 
     * Also takes an Area String
     * 
     * 
     * @param area The area of which the insurance covers
     * @see Insurance
     */
    public TravelInsurance(String area, int price, double coverage, String conditions, String other, Date dateofcreation) {
        super(price, coverage, conditions, other, dateofcreation);
        this.area = area;
    }

    /**
     * Returns a String with the area the insurance covers
     * 
     * 
     * @return String with the area
     */
    public String getArea() {
        return area;
    }

    /**
     * Set the area which the insurance covers
     * 
     * 
     * @param area String containing the area
     */
    public void setArea(String area) {
        this.area = area;
    }
    
}
