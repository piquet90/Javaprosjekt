/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import javax.swing.JOptionPane;
import views.BoatInsuranceView;
import views.CarInsuranceView;
import views.InsuranceView;
import views.SimpleSearchView;


/**
 *
 * @author Audun
 */
public class ViewTest {
    

    public static void main(String[] args) {
        
        //JOptionPane.showMessageDialog(null, new SimpleSearchView());
        JOptionPane.showMessageDialog(null, new InsuranceView());
        JOptionPane.showMessageDialog(null, new BoatInsuranceView());
        
      
        
        
                
    }


}