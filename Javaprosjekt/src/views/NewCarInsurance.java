/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import controllers.Controller;
import controllers.NewCustomerController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Audun
 */

public class NewCarInsurance extends CustomPanel implements View {
    
    private CustomTextField bilEier, regNr, biltype, effekt, regAar, kmPerAar, bilEierStatus;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private NewCustomerController controller;
    private int check = 0;
    
    /**
     * Initializes the GUI components (cleaner constructor)
     */
    public void initComponents() {
        
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        bilEier = new CustomTextField(15);
        bilEier.setEditable(false);
        bilEier.setText("Satt til valgt kunde");
        regNr = new CustomTextField(10);
        biltype = new CustomTextField(21);
        effekt = new CustomTextField(10);
        regAar = new CustomTextField(10);
        kmPerAar = new CustomTextField(10);
        
        bilEierStatus = new CustomTextField(10);
        
        endreEier = new CustomButton2("Endre");
        
        endreEier.addActionListener((e) -> test());
        
        submit = new CustomButton("Registrer");
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Bileier: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel(""), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. nummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Biltype/modell: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Effekt (i hk): "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. år: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Km per år: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(new CustomLabel("Opprette ny bilforsikring"));
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(bilEier, gbc);
        
        gbc.gridy++;
        add(new CustomLabel(""), gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(biltype, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(effekt, gbc);
        
        gbc.gridy++;
        add(regAar, gbc);
        
        gbc.gridy++;
        add(kmPerAar, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(endreEier, gbc);
        
        

    }
    /**
     * NyBilforsikring constructor
     */
    public NewCarInsurance() {
        
    }
    
    public void test() {
        
        if(check == 0) {
            bilEier.setEditable(true);
            check=1;
            
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(new CustomLabel("Tilknytning: "), gbc);

            gbc.gridx = 1;
            gbc.gridy = 2;
            add(bilEierStatus, gbc);
            repaint();
            revalidate();
        }
        else {
            bilEier.setEditable(false);
            bilEier.setText("Satt til valgt kunde");
            check=0;
            
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(new CustomLabel(""), gbc);
            
            gbc.gridx = 1;
            gbc.gridy = 2;
            add(new CustomLabel(""), gbc);
            repaint();
            revalidate();
        }
    }

    @Override
    public boolean addController(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
