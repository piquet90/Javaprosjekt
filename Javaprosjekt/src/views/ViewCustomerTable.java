/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rudiwyu
 */
public class ViewCustomerTable extends JTable{
    
    public ViewCustomerTable(AbstractTableModel table)
    {
        super(table);
        this.setFont(new Font("Arial", Font.BOLD, 16));
        this.setRowHeight(40);
    
    }
}
