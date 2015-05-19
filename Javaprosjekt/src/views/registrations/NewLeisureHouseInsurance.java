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
import DAO.Constants;
import controllers.CustomerController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import views.CustomEvent;
import views.CustomListener;

/**
 * Panel for registering a boat insurance
 * @author Audun
 */

public class NewLeisureHouseInsurance extends CustomPanel {
    
    private CustomTextField adress, yearBuilt, type, material, standard, houseSize, amountBuilding, amountContents, premium, conditions;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomCheckBox lease;
    private CustomerController controller;
    
    private CustomListener listener;
    
    
    /**
     * NewLeisureHouseInsurance constructor
     */
    public NewLeisureHouseInsurance()
    {   
        adress = new CustomTextField(15);
        yearBuilt = new CustomTextField(5);
        type = new CustomTextField(15);
        material = new CustomTextField(10);
        standard = new CustomTextField(10);
        houseSize = new CustomTextField(4);
        amountBuilding = new CustomTextField(6);
        amountContents = new CustomTextField(6);
        premium = new CustomTextField(5);
        conditions = new CustomTextField(15);
        
        lease = new CustomCheckBox("");
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> {listener.customActionPerformed(new CustomEvent(Constants.LEISUREHOUSE_INSURANCE_INT));});
        setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 0, 5);
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
        add(new CustomLabel("Forsikringsbeløp, bygg: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringsbeløp, innbo: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringspremie: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);
        
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
        add(premium, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);
        
        gbc.gridy++;
        add(lease, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
    }

    /**
     * Returns the text the user has written in the adress-field
     * @return adress to the house the insurance will be registered to
     */
    public String getAdress() {
        return adress.getText();
    }
    
    
    /**
     * Returns the text the user has written in the year built-field
     * @return year of construction
     */
    public String getYearBuilt() {
        return yearBuilt.getText();
    }
    
    
    /**
     * Returns the text the user has written in the house type-field
     * @return house type (e.g. apartment, terraced house etc)
     */
    public String getType() {
        return type.getText();
    }
    
    
    /**
     * Returns the text the user has written in the house material-field
     * @return house build material (e.g. wood, brick etc)
     */
    public String getMaterial() {
        return material.getText();
    }
    
    
    /**
     * Returns the text the user has written in the standard-field
     * @return house standard (e.g. refurbished, needs refurbishing etc)
     */
    public String getStandard() {
        return standard.getText();
    }
    
    /**
     * Returns the text the user has written in the house size-field
     * @return the size of the house in square metres
     */
    public String getHouseSize() {
        return houseSize.getText();
    }
    
    
    /**
     * Returns the text the user has written in the insurance amount, building-field
     * @return amount in NOK the house should be insured for
     */
    public String getAmountBuilding() {
        return amountBuilding.getText();
    }
    
    
    /**
     * Returns the text the user has written in the insurance amount, contents-field
     * @return amount in NOK the house-contents should be insured for
     */
    public String getAmountContents() {
        return amountContents.getText();
    }
    
    /**
     * Returns the text the user has written in the yearly premium-field
     * @return amount in NOK the yearly premium
     */
    public String getPremium() {
        return premium.getText();
    }
    
    /**
     * Returns the text the user has written in the conditions-field
     * @return conditions for the insurance
     */
    public String getConditions() {
        return conditions.getText();
    }
    
    /**
     * Returns if the leisure house will be rented out
     * @return true for lease, false if not
     */
    public boolean getLease() {
        return lease.isSelected();
    }
    
    /**
     * Method that connect controllers listener to the panel
     * @param l Custom listener
     */
    public void addCustomListener(CustomListener l)
    {
        this.listener = l;
    }
 
}
