/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomCheckBox;
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

public class NewLeisureHouseInsurance extends CustomPanel {
    
    private CustomTextField adress, yearBuilt, type, material, standard, houseSize, amountBuilding, amountContents;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomCheckBox lease;
    private CustomerController controller;
    
    public void initComponents() {
        
        setLayout(new GridBagLayout());
        
        adress = new CustomTextField(15);
        yearBuilt = new CustomTextField(5);
        type = new CustomTextField(15);
        material = new CustomTextField(10);
        standard = new CustomTextField(10);
        houseSize = new CustomTextField(4);
        amountBuilding = new CustomTextField(6);
        amountContents = new CustomTextField(6);
        
        lease = new CustomCheckBox("");
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> System.out.println("s"));
        
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
        
        gbc.gridy++;
        add(new CustomLabel("Utleie: "), gbc);
        

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
        
        gbc.gridy++;
        add(lease, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
    }

    public String getAdress() {
        return adress.getText();
    }

    public String getYearBuilt() {
        return yearBuilt.getText();
    }

    public String getType() {
        return type.getText();
    }

    public String getMaterial() {
        return material.getText();
    }

    public String getStandard() {
        return standard.getText();
    }

    public String getHouseSize() {
        return houseSize.getText();
    }

    public String getAmountContents() {
        return amountContents.getText();
    }

    public boolean getLease() {
        return lease.isSelected();
    }
    
    
    public NewLeisureHouseInsurance() {
        
    }
 
}
