/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class NyBrukerPanel extends JPanel {
    
    private CustomTextField fNavn;
    private JTextField eNavn, adresse, postSted, postNr;
    private JButton submit;
    private JLabel header, header2;
    private GridBagConstraints gbc;
    
    private void initComponents()
    {
        fNavn = new CustomTextField(10);
        eNavn = new CustomTextField(10);
        adresse = new CustomTextField(15);
        postSted = new CustomTextField(15);
        postNr = new CustomTextField(5);
        
        submit = new JButton("Submit");
        submit.addActionListener((e) -> System.out.println("trykk"));
        
        //header = new JLabel("Registrer ");
        //header.setFont(new Font("DejaVu Sans", Font.BOLD, 12));
    }
    
    public NyBrukerPanel()
    {
        this.setLayout(new GridBagLayout());
        this.setSize(getPreferredSize());
        initComponents();
        
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new CustomLabel("Fornavn: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Etternavn: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Postnummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Poststed: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(fNavn, gbc);
        
        gbc.gridy++;
        add(eNavn, gbc);
        
        gbc.gridy++;
        add(adresse, gbc);
        
        gbc.gridy++;
        add(postNr, gbc);
        
        gbc.gridy++;
        add(postSted, gbc);

        
        
       /*
        
    
        
        gbc.gridx = 0;
        gbc.gridy = -1;
 
        gbc.insets = new Insets(15, 0, 0, 5);
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
               */
    }
    
    public Dimension getMinimumSize()
    {
        return super.getPreferredSize();
    }
}