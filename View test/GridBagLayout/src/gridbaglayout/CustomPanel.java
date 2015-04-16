/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbaglayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 *
 * @author Audun
 */
public class CustomPanel extends JPanel {
    
    private JTextField fNavn, eNavn, adresse, postSted, postNr;
    private JButton submit;
    private JLabel header;
    private GridBagConstraints gbc;
    
    private void initComponents()
    {
        fNavn = new JTextField(10);
        eNavn = new JTextField(10);
        adresse = new JTextField(15);
        postSted = new JTextField(15);
        postNr = new JTextField(5);
        
        submit = new JButton("Submit");
        submit.addActionListener((e) -> System.out.println("trykk"));
        
        header = new JLabel("Registrer ny kunde");
        header.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
    }
    
    public CustomPanel()
    {
        this.setLayout(new GridBagLayout());
        this.setSize(getPreferredSize());
        initComponents();
        
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        
        //// Første rad /////////////////////
        
        gbc.gridx = 0;
        gbc.gridy = -1;
 
        gbc.insets = new Insets(15, 2, 0, 5);
        add(new JLabel("Fornavn:"), gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(15, 0, 0, 50);
        add(fNavn, gbc);
        
        gbc.gridx = 2;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Etternavn:"), gbc);
        
        gbc.gridx = 3;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(eNavn, gbc);
        
        //// Andre rad /////////////////////
        
        gbc.gridx = 0;
        gbc.gridy = -2;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Adresse:"), gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(15, 0, 0, 30);
        add(adresse, gbc);
        
        gbc.gridx = 2;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Postnr:"), gbc);
        
        gbc.gridx = 3;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(postNr, gbc);
        
        //// Tredje rad /////////////////////

        gbc.gridx = 0;
        gbc.gridy = -3;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Poststed:"), gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(postSted, gbc);
        
        //// Fjerde rad /////////////////////

        gbc.gridx = 0;
        gbc.gridy = -4;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(submit, gbc);

    }
    
    public Dimension getMinimumSize()
    {
        return super.getPreferredSize();
    }
}