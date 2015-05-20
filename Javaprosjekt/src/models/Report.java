
package models;

import DAO.Constants;
import java.io.Serializable;

/**
 * Report class (Skademelding)
 *
 * @author Rudi
 */
public class Report implements Serializable{
    
    private static int next = Constants.REPORT_NEXT_START_NUMBER; 
    
    private int id, insuranceId, ownerId;
    private double paid, estimated;
    private String description, type;

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getEstimated() {
        return estimated;
    }

    public void setEstimated(double estimated) {
        this.estimated = estimated;
    }
    
    public Report()
    {
        id = next++;
        
    }

    public static int getNext() {
        return next;
    }

    public static void setNext(int next) {
        Report.next = next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(int insuranceId) {
        this.insuranceId = insuranceId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
