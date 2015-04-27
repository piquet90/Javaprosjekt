/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

/**
 *
 * @author rudiwyu
 */

import java.util.Date;
import DAO.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.HashSet;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import models.objects.insurances.*;
import models.*;
import views.CustomerView;

public class RegistriesTest {
    
    
    public static void main(String[]args)
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        
        CustomerView view = new CustomerView("asd","123","asd","123","asd");
        
        panel.add(view);
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
    
}
