/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomPanel;
import CustomSwing.CustomUserTable;
import controllers.Controller;
import controllers.ViewCustomerController;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerPanel extends CustomPanel implements View{
    
    private ViewCustomerController controller;
    
    public void setTable(CustomUserTable table)
    {
        this.removeAll();
        JTable jt = new JTable(table);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS);
        add(new JScrollPane(jt));
    }
    
    
    
    @Override
    public void initComponents() {
        
    }
    
    @Override
    public boolean addController(Controller c) {
        if(c instanceof ViewCustomerController)
        {
            this.controller = (ViewCustomerController)c;
            return true;
        }
        return false;
    }


    
}
