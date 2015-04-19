/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomPanel;
import controllers.Controller;
import controllers.ViewInsuranceController;
import javax.swing.JLabel;

/**
 *
 * @author rudiwyu
 */
public class ViewInsurancePanel extends CustomPanel implements View{
    
    private ViewInsuranceController controller;
    
    
    @Override
    public void initComponents() {
        System.out.println("works");
        JLabel label = new JLabel("works");
        this.add(label);
    }
    
    @Override
    public boolean addController(Controller c) {
        if(c instanceof ViewInsuranceController)
        {
            this.controller = (ViewInsuranceController)c;
            return true;
        }
        return false;
    }


    
}
