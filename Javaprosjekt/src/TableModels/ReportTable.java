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
import models.Report;

/**
 *
 * @author Audun
 */
public class ReportTable extends AbstractTableModel{
    
    private Object[] kolonnenavn = 
    {
        "SkademeldingNummer", "Type", "Opprettet"
    };
    private Object[][] celler = {
        {
            "##", "Ingen opprettet", "##"
        }
    };

    
    /**
     * ReportTables constructor
     * @param reports HashSet with reports to be added to JTable
     */
    public ReportTable(HashSet<Report> reports)     
    {
        
        if(reports.isEmpty())
        {
            
        }
        else {
            celler = new Object[reports.size()][kolonnenavn.length];
            Iterator<Report> iter = reports.iterator();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            for(int i = 0; iter.hasNext(); i++)
            {
                Report rep = iter.next();
                celler[i][0] = rep.getId(); //rep.getId();
                celler[i][1] = rep.getType(); //rep.getType();
                celler[i][2] = rep.getDate(); //format1.format(rep.getDateofcreation().getTime());S
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
        return (String)kolonnenavn[kolonne];
    }
    
    
}
