
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
    private String description, type, date, witnessName1, witnessPhone1;
    

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

    public void setDate(String date) {
        this.date = date;
    }
    
    public String getDate()
    {
        return this.date;
    }

    public String getWitnessName1() {
        return witnessName1;
    }

    public void setWitnessName1(String witnessName1) {
        this.witnessName1 = witnessName1;
    }

    public String getWitnessPhone1() {
        return witnessPhone1;
    }

    public void setWitnessPhone1(String witnessPhone1) {
        this.witnessPhone1 = witnessPhone1;
    }
    
    
}
