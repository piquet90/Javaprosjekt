/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;


import CustomSwing.CustomButton;
import CustomSwing.CustomTextField;
import CustomSwing.CustomLabel;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class NyBrukerPanel extends JPanel {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private GridBagConstraints gbc;
    private CustomButton submit;
    
    /**
     * Initializes the GUI components (cleaner constructor)
     */
    private void initComponents()
    {
        fNavn = new CustomTextField(15);
        eNavn = new CustomTextField(15);
        adresse = new CustomTextField(20);
        postSted = new CustomTextField(15);
        postNr = new CustomTextField(6);
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> System.out.println("trykk"));
    }
    /**
     * NyBrukerPanel constructor
     */
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
    }
}