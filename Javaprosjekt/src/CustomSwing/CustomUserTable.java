/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.table.AbstractTableModel;
import models.objects.Customer;

/**
 *
 * @author rudiwyu
 */
public class CustomUserTable extends AbstractTableModel{
    
    private Object[] kolonnenavn = 
    {
        "Kundenr","Navn", "Adresse", "Poststed", "Postnummer", "Opprettet"
    };
    private Object[][] celler = {
        {
            "Tabellen er tom!", "##", "##", "##", "##", "##"
        }
    };
    
    

    public CustomUserTable(HashSet<Customer> users)     
    {
        if(users.isEmpty())
        {
            
        }
        else {
            celler = new Object[users.size()][kolonnenavn.length];
            Iterator<Customer> iter = users.iterator();
            SimpleDateFormat format1 = new SimpleDateFormat("dd.MM.yyyy");
            for(int i = 0; iter.hasNext(); i++)
            {
                Customer user = iter.next();
                celler[i][0] = user.getId();
                celler[i][1] = user.getName();
                celler[i][2] = user.getAddressStreet();
                celler[i][3] = user.getCity();
                celler[i][4] = user.getAreacode();
                celler[i][5] = format1.format(user.getRegistered().getTime());
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
