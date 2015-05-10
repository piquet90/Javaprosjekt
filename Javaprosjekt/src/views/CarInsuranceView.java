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
public class CarInsuranceView extends CustomPanel {
    
    private CustomTextField carOwner, type, regNr, model, horsepower, regYear, kmPerYear;
    private GridBagConstraints gbc;
    
    
    public CarInsuranceView()
    {
        this.setLayout(new GridBagLayout());
        
        
        carOwner = new CustomTextField(17);
        carOwner.setEditable(false);
        type = new CustomTextField(15);
        type.setEditable(false);
        regNr = new CustomTextField(9);
        regNr.setEditable(false);
        model = new CustomTextField(17);
        model.setEditable(false);
        horsepower = new CustomTextField(6);
        horsepower.setEditable(false);
        regYear = new CustomTextField(6);
        regYear.setEditable(false);
        kmPerYear = new CustomTextField(9);
        kmPerYear.setEditable(false);
        
 
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
        this.add(carOwner, gbc);
        
        gbc.gridy++;
        this.add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        this.add(type, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        this.add(model, gbc);
        
        gbc.gridy++;
        this.add(horsepower, gbc);
        
        gbc.gridy++;
        this.add(regYear, gbc);
        
        gbc.gridy++;
        this.add(kmPerYear, gbc);

        
    }
    
    

    public void setCarOwner(String co) {
        carOwner.setText(co);
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

    public void setHorsepower(String hp) {
        horsepower.setText(hp);
    }

    public void setRegYear(String y) {
        regYear.setText(y);
    }

    public void setKmPerYear(String km) {
        kmPerYear.setText(km);
    }
}
