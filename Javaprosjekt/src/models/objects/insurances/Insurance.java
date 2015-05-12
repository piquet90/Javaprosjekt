
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
    private int price;
    private double coverage;
    private String conditions;
    private String other;
    private Calendar dateofcreation;
    
    
    
    
    /**
     * Constructor for Insurance.
     * Creates an Insurance with the required fields
     * 
     * @author Rudi Yu
     * @param price Integer with value of yearly insurance cost
     * @param coverage Integer with value of coverage
     * @param conditions String with terms and conditions of insurance
     * @param other String containing "other"-info about the insurance
     * @param dateofcreation Date-object with info about when the insurance was created
     */
    public Insurance()
    {
        
    }
    
    public Insurance(int id, int price, double coverage, String conditions, String other, Calendar dateofcreation) {
        this.ownerid = id;
        this.price = price;
        this.coverage = coverage;
        this.conditions = conditions;
        this.other = other;
        this.dateofcreation = dateofcreation;
        
        this.id = next++;
        
    }
    
    //TODO: add comments to the equals and hashCode functions
    public boolean equals(Object o)
    {
        Insurance a = (Insurance)o;
        return((o instanceof Insurance) && a.getId()==this.getId());
    }
    public int hashCode()
    {
        return this.id;
    }
    


    /**
     * Returns yearly price of insurance
     * 
     * @author Rudi Yu
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Sets yearly price of insurance
     * 
     * @author Rudi Yu
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * 
     * @author Rudi Yu
     * @return the coverage
     */
    public double getCoverage() {
        return coverage;
    }

    /**
     * Sets how much the insurance covers.
     * 
     * @see "forsikringsbel�p"
     * @author Rudi Yu
     * @param coverage the coverage to set
     */
    public void setCoverage(double coverage) {
        this.coverage = coverage;
    }

    /**
     * Get the conditions String. Conditions contains the terms and conditions of the insurance.
     * 
     * @author Rudi Yu
     * @return the conditions
     */
    public String getConditions() {
        return conditions;
    }

    /**
     * Sets the conditons String. Should containt full insurance-conditions
     * 
     * @author Rudi Yu
     * @param conditions The conditions for the insurance
     */
    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    /**
     * Returns "other"-info string. This String should containt information that doesnt fit anywhere else
     * 
     * @author Rudi Yu
     * @return "other"-string
     */
    public String getOther() {
        return other;
    }

    /**
     * Sets other-string. 
     * 
     * @author Rudi Yu
     * @param other A string containing "other"-info
     */
    public void setOther(String other) {
        this.other = other;
    }

    /**
     * Returns a Date-object with date of creation
     * 
     * @author Rudi Yu
     * @return Date-object with date of creation
     */
    public Calendar getDateofcreation() {
        return dateofcreation;
    }

    /**
     * 
     * Sets a Date-object with the date of creation
     * 
     * @author Rudi Yu
     * @param dateofcreation Date object with date of creation
     */
    public void setDateofcreation(Calendar dateofcreation) {
        this.dateofcreation = dateofcreation;
    }

    /**
     * Returns the ID of an insurance
     * 
     * @return The id of the insurance
     */
    public int getId() {
        return id;
    }

    /**
     * sets the insurance ID
     * 
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    /**
     * Returns an int equal to the InsuranceNo counter.
     * 
     * @author Rudi Yu
     * @return The next number in the counter
     */
    public static int getNext() {
        return next;
    }

    /**
     * Sets the InsuranceNoCounter to nextId
     * 
     * @author Rudi Yu
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
     * @return the ownerid
     */
    public int getOwnerId() {
        return ownerid;
    }

    /**
     * @param ownerid the ownerid to set
     */
    public void setOwnerId(int ownerid) {
        this.ownerid = ownerid;
    }
    
    
    
}
