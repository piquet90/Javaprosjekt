/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

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
    }
}
