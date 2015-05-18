/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import CustomSwing.CustomPanel;
import javax.swing.JOptionPane;
import views.StatisticsView;


/**
 *
 * @author Audun
 */
public class ViewTest2 {
    

    public static void main(String[] args) {
        
        
        StatisticsView s = new StatisticsView();
        s.setInsurances(15, 3, 38, 3237, 18);
        CustomPanel p = new CustomPanel();
        p.add(s);
        
        JOptionPane.showMessageDialog(null, p);       
    }
}