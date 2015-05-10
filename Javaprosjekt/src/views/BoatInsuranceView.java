/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

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
public class BoatInsuranceView extends CustomPanel{
    
    private CustomTextField baatEier, type, regNr, modell, lengde, regAar, motorType, effekt;
    private GridBagConstraints gbc;
    
    
    public BoatInsuranceView() {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        baatEier = new CustomTextField(17);
        baatEier.setEditable(false);
        type = new CustomTextField(15);
        type.setEditable(false);
        regNr = new CustomTextField(9);
        regNr.setEditable(false);
        modell = new CustomTextField(17);
        modell.setEditable(false);
        regAar = new CustomTextField(6);
        regAar.setEditable(false);
        motorType = new CustomTextField(10);
        motorType.setEditable(false);
        effekt = new CustomTextField(6);
        effekt.setEditable(false);
        lengde = new CustomTextField(6);
        lengde.setEditable(false);
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Båteier: "), gbc);
        
        
        gbc.gridy++;
        add(new CustomLabel("Reg. nummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Båttype: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Modell: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. år: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Motortype: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Effekt (i hk): "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Lengde (i fot): "), gbc);
        
        
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(baatEier, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        add(type, gbc);
        
        gbc.gridy++;
        add(modell, gbc);
        
        gbc.gridy++;
        add(regAar, gbc);
        
        gbc.gridy++;
        add(motorType, gbc);
        
        gbc.gridy++;
        add(effekt, gbc);
        
        gbc.gridy++;
        add(lengde, gbc);

    }

    public void setBaatEier(String be) {
        baatEier.setText(be);
    }

    public void setType(String t) {
        type.setText(t);
    }

    public void setRegNr(String rn) {
        regNr.setText(rn);
    }

    public void setModell(String m) {
        modell.setText(m);
    }

    public void setLengde(String l) {
        lengde.setText(l);
    }

    public void setRegAar(String aar) {
        regAar.setText(aar);
    }

    public void setMotorType(String mt) {
        motorType.setText(mt);
    }

    public void setEffekt(String e) {
        effekt.setText(e);
    }
}
