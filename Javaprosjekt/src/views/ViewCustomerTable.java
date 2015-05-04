/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Font;
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
                    int id = (int)table.getValueAt(row, 0);
                    controller.ViewCustomer(id);
                }        
            }
        });
    }
    
    
    public ViewCustomerTable(AbstractTableModel table)
    {
        super(table);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setRowHeight(40);
    
    }
    
    public void addController(ViewCustomerController c)
    {
        controller = c;
    }
}
