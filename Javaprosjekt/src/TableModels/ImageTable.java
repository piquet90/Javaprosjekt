/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package TableModels;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Audun
 */
public class ImageTable extends AbstractTableModel{
    
    private Object[] kolonnenavn = 
    {
        "Bildenummer", "Bilde-URL"
    };
    private Object[][] celler = {
        {
            "##", "Ingen bilder lagt til"
        }
    };

    
    /**
     * ImagesTables constructor
     * @param images HashSet with image urls to be added to JTable
     */
    public ImageTable(HashSet<File> images)     
    {
        if(images.isEmpty())
        {
            
        }
        else {
            celler = new Object[images.size()][kolonnenavn.length];
            Iterator<File> iter = images.iterator();
            
            for(int i = 0; iter.hasNext(); i++)
            {
                File f = iter.next();
                celler[i][0] = i+1;
                celler[i][1] = f;
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
