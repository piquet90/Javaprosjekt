/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbaglayout;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Audun
 */
public class GridBagLayoutView extends JFrame{
    
    private CustomPanel p1;

    public void initComponents()
    {
        p1 = new CustomPanel();
        //p1.setPreferredSize(new Dimension(200,200));
        //p1.setBackground(Color.GRAY);
        
    }
    
    public GridBagLayoutView()
    {
        super("title");
        initComponents();
        this.setLayout(new GridLayout());

        this.setPreferredSize(new Dimension(960, 540));

        this.setSize(getPreferredSize());
        
        this.setVisible(true);
        
        //this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        Container c = getContentPane();
        
        
        c.add(p1);
        
                 
        
    }
    
}