/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton2;
import CustomSwing.CustomLabel;
import CustomSwing.CustomTextField;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Audun
 */
public class CarInsuranceView extends InsuranceView {
    
    private CustomTextField bilEier, carType, regNr, modell, effekt, regAar, kmPerAar;
    private CustomButton2 endre;
    private GridBagConstraints gbc;
    
    private boolean check = false;
    
    public CarInsuranceView()
    {
        this.setLayout(new GridBagLayout());
        
        bilEier = new CustomTextField(17);
        bilEier.setEditable(false);
        carType = new CustomTextField(15);
        carType.setEditable(false);
        regNr = new CustomTextField(9);
        regNr.setEditable(false);
        modell = new CustomTextField(17);
        modell.setEditable(false);
        effekt = new CustomTextField(6);
        effekt.setEditable(false);
        regAar = new CustomTextField(6);
        regAar.setEditable(false);
        kmPerAar = new CustomTextField(9);
        kmPerAar.setEditable(false);
        
        endre = new CustomButton2("Endre");
 
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(new CustomLabel("Bileier: "), gbc);
        
        gbc.gridy++;
        this.add(new CustomLabel("Reg. nummer: "), gbc);
        
        gbc.gridy++;
        this.add(new CustomLabel("Biltype: "), gbc);
        
        gbc.gridy++;
        this.add(new CustomLabel("Modell: "), gbc);
        
        gbc.gridy++;
        this.add(new CustomLabel("Effekt (i hk): "), gbc);
        
        gbc.gridy++;
        this.add(new CustomLabel("Reg. år: "), gbc);
        
        gbc.gridy++;
        this.add(new CustomLabel("Km per år: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(bilEier, gbc);
        
        gbc.gridy++;
        this.add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        this.add(carType, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        this.add(modell, gbc);
        
        gbc.gridy++;
        this.add(effekt, gbc);
        
        gbc.gridy++;
        this.add(regAar, gbc);
        
        gbc.gridy++;
        this.add(kmPerAar, gbc);
       
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        this.add(endre, gbc);

        
    }
}
