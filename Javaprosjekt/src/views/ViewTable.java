/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import DAO.Constants;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rudiwyu
 */
public class ViewTable extends JTable{
    
    private CustomListener listener;
    
    
    public ViewTable(AbstractTableModel table)
    {
        super(table);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setRowHeight(40);
        
        this.addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent me) {
                if(listener == null)
                    System.out.println("No listener, please add a listener.");
                JTable table =(JTable) me.getSource();
                Point p = me.getPoint();
                int row = table.rowAtPoint(p);
                if (me.getClickCount() == 2) {
                    int id = (int)table.getValueAt(row, 0);
                    listener.customActionPerformed(new CustomEvent(Constants.DOUBLECLICK, id));
                    
                }        
            }
        });
    }
    
    

    public void addCustomListener(CustomListener l)
    {
        this.listener = l;
    }
}
