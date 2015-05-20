/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package TableModels;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;
import models.objects.insurances.Insurance;

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

    
    /**
     * InsuranceTables constructor
     * @param insurances HashSet with insurances to be added to JTable
     */
    public InsuranceTable(HashSet<Insurance> insurances)     
    {
        
        if(insurances.isEmpty())
        {
            
        }
        else {
            celler = new Object[insurances.size()][kolonnenavn.length];
            Iterator<Insurance> iter = insurances.iterator();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            for(int i = 0; iter.hasNext(); i++)
            {
                Insurance ins = iter.next();
                celler[i][0] = ins.getId();
                celler[i][1] = ins.getType();
                celler[i][2] = format1.format(ins.getDateofcreation().getTime());
                celler[i][3] = (ins.getEndDate()==null)?"Aktiv":format1.format(ins.getEndDate().getTime());
            }
        }
        
        
        
    }
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
