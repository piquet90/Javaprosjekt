/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import views.CustomListener;

/**
 * Panel for registering a boat insurance
 * @author Audun
 */

public class NewBoatInsurance extends CustomPanel {
    
    private CustomTextField boatOwner, regNr, model, length, regYear, engineType, horsepower, premium, amount, conditions;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private JComboBox<String> type;
    private int n = 0;
    private CustomListener listener;
    
    
    /**
     * Method that initializes the GUI components
     */
    public void initComponents()
    {
        boatOwner = new CustomTextField(17);
        boatOwner.setEditable(false);
        boatOwner.setText("Satt til valgt kunde");
        regNr = new CustomTextField(9);
        model = new CustomTextField(17);
        regYear = new CustomTextField(6);
        engineType = new CustomTextField(10);
        horsepower = new CustomTextField(6);
        length = new CustomTextField(6);
        premium = new CustomTextField(5);
        amount = new CustomTextField(5);
        conditions = new CustomTextField(15);
        
        submit = new CustomButton("Registrer");
        
        String[] t = {"Velg type...", "Cabincruiser", "Daycruiser", "RIB", "Jolle","Landstedsbåt ",
                       "Seilbåt", "Motorseiler", "Speedbåt", "Trebåt", "Vannscooter", "Yacht", "Yrkesbåt" };
        
        type = new JComboBox<>(t);
        type.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        type.addActionListener((e)-> n = type.getSelectedIndex());
        type.setBackground(new Color(250, 250, 250));
    }
    
    /**
     * NewBoatInsurance constructor
     */
    public NewBoatInsurance()
    {
        initComponents();
        setLayout(new GridBagLayout());
        
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
        
        gbc.gridy++;
        add(submit, gbc);
        
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

    /**
     * Returns the registration year the user has written in register year-field
     * @return the year the boat was registered
     */
    public String getRegYear() {
        return regYear.getText();
    }

    /**
     * Returns the engine type the user has written in engine type-field
     * @return a boat engine type
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
     * Returns the type of boat the user has chosen from the dropdown menu
     * @return a boat type
     */
    public String getType() {
        return type.getItemAt(n);
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
     * Method that connect controllers listener to the panel
     * @param l CustomListener
     */
   public void addCustomListener(CustomListener l)
   {
       this.listener = l;
   }
}