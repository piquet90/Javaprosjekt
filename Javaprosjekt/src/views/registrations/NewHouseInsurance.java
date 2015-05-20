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
import DAO.Constants;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import views.CustomEvent;
import views.CustomListener;

/**
 * Panel for registering a house insurance
 * @author Audun
 */

public class NewHouseInsurance extends CustomPanel {
    
    private CustomTextField adress, yearBuilt, type, material, standard, houseSize, amountBuilding, amountContents, premium, conditions, active;
    private CustomPanel actions;
    private GridBagConstraints gbc, gbc2;
    private CustomButton submit;
    private CustomButton2 delete, report;
    private boolean viewMode = false;
    private boolean edit = false;
    
    private CustomListener listener;
    
    /**
     * NewHouseInsurance constructor
     */
    public NewHouseInsurance()
    {
        setLayout(new GridBagLayout());
        adress = new CustomTextField(17);
        yearBuilt = new CustomTextField(5);
        type = new CustomTextField(15);
        material = new CustomTextField(10);
        standard = new CustomTextField(10);
        houseSize = new CustomTextField(5);
        amountBuilding = new CustomTextField(8);
        amountContents = new CustomTextField(8);
        premium = new CustomTextField(8);
        conditions = new CustomTextField(18);
        
        active = new CustomTextField(15);
        active.setBackground(null);
        active.setBorder(null);
        active.setForeground(Color.RED);
        active.setVisible(false);

        delete = new CustomButton2("Avslutt forsikring");
        delete.setVisible(false);
        submit = new CustomButton("Registrer");
        
        
        report = new CustomButton2("Opprett skademelding");
        actions = new CustomPanel();
        actions.setLayout(new GridBagLayout());
        gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.insets = new Insets(10, 5, 10, 5);
        actions.setBorder(BorderFactory.createTitledBorder("Handlinger"));
        gbc2.weighty = 1;
        gbc2.weightx = 1;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        actions.add(report, gbc2);
        gbc2.gridy++;
        actions.add(delete, gbc2);
        actions.setVisible(false);
        
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 0, 5);
        gbc.weighty = 1;
        gbc.weightx = 1;
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
        add(submit, gbc);
        
        gbc.gridy = 2;
        gbc.gridx = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.insets = new Insets(5, 40, 0, 5);
        add(actions, gbc);
        
        gbc.gridy = 4;
        add(active, gbc);
        
        
        
        
        
        submit.addActionListener((e) -> {
                if(!viewMode)
                {
                    listener.customActionPerformed(new CustomEvent(Constants.HOUSE_INSURANCE_INT));
                }
                else if(edit)
                {
                    listener.customActionPerformed(new CustomEvent(Constants.HOUSE_INSURANCE_INT));
                    change();
                }
                else {
                    change();
                }

                
        });
        
        
        delete.addActionListener((e) -> System.out.println("slett husforsikring"));
        
        report.addActionListener((e) ->{listener.customActionPerformed(new CustomEvent(Constants.NEW_REPORT));});

    }
    
    /**
     * Changes text-fields to uneditable if panel is used for viewing
     */
    public void setViewMode()
    {
        adress.setEditable(false);
        yearBuilt.setEditable(false);
        type.setEditable(false);
        material.setEditable(false);
        standard.setEditable(false);
        houseSize.setEditable(false);
        amountBuilding.setEditable(false);
        amountContents.setEditable(false);
        premium.setEditable(false);
        conditions.setEditable(false);
        actions.setVisible(true);
        active.setVisible(true);
        
        submit.setText("Endre");
        delete.setVisible(true);
        
        viewMode = true;
    }
    
    /**
     * Returns whether or not the panel is in viewmode
     * @return boolean viewmode
     */
    public boolean isViewMode() {
        return viewMode;
    }

    /**
     * Sets the view mode
     * @param vm true or false
     */
    public void setViewMode(boolean vm) {
        viewMode = vm;
    }
    
    
    
    /**
     * Returns a string of the active status
     * @return active statis
     */
    public String getActive()
    {
        return active.getText();
    }
    
    /**
     * Sets the active status
     * @param a active status
     */
    public void setActive(String a)
    {
        active.setText(a);
    }
    
    
    
    /**
     * Method that sets the customers adress as default
     * @param a customers adress
     */
    public void setAdress(String a)
    {
        adress.setText(a);
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
     * Sets the houses year of construction in the construction year-field
     * @param y house year of construction
     */
    public void setYearBuilt(String y) {
        yearBuilt.setText(y);
    }

    /**
     * Sets the house type in the type-field
     * @param t house type
     */
    public void setType(String t) {
        type.setText(t);
    }

    /**
     * Sets the house building material in the material-field
     * @param m house material
     */
    public void setMaterial(String m) {
        material.setText(m);
    }

    /**
     * Set the house standard in the standard-field
     * @param s house standard
     */
    public void setStandard(String s) {
        standard.setText(s);
    }

    /**
     * Sets the house size in the size-field
     * @param hs house size in square meters
     */
    public void setHouseSize(String hs) {
        houseSize.setText(hs);
    }

    /**
     * Sets the insurance amount for the building in the amount building-field
     * @param ab insurance amount in NOK for the construction
     */
    public void setAmountBuilding(String ab) {
        amountBuilding.setText(ab);
    }

    /**
     * Sets the insurance amount for the contents in the amount contents-field
     * @param ac insurance amount in NOK for the house contents
     */
    public void setAmountContents(String ac) {
        amountContents.setText(ac);
    }
    
    /**
     * Sets the insurance premium amount in the premium-field
     * @param p insurance premium in NOK
     */
    public void setPremium(String p) {
        premium.setText(p);
    }
    
    /**
     * Sets the insurance conditions in the conditions-field
     * @param c insurance conditions
     */
    public void setConditions(String c)
    {
        conditions.setText(c);
    }
    
    /**
     * Method makes textfields editable and passes the changed information to registry
     */
    public void change()
    {
        if(!edit) {
            adress.setEditable(true);
            yearBuilt.setEditable(true);
            type.setEditable(true);
            material.setEditable(true);
            standard.setEditable(true);
            houseSize.setEditable(true);
            amountBuilding.setEditable(true);
            amountContents.setEditable(true);
            premium.setEditable(true);
            conditions.setEditable(true);
            
            submit.setText("Lagre");
            
            edit = true;  
        }
        else {
            adress.setEditable(false);
            yearBuilt.setEditable(false);
            type.setEditable(false);
            material.setEditable(false);
            standard.setEditable(false);
            houseSize.setEditable(false);
            amountBuilding.setEditable(false);
            amountContents.setEditable(false);
            premium.setEditable(false);
            conditions.setEditable(false);
            
            submit.setText("Endre");
            
            edit = false;
        } 
    }
    
    /**
     * Clears all text fields
     */
    public void clearFields()
    {
        adress.setText("");
        yearBuilt.setText("");
        type.setText("");
        material.setText("");
        standard.setText("");
        houseSize.setText("");
        amountBuilding.setText("");
        amountContents.setText("");
        premium.setText("");
        conditions.setText("");
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
