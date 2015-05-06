/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
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

public class NewHouseInsurance extends CustomPanel {
    
    private CustomTextField adress, yearBuilt, type, material, standard, houseSize, amountBuilding, amountContents;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 changeAdress;
    private CustomerController controller;
    private boolean check = false;
    
    public void initComponents() {
        
        setLayout(new GridBagLayout());
        
        adress = new CustomTextField(17);
        adress.setEditable(false);
        adress.setText("Satt til kundens adresse");
        yearBuilt = new CustomTextField(5);
        type = new CustomTextField(15);
        material = new CustomTextField(10);
        standard = new CustomTextField(10);
        houseSize = new CustomTextField(5);
        amountBuilding = new CustomTextField(5);
        amountBuilding.setToolTipText("Forsikringsbeløp til bygg og tomt");
        amountContents = new CustomTextField(5);
        amountContents.setToolTipText("Forsikringsbeløp til husets innbo");

        submit = new CustomButton("Registrer");
        changeAdress = new CustomButton2("Endre");
        changeAdress.addActionListener((e) -> change());
        
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
        
        gbc.gridy++;
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(changeAdress, gbc);
    }

    
    
    
    
    public NewHouseInsurance() {
        
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
    
    public String getAmountBuilding() {
        return amountBuilding.getText();
    }

    public String getAmountContents() {
        return amountContents.getText();
    }
    
    
    public void change() {
        if(!check) {
            adress.setEditable(true);
            check = true;
        }
        else {
            adress.setEditable(false);
            adress.setText("Satt til kundens adresse");
            check = false;
        }
    }
    
}
