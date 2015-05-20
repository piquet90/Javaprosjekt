
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
    
    private int id;
    
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
    
    
}
