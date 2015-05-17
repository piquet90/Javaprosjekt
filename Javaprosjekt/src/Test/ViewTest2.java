/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import CustomSwing.CustomPanel;
import javax.swing.JOptionPane;
import views.ReportView;


/**
 *
 * @author Audun
 */
public class ViewTest2 {
    

    public static void main(String[] args) {
        
        ReportView rv = new ReportView();
        rv.setReportNo(16);
        CustomPanel p = new CustomPanel();
        p.add(rv);
        
        JOptionPane.showMessageDialog(null, p);       
    }
}