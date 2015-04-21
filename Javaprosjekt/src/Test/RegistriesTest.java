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

public class RegistriesTest {
    
    
    public static void main(String[]args)
    {
        JPanel panel = new JPanel();
        JFrame frame = new JFrame();
        
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.anchor = GridBagConstraints.WEST;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        JButton b1 = new JButton("BBBBBB1111111111111111111111");
        panel.add(b1, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 1;
        
        JButton b2 = new JButton("AAAAAAA");
        panel.add(b2, gbc);
        
        gbc.gridx = 3;
        
        JButton b3 = new JButton("CCCCCCC");
        panel.add(b3, gbc);
        gbc.gridy = 3;
        gbc.gridx = 0;
        
        JButton b11 = new JButton("BBBBBB");
        panel.add(b11, gbc);
        
        gbc.gridx = 1;
        
        JButton b12 = new JButton("AAAAAAA");
        panel.add(b12, gbc);
        
        gbc.gridx = 3;
        
        JButton b13 = new JButton("CCCCCCC");
        panel.add(b13, gbc);
        
        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton longs = new JButton("long penis");
        
        panel.add(longs, gbc);
        
        
  
        
                
        
        
        
        
        
        
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
    
}
