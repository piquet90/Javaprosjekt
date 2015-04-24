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
        "Navn", "Adresse", "Poststed", "Postnummer", "Opprettet"
    };
    private Object[][] celler = {
        {
            "Tabellen er tom!", "##", "##", "##", "##"
        }
    };
    
    

    public CustomUserTable(HashSet<Customer> users)     
    {
        if(users.isEmpty())
        {
            
        }
        else {
            celler = new Object[users.size()][5];
            Iterator<Customer> iter = users.iterator();
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            for(int i = 0; iter.hasNext(); i++)
            {
                Customer user = iter.next();
                celler[i][0] = user.getName();
                celler[i][1] = user.getAddressStreet();
                celler[i][2] = user.getCity();
                celler[i][3] = user.getAreacode();
                celler[i][4] = format1.format(user.getRegistered().getTime());
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
