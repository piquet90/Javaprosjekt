/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import models.objects.insurances.ViechleInsurance;
import java.util.Date;

/**
 *
 * @author rudiwyu
 */
public class CarInsurance extends ViechleInsurance{

    public CarInsurance(int price, int coverage, String conditions, String other, Date dateofcreation, String viechleOwner, String registrationNumber, String type, String model, int power) {
        super(price, coverage, conditions, other, dateofcreation, viechleOwner, registrationNumber, type, model, power);
    }


    
}
