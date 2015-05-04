/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package TableModels;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author rudiwyu
 */
public class InsuranceTable extends AbstractTableModel{
    
    private Object[] kolonnenavn = 
    {
        "ForsikringsNummer","Type", "Gyldig siden", "Avsluttet"
    };
    private Object[][] celler = {
        {
            "Ingen forsikringer registrert", "##", "##", "##"
        }
    };

    @Override
    public int getRowCount() {
        return celler.length;
    }

    @Override
    public int getColumnCount() {
       return celler[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return celler[ rowIndex][ columnIndex];
    }
    
    @Override
    public Class getColumnClass(int kolonne)
    {
        return celler[0][kolonne].getClass();
    }
    
    
    @Override
    public String getColumnName(int kolonne)
    {
        return (String)kolonnenavn[ kolonne];
    }
}
