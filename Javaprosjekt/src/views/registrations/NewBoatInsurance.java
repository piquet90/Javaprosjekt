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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import views.CustomEvent;
import views.CustomListener;

/**
 * Panel for registering a boat insurance
 * @author Audun
 */

public class NewBoatInsurance extends CustomPanel {
    
    private CustomTextField boatOwner, regNr, model, modelYear, length, engineType, horsepower, premium, amount, conditions, boatTypeField;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 delete;
    private JComboBox<String> boatType;
    private boolean edit = false;
    private boolean viewMode = false;
    private CustomListener listener;

    
    /**
     * NewBoatInsurance constructor
     */
    public NewBoatInsurance()
    {
        boatOwner = new CustomTextField(17);
        regNr = new CustomTextField(9);
        model = new CustomTextField(17);
        engineType = new CustomTextField(10);
        horsepower = new CustomTextField(6);
        length = new CustomTextField(6);
        premium = new CustomTextField(5);
        amount = new CustomTextField(5);
        conditions = new CustomTextField(15);
        modelYear = new CustomTextField(5);
        boatTypeField = new CustomTextField(15);
        boatTypeField.setVisible(false);
        
        submit = new CustomButton("Registrer");
        delete = new CustomButton2("Avslutt forsikring");
        delete.setVisible(false);

        
        String[] t = {"Velg type...", "Cabincruiser", "Daycruiser", "RIB", "Jolle","Landstedsbåt ",
                       "Seilbåt", "Motorseiler", "Speedbåt", "Trebåt", "Vannscooter", "Yacht", "Yrkesbåt" };
        
        boatType = new JComboBox<>(t);
        boatType.setFont(new Font("Arial", Font.PLAIN, 15));
        boatType.setBackground(new Color(250, 250, 250));
        
        
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.weighty = 1;
        gbc.weightx = 1;
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
        add(new CustomLabel("Motortype: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Effekt (i hk): "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Lengde (i fot): "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Årsmodell:"), gbc);
        
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
        add(boatType, gbc);
        add(boatTypeField, gbc);
        
        gbc.gridy++;
        add(model, gbc);
        
        gbc.gridy++;
        add(engineType, gbc);
        
        gbc.gridy++;
        add(horsepower, gbc);
        
        gbc.gridy++;
        add(length, gbc);
        
        gbc.gridy++;
        add(modelYear, gbc);
        
        gbc.gridy++;
        add(premium, gbc);

        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        gbc.gridx++;
        add(delete, gbc);
        
        
        submit.addActionListener((e) -> {
                
                if(!viewMode)
                {
                    listener.customActionPerformed(new CustomEvent(Constants.BOAT_INSURANCE_INT));
                }
                else if(edit)
                {
                    listener.customActionPerformed(new CustomEvent(Constants.BOAT_INSURANCE_INT));
                    change();
                }
                else {
                    change();
                }

                
        });
 
            
            
            
        delete.addActionListener((e)->{listener.customActionPerformed(new CustomEvent(Constants.DELETE_INSURANCE));});
        
    }
    
    
    
    /**
     * Changes text-fields to uneditable if panel is used for viewing
     */
    public void setViewMode()
    {
        boatOwner.setEditable(false);
        regNr.setEditable(false);
        boatTypeField.setEditable(false);
        model.setEditable(false);
        horsepower.setEditable(false);
        modelYear.setEditable(false);
        length.setEditable(false);
        engineType.setEditable(false);
        premium.setEditable(false);
        amount.setEditable(false);
        conditions.setEditable(false);
        
        submit.setText("Endre");
        delete.setVisible(true);
        boatType.setVisible(false);
        boatTypeField.setVisible(true);
        
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
     * Method that sets the owner-field with the customers name as a default
     * @param n Customer name
     */
    public void setBoatOwner(String n) {
        boatOwner.setText(n);
    }
    
    

    /**
     * Returns the boat owners name the user has written in the name-field
     * @return the boats owners name
     */
    public String getBoatOwner() {
        return boatOwner.getText();
    }

    /**
     * Returns the registration number the user has written in registration number-field
     * @return the boats registration number (might be blank)
     */
    public String getRegNr() {
        return regNr.getText();
    }

    /**
     * Returns the model the user has written in model-field
     * @return the boats brand and model
     */
    public String getModel() {
        return model.getText();
    }

    /**
     * Returns the length the user has written in boat length-field
     * @return the boats length in feet (ft)
     */
    public String getLength() {
        return length.getText();
    }

    public String getModelYear()
    {
        return modelYear.getText();
    }
    /**
     * Returns the engine boatType the user has written in engine boatType-field
     * @return a boat engine boatType
     */
    public String getEngineType() {
        return engineType.getText();
    }

    /**
     * Returns the power the user has written in the engine-power field
     * @return amount of horsepower the boat has
     */
    public String getHorsepower() {
        return horsepower.getText();
    }
    
    
   /**
     * Returns the boatType of boat the user has chosen from the dropdown menu or from the text-field if the panel is in viewmode
     * @return a boat boatType
     */
    public String getType() {
        if(viewMode)
            return boatTypeField.getText();
        else
        {
            return boatType.getItemAt(boatType.getSelectedIndex());
        }   
    }
    
    /**
     * Returns the text the user has written in the yearly premium-field
     * @return amount in NOK the yearly premium
     */
    public String getPremium() {
        return premium.getText();
    }
    
    /**
     * Returns the text the user has written in the amount-field
     * @return amount in NOK the boat will be insured for
     */
    public String getAmount() {
        return amount.getText();
    }
    
    /**
     * Returns the text the user has written in the conditions-field
     * @return conditions for the insurance
     */
    public String getConditions() {
        return conditions.getText();
    }
    

    /**
     * Sets boat boatType in the boat boatType-field
     * @param t boat boatType
     */
    public void setType(String t) {
        boatTypeField.setText(t);
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
     * Sets the year model in the year model-field
     * @param y boats year model
     */
    public void setRegYear(String y) {
        modelYear.setText(y);
    }

    /**
     * Sets the boats engine boatType in the engine boatType-field
     * @param et boats engine boatType
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
            premium.setEditable(true);
            amount.setEditable(true);
            conditions.setEditable(true);
            
            submit.setText("Lagre");
            
            edit = true;  
        }
        else {
            boatOwner.setEditable(false);
            premium.setEditable(false);
            amount.setEditable(false);
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
        boatType.setSelectedIndex(0);
        regNr.setText("");
        modelYear.setText("");
        model.setText("");
        length.setText("");
        engineType.setText("");
        horsepower.setText("");
        premium.setText("");
        amount.setText("");
        conditions.setText("");
    }
    
    
    /**
     * Method that connect controllers listener to the panel
     * @param l CustomListener
     */
   public void addCustomListener(CustomListener l)
   {
       this.listener = l;
   }

   /**
    * Sets model year
    * @param my model year
    */
    public void setModelYear(String my) {
        modelYear.setText(my);
    }
}