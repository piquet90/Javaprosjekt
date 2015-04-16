/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class NyBrukerPanel extends JPanel {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private GridBagConstraints gbc;
    private CustomButton submit;
    
    private void initComponents()
    {
        fNavn = new CustomTextField(15);
        eNavn = new CustomTextField(15);
        adresse = new CustomTextField(20);
        postSted = new CustomTextField(15);
        postNr = new CustomTextField(6);
        
        submit = new CustomButton("Registrer");
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
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        
        gbc.gridx = 0;
        gbc.gridy = 1;
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
        gbc.gridy = 1;
        add(new CustomLabel("Registrer ny kunde"));
        

        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(fNavn, gbc);
        
        gbc.gridy++;
        add(eNavn, gbc);
        
        gbc.gridy++;
        add(adresse, gbc);
        
        gbc.gridy++;
        add(postNr, gbc);
        
        gbc.gridy++;
        add(postSted, gbc);
        
        gbc.gridy++;
        add(submit, gbc);

        
        
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