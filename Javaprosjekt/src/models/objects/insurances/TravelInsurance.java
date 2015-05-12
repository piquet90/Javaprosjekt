/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;
import DAO.Constants;
import java.util.Calendar;

/**
 *
 * @author rudiwyu
 */
public class TravelInsurance extends Insurance{


    
    private String area;


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
    public String getType()
    {
        return Constants.TRAVEL_INSURANCE;
    }
}
