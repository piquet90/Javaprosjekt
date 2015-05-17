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
public class HouseInsuranceView extends CustomPanel {

    
    private CustomTextField adress, yearBuilt, type, material, standard, houseSize, amountBuilding, amountContents, premium, conditions;
    private GridBagConstraints gbc;
    private CustomButton2 change;
    private boolean edit = false;
    
    /**
     * Initializes the GUI components
     */
    public void initComponents()
    {
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
        premium = new CustomTextField(5);
        premium.setEditable(false);
	conditions = new CustomTextField(15);
        conditions.setEditable(false);
        
        change = new CustomButton2("Endre");
        change.addActionListener((e) -> change());
    }
    
    /**
     * HouseInsuranceViews constructor
     */
    public HouseInsuranceView()
    {
        setLayout(new GridBagLayout());

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
    }

    /**
     * Sets the house adress in the adress-field
     * @param a house adress
     */
    public void setAdress(String a) {
        adress.setText(a);
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
            
            change.setText("Lagre");
            
            edit = true;  
        }
        else {
            String a = adress.getText();
            String yb = yearBuilt.getText();
            String t = type.getText();
            String m = material.getText();
            String s = standard.getText();
            String hs = houseSize.getText();
            String ab = amountBuilding.getText();
            String ac = amountContents.getText();
            String p = premium.getText();
            String c = conditions.getText();

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
            
            change.setText("Endre");
            
            edit = false;
        } 
    }
    
}


