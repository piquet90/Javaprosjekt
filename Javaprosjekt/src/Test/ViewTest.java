/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import views.AdvancedSearchPanel;
import views.BoatInsuranceView;
import views.CarInsuranceView;
import views.HouseInsuranceView;
import views.LeisurehouseInsuranceView;
import views.MainView;
import views.SimpleSearchPanel;
import views.TravelInsuranceView;
import views.registrations.NewCarInsurance;


/**
 *
 * @author Audun
 */
public class ViewTest {
    

    public static void main(String[] args) {
        
        //JOptionPane.showMessageDialog(null, new InsuranceView());
        //JOptionPane.showMessageDialog(null, new TravelInsuranceView());
        //JOptionPane.showMessageDialog(null, new AdvancedSearchPanel());
        
        NewCarInsurance c = new NewCarInsurance();
        c.setViewMode();
        c.setCarType("aaa");
        
        JOptionPane.showMessageDialog(null, c);
        
        

        
        //AdvancedSearchPanel asp = new AdvancedSearchPanel();
        
        /*JOptionPane pane = new JOptionPane(asp, JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{}, null);
        JDialog dialog = pane.createDialog(null, "tittel");
        dialog.setContentPane(pane);
        dialog.setDefaultCloseOperation(dialog.DISPOSE_ON_CLOSE);
        dialog.setModal(false); // this says not to block background components
        dialog.setVisible(true);*/
        
      
        
        
                
    }


}