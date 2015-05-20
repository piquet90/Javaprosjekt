/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects.insurances;
import DAO.Constants;
import java.util.Calendar;

/**
 * LeisureHouseInsuranceClass.
 *
 * @author rudiwyu
 */
public class LeisureHouseInsurance extends PropertyInsurance{


    private boolean isForRent;
    
    /**
     * Returns the insurance type
     * @return leisure house
     */
    public String getType()
    {
        return Constants.LEISUREHOUSE_INSURANCE;
    }
    
    /**
     * Sets the isForRent checkbox
     * @param status true for is for rent, false if not
     */
    public void setIsForRent(boolean status)
    {
        this.isForRent = status;
    }
    
    /**
     * Returns the status of the isForRent checkbox
     * @return status true for is for rent, false if not
     */
    public boolean getIsForRent()
    {
        return isForRent;
    }

    
}
