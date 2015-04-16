
package models.classes;

import java.util.Date;

/**
 *
 * @author rudiwyu
 */
public abstract class Insurance {
    
    
    
    
    private int price;
    private int coverage;
    private String conditions;
    private String other;
    private Date dateofcreation;
    
    
    
    
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
    public Insurance(int price, int coverage, String conditions, String other, Date dateofcreation) {
        this.price = price;
        this.coverage = coverage;
        this.conditions = conditions;
        this.other = other;
        this.dateofcreation = dateofcreation;
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
    public int getCoverage() {
        return coverage;
    }

    /**
     * Sets how much the insurance covers.
     * 
     * @see "forsikringsbeløp"
     * @author Rudi Yu
     * @param coverage the coverage to set
     */
    public void setCoverage(int coverage) {
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
    public Date getDateofcreation() {
        return dateofcreation;
    }

    /**
     * 
     * Sets a Date-object with the date of creation
     * 
     * @author Rudi Yu
     * @param dateofcreation Date object with date of creation
     */
    public void setDateofcreation(Date dateofcreation) {
        this.dateofcreation = dateofcreation;
    }
    
    
    
    
    
    
}
