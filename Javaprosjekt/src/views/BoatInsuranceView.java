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
public class BoatInsuranceView extends CustomPanel{
    
    private CustomTextField boatOwner, type, regNr, model, length, regYear, engineType, horsepower, premium, amount, conditions;
    private CustomButton2 change;
    private GridBagConstraints gbc;
    private boolean edit = false;
    
    /**
     * Initalzies the GUI components
     */
    public void initComponents()
    {
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
        premium = new CustomTextField(5);
        premium.setEditable(false);
        amount = new CustomTextField(5);
        amount.setEditable(false);
        conditions = new CustomTextField(15);
        conditions.setEditable(false);
        
        change = new CustomButton2("Endre");
        change.addActionListener((e) -> change());
    }
    
    /**
     * BoatInsuranceViews constructor
     */
    public BoatInsuranceView()
    {
        initComponents();
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
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
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringspremie: "), gbc);

        gbc.gridy++;
        add(new CustomLabel("Forsikringsbeløp: "), gbc);        

        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);
        

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
        
        gbc.gridy++;
        add(premium, gbc);

        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);

    }

    /**
     * Sets boat owners name in boat owner name-field
     * @param bo boat owners name
     */
    public void setBoatOwner(String bo) {
        boatOwner.setText(bo);
    }

    /**
     * Sets boat type in the boat type-field
     * @param t boat type
     */
    public void setType(String t) {
        type.setText(t);
    }

    /**
     * Sets the boats register number in the register number-field
     * @param rn boats register number
     */
    public void setRegNr(String rn) {
        regNr.setText(rn);
    }

    /**
     * Sets the boats model in the boat model-field
     * @param m boats model
     */
    public void setModel(String m) {
        model.setText(m);
    }

    /**
     * Sets the boats length in the boat length-field
     * @param l boats length in feet
     */
    public void setLength(String l) {
        length.setText(l);
    }

    /**
     * Sets the boat registered year in the registered year-field
     * @param y boats register year
     */
    public void setRegYear(String y) {
        regYear.setText(y);
    }

    /**
     * Sets the boats engine type in the engine type-field
     * @param et boats engine type
     */
    public void setEngineType(String et) {
        engineType.setText(et);
    }

    /**
     * Sets the boats horsepower in the horsepower-field
     * @param hp boats horsepower
     */
    public void setHorsePower(String hp) {
        horsepower.setText(hp);
    }
    
    /**
     * Sets the insurance premium amount in the premium-field
     * @param p insurance premium in NOK
     */
    public void setPremium(String p) {
        premium.setText(p);
    }
    
    /**
     * Sets the insurance amount in the amount-field
     * @param a insurance amount
     */
    public void setAmount(String a)
    {
        amount.setText(a);
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
            boatOwner.setEditable(true);
            type.setEditable(true);
            regNr.setEditable(true);
            model.setEditable(true);
            length.setEditable(true);
            regYear.setEditable(true);
            engineType.setEditable(true);
            horsepower.setEditable(true);
            premium.setEditable(true);
            amount.setEditable(true);
            conditions.setEditable(true);
            
            change.setText("Lagre");
            
            edit = true;  
        }
        else {
            String bo = boatOwner.getText();
            String t = type.getText();
            String rnr = regNr.getText();
            String m = model.getText();
            String l = length.getText();
            String ry = regYear.getText();
            String et = engineType.getText();
            String hp = horsepower.getText();
            String p = premium.getText();
            String a = amount.getText();
            String c = conditions.getText();
            
            //TODO:::::endre

            boatOwner.setEditable(false);
            type.setEditable(false);
            regNr.setEditable(false);
            model.setEditable(false);
            length.setEditable(false);
            regYear.setEditable(false);
            engineType.setEditable(false);
            horsepower.setEditable(false);
            premium.setEditable(false);
            amount.setEditable(false);
            conditions.setEditable(false);
            
            change.setText("Endre");
            
            edit = false;
        } 
    }
}
