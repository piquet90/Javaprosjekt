/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import controllers.ViewCustomerController;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerTable extends JTable{
    
    private ViewCustomerController controller;
    
    
    public void initComponents()
    {

        
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me) {
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    controller.ViewCustomer(row);
                }        
            }
        });
    }
    
    
    public ViewCustomerTable(AbstractTableModel table)
    {
        super(table);
    }
    
    public void addController(ViewCustomerController c)
    {
        controller = c;
    }
}
