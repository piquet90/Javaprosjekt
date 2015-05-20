
package models.objects.insurances;

import DAO.Constants;
import java.io.Serializable;
import java.util.Calendar;

/**
 * Base Insurance Class
 * 
 * Base abstract insurance class. All other insurances must extend this class.
 *
 * @author rudiwyu
 */
public abstract class Insurance implements Serializable{
    
    // Static variables
    private static int next = Constants.INSURANCE_NEXT_START_NUMBER;


    
    
    
    // Instance variables
    private int id;
    private int ownerid;
    private double coverage, price;
    private String conditions;
    private String other;
    private Calendar dateofcreation, endDate;

    public Calendar getEndDate() {
        return endDate;
    }
    
    /**
     * Constructor for Insurance.
     * Creates an Insurance
     * 
     * @author Rudi Yu
     */
    public Insurance()
    {
        id = next++;
        dateofcreation = Calendar.getInstance();
        endDate=null;
        
    }
    


    /**
     * Returns yearly premium of insurance
     * @return premium in NOK
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets yearly premium of insurance
     * @param yearly premium in NOK
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Returns the coverage
     * @return coverage in NOK
     */
    public double getCoverage() {
        return coverage;
    }

    /**
     * Sets how much the insurance covers.
     * @see "forsikringsbeløp"
     * @param coverage the coverage to set
     */
    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    /**
     * Get the conditions String. Conditions contains the terms and conditions of the insurance.
     * @return the conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * Sets the conditons String. Should containt full insurance-conditions
     * @param conditions The conditions for the insurance
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * Returns "other"-info string
     * @return "other"-string
     */
    public String getOther() {
        return other;
    }

    /**
     * Sets other-string. 
     * @param other A string containing "other"-info
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * Returns a Date-object with date of creatio
     * @return Date-object with date of creation
     */
    public Calendar getDateofcreation() {
        return dateofcreation;
    }

    /**
     * Sets a Date-object with the date of creation
     * @param dateofcreation Date object with date of creation
     */
    public void setDateofcreation(Calendar dateofcreation) {
        this.dateofcreation = dateofcreation;
    }

    /**
     * Returns the ID of an insurance
     * @return insurance id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the insurance ID
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * Returns an int equal to the InsuranceNo counter.
     * @return The next number in the counter
     */
    public static int getNext() {
        return next;
    }

    /**
     * Sets the InsuranceNoCounter to nextId
     * @param nextId Sets next ID for insurances
     */
    public static void setNext(int nextId) {
        next = nextId;
    }
    
    public String getType()
    {
        return "";
    }

    /**
     * Returns the insurance owners id
     * @return the ownerid
     */
    public int getOwnerId() {
        return ownerid;
    }

    /**
     * Sets the insurance owners id
     * @param ownerid the ownerid to be set
     */
    public void setOwnerId(int ownerid) {
        this.ownerid = ownerid;
    }
    
    /**
     * Deletes an insurance
     */
    public void delete()
    {
        if(this.endDate==null)
            this.endDate = Calendar.getInstance();
    }
    
    
}
