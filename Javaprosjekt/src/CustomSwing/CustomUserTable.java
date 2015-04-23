/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rudiwyu
 */
public class CustomUserTable extends AbstractTableModel{
    
    private String[] kolonnenavn = 
    {
        "head1", "head2", "head3"
    };
    private Object[][] celler =
    {
        {
            "cell1,koll1", "cell2, kol1", "cell3, col1"
        },
            
        {
            "cell1,koll2", "cell2, kol2", "cell3, col2"
        },
        {
            "cell1,koll3", "cell2, kol3", "cell3, col3"
        },
        {
            "cell1,koll4", "cell2, kol4", "cell3, col4"
        },
        {
            "cell1,koll5", "cell2, kol5", "cell3, col5"
        }
    };
          
            
            
    @Override
    public int getRowCount() {
        return celler.length;
    }

    @Override
    public int getColumnCount() {
       return celler[ 0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return celler[ rowIndex][ columnIndex];
    }
     public String getColumnName(int kolonne)
    {
        return kolonnenavn[ kolonne];
    }
}
