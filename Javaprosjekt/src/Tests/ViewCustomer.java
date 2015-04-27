/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Tests;

import CustomSwing.CustomUserTable;
import java.util.HashSet;
import javax.swing.*;
import views.ViewCustomerPanel;
/**
 *
 * @author Rudi
 */
public class ViewCustomer {
    
    public static void main(String[]args)
    {
        JFrame frame = new JFrame();
        
        CustomUserTable test = new CustomUserTable(new HashSet<>());
        JTable JTable = new JTable(test);
        JScrollPane table = new JScrollPane(JTable);
        JPanel panel = new JPanel();
        panel.add(table);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
        

        

        
    }
}
