/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomPanel;
import CustomSwing.CustomUserTable;
import controllers.Controller;
import controllers.ViewInsuranceController;
import javax.swing.JLabel;
import javax.swing.JTable;

/**
 *
 * @author rudiwyu
 */
public class ViewInsurancePanel extends CustomPanel implements View{
    
    private ViewInsuranceController controller;
    
    
    @Override
    public void initComponents() {
        
        CustomUserTable model = new CustomUserTable();
        JTable table = new JTable(model);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        add(table);
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
