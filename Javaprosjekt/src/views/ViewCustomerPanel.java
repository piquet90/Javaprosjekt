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
import java.awt.Point;
import java.awt.event.*;

import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerPanel extends JTable implements View{
    
    private ViewCustomerController controller;
    
    public void setTable(CustomUserTable table)
    {
        JTable jt = new JTable(table);
        
        this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        add(new JScrollPane(jt));
        
        
        
        jt.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me)
            {
                Point p = me.getPoint();
                int row = jt.rowAtPoint(p);
                if(me.getClickCount()==2)
                {
                    controller.ViewCustomer((int)table.getValueAt(row, 0));
                }
            }
        });
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
