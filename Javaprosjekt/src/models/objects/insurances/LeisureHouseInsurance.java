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



    public String getType()
    {
        return Constants.LEISUREHOUSE_INSURANCE;
    }

    
}
