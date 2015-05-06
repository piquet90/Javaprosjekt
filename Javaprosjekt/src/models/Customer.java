/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import models.objects.insurances.Insurance;
import java.util.HashSet;
import DAO.Constants;
import java.io.Serializable;
import java.util.Calendar;

/**
 *
 * @author rudiwyu
 */
public class Customer implements Serializable{

    // Static variables
    private static int next = Constants.CUSTOMER_NEXT_START_NUMBER;

    public static int getNext() {
        return next;
    }

    public static void setNext(int aNext) {
        next = aNext;
    }
    
    
    // Instance variables
    private Calendar registered;
    
    private String firstname;
    private String lastname;
    private String addressStreet;
    private String city;
    
    private int areacode;
    private int id;
    
    
    /**
     *
     * @param firstname
     * @param lastname
     * @param addressStreet
     * @param city
     * @param areacode
     */
    public Customer(String firstname, String lastname, String addressStreet, String city, int areacode) {
        
        this.registered =  Calendar.getInstance();
        this.firstname = firstname;
        this.lastname = lastname;
        this.addressStreet = addressStreet;
        this.city = city;
        this.areacode = areacode;
        this.id = next++;
    }
    

    /**
     * @return the registered
     */
    public Calendar getRegistered() {
        return registered;
    }

    /**
     * @param registered the registered to set
     */
    public void setRegistered(Calendar registered) {
        this.registered = registered;
    }

    /**
     * @return the name
     */
    public String getName() {
        return firstname+" "+lastname;
    }

    /**
     * @param name the name to set
     */
    public void setFirstName(String name) {
        this.firstname = name;
    }
    public void setLastName(String name) {
        this.lastname = name;
    }
    public String getFirstname()
    {
        return this.firstname;
    }
    public String getLastname()
    {
        return this.lastname;
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

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
    
    
}