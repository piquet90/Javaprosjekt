/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.objects;

import models.objects.insurances.Insurance;
import java.util.Date;
import java.util.HashSet;
import DAO.Constants;

/**
 *
 * @author rudiwyu
 */
public class Customer {

    // Static variables
    private int next = Constants.CUSTOMER_NEXT_START_NUMBER;
    
    
    // Instance variables
    private Date registered;
    
    private String name;
    private String addressStreet;
    private String addressLetter;
    private String city;
    
    private int addressNumber;
    private int areacode;
    
    private HashSet<Insurance> insurances;
    
    /**
     *
     * @param registered
     * @param name
     * @param addressStreet
     * @param addressLetter
     * @param city
     * @param addressNumber
     * @param areacode
     */
    public Customer(Date registered, String name, String addressStreet, String addressLetter, String city, int addressNumber, int areacode) {
        this.registered = registered;
        this.name = name;
        this.addressStreet = addressStreet;
        this.addressLetter = addressLetter;
        this.city = city;
        this.addressNumber = addressNumber;
        this.areacode = areacode;
    }
    

    /**
     * @return the registered
     */
    public Date getRegistered() {
        return registered;
    }

    /**
     * @param registered the registered to set
     */
    public void setRegistered(Date registered) {
        this.registered = registered;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the addressStreet
     */
    public String getAddressStreet() {
        return addressStreet;
    }

    /**
     * @param addressStreet the addressStreet to set
     */
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }

    /**
     * @return the addressLetter
     */
    public String getAddressLetter() {
        return addressLetter;
    }

    /**
     * @param addressLetter the addressLetter to set
     */
    public void setAddressLetter(String addressLetter) {
        this.addressLetter = addressLetter;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the addressNumber
     */
    public int getAddressNumber() {
        return addressNumber;
    }

    /**
     * @param addressNumber the addressNumber to set
     */
    public void setAddressNumber(int addressNumber) {
        this.addressNumber = addressNumber;
    }

    /**
     * @return the areacode
     */
    public int getAreacode() {
        return areacode;
    }

    /**
     * @param areacode the areacode to set
     */
    public void setAreacode(int areacode) {
        this.areacode = areacode;
    }
    
    
}
