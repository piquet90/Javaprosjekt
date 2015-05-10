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
    
    private CustomTextField boatOwner, type, regNr, model, length, regYear, engineType, horsepower;
    private GridBagConstraints gbc;
    
    
    public BoatInsuranceView() {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        boatOwner = new CustomTextField(17);
        boatOwner.setEditable(false);
        type = new CustomTextField(15);
        type.setEditable(false);
        regNr = new CustomTextField(9);
        regNr.setEditable(false);
        model = new CustomTextField(17);
        model.setEditable(false);
        regYear = new CustomTextField(6);
        regYear.setEditable(false);
        engineType = new CustomTextField(10);
        engineType.setEditable(false);
        horsepower = new CustomTextField(6);
        horsepower.setEditable(false);
        length = new CustomTextField(6);
        length.setEditable(false);
        
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
        add(boatOwner, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        add(type, gbc);
        
        gbc.gridy++;
        add(model, gbc);
        
        gbc.gridy++;
        add(regYear, gbc);
        
        gbc.gridy++;
        add(engineType, gbc);
        
        gbc.gridy++;
        add(horsepower, gbc);
        
        gbc.gridy++;
        add(length, gbc);

    }

    public void setBoatOwner(String bo) {
        boatOwner.setText(bo);
    }

    public void setType(String t) {
        type.setText(t);
    }

    public void setRegNr(String rn) {
        regNr.setText(rn);
    }

    public void setModel(String m) {
        model.setText(m);
    }

    public void setLength(String l) {
        length.setText(l);
    }

    public void setRegYear(String y) {
        regYear.setText(y);
    }

    public void setEngineType(String et) {
        engineType.setText(et);
    }

    public void setHorsePower(String hp) {
        horsepower.setText(hp);
    }
}
