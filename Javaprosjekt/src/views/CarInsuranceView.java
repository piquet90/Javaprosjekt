/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton2;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Audun
 */
public class CarInsuranceView extends CustomPanel {
    
    private CustomTextField bilEier, type, regNr, modell, effekt, regAar, kmPerAar;
    private CustomButton2 endre;
    private GridBagConstraints gbc;
    
    private boolean check = false;
    
    public CarInsuranceView()
    {
        this.setLayout(new GridBagLayout());
        
        
        bilEier = new CustomTextField(17);
        bilEier.setEditable(false);
        type = new CustomTextField(15);
        type.setEditable(false);
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
        
        gbc.gridx = 0;
        gbc.gridy = 0;
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
        gbc.gridy = 0;
        this.add(bilEier, gbc);
        
        gbc.gridy++;
        this.add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        this.add(type, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        this.add(modell, gbc);
        
        gbc.gridy++;
        this.add(effekt, gbc);
        
        gbc.gridy++;
        this.add(regAar, gbc);
        
        gbc.gridy++;
        this.add(kmPerAar, gbc);

        
    }
    
    

    public void setBilEier(String e) {
        bilEier.setText(e);
    }

    public void setCarType(String t) {
        type.setText(t);
    }

    public void setRegNr(String rnr) {
        regNr.setText(rnr);
    }

    public void setModell(String mo) {
        modell.setText(mo);
    }

    public void setEffekt(String ef) {
        effekt.setText(ef);
    }

    public void setRegAar(String aar) {
        regAar.setText(aar);
    }

    public void setKmPerAar(String km) {
        kmPerAar.setText(km);
    }
}
