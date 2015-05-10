/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import controllers.CustomerController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

/**
 *
 * @author Audun
 */
public class HouseInsuranceView extends CustomPanel {
    /*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
    
    private CustomTextField adress, yearBuilt, type, material, standard, houseSize, amountBuilding, amountContents;
    private GridBagConstraints gbc;
    private CustomerController controller;
    
    
    public HouseInsuranceView() {
        setLayout(new GridBagLayout());
        
        adress = new CustomTextField(17);
        adress.setEditable(false);
        yearBuilt = new CustomTextField(5);
        yearBuilt.setEditable(false);
        type = new CustomTextField(15);
        type.setEditable(false);
        material = new CustomTextField(10);
        material.setEditable(false);
        standard = new CustomTextField(10);
        standard.setEditable(false);
        houseSize = new CustomTextField(5);
        houseSize.setEditable(false);
        amountBuilding = new CustomTextField(5);
        amountBuilding.setEditable(false);
        amountContents = new CustomTextField(5);
        amountContents.setEditable(false);

        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Byggeår: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Hustype: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Materiale: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Standard: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Størrelse: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Beløp, bygg: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Beløp, innbo: "), gbc);
        

        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(adress, gbc);
        
        gbc.gridy++;
        add(yearBuilt, gbc);
        
        gbc.gridy++;
        add(type, gbc);
        
        gbc.gridy++;
        add(material, gbc);
        
        gbc.gridy++;
        add(standard, gbc);
        
        gbc.gridy++;
        add(houseSize, gbc);
        
        gbc.gridy++;
        add(amountBuilding, gbc);
        
        gbc.gridy++;
        add(amountContents, gbc);
        

    }

    public void setAdress(String a) {
        adress.setText(a);
    }

    public void setYearBuilt(String y) {
        yearBuilt.setText(y);
    }

    public void setType(String t) {
        type.setText(t);
    }

    public void setMaterial(String m) {
        material.setText(m);
    }

    public void setStandard(String s) {
        standard.setText(s);
    }

    public void setHouseSize(String hs) {
        houseSize.setText(hs);
    }

    public void setAmountBuilding(String ab) {
        amountBuilding.setText(ab);
    }

    public void setAmountContents(String ac) {
        amountContents.setText(ac);
    }
    
    
    
}


