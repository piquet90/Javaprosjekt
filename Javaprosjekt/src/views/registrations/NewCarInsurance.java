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
 * Panel for registering a car insurance
 * @author Audun
 */

public class NewCarInsurance extends CustomPanel {
    
    private CustomTextField carOwner, regNr, model, horsepower, regYear, kmPerYear, pricePerKm, premium, amount, conditions, bonus;
    private JComboBox<String> carType;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private int n = 0;
    private CustomListener listener;
    
    /**
     * Method that initalizes the GUI components
     */
    public void initComponents()
    {
        carOwner = new CustomTextField(17);
        regNr = new CustomTextField(9);
        model = new CustomTextField(17);
        horsepower = new CustomTextField(6);
        regYear = new CustomTextField(6);
        kmPerYear = new CustomTextField(9);
        pricePerKm = new CustomTextField(6);
        premium = new CustomTextField(5);
        amount = new CustomTextField(5);
        conditions = new CustomTextField(15);
        bonus = new CustomTextField(6);
        
        String[] t = {"Velg type...", "Stasjonsvogn ", "Kombi, 5-dørs", "SUV", "Sedan", "Kasse", "Flerbruk",
                      "Coupe", "Kombi, 3-dørs", "Cabriolet", "Pickup", "Veteran", "Elektrisk", "Lastebil", "Sport", "Terreng"};
        
        carType = new JComboBox<>(t);
        carType.setFont(new Font("Arial", Font.PLAIN, 15));
        carType.addActionListener((e)-> n = carType.getSelectedIndex());
        
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) ->{listener.customActionPerformed(new CustomEvent(Constants.CAR_INSURANCE_INT));});
    }
    
    
    /**
     * NyBilforsikring constructor
     */
    public NewCarInsurance()
    {
        initComponents();
        setLayout(new GridBagLayout());

        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 5, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Bileier: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. nummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Biltype: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Modell: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Effekt (i hk): "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. år: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Km per år: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Pris pr. Km.: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringspremie: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringsbeløp: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Bonus: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(carOwner, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(carType, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(model, gbc);
        
        gbc.gridy++;
        add(horsepower, gbc);
        
        gbc.gridy++;
        add(regYear, gbc);
        
        gbc.gridy++;
        add(kmPerYear, gbc);
        
        gbc.gridy++;
        add(pricePerKm, gbc);
        
        gbc.gridy++;
        add(premium, gbc);
        
        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);
        
        gbc.gridy++;
        add(bonus, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
    }
    
    /**
     * Method that sets the owner-field with the customers name as a default
     * @param s customers name
     */
    public void setCarOwner(String s)
    {
        carOwner.setText(s);
    }
    
    /**
     * Returns the car owners name the user has written in the name-field
     * @return the car owners name
     */
    public String getCarOwner() {
        return carOwner.getText();
    }

    /**
     * Returns the registration number the user has written in registration number-field
     * @return the cars registration number
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
     * Returns the power the user has written in the engine-power field
     * @return amount of horsepower the car has
     */
    public String getHorsepower() {
        return horsepower.getText();
    }

    /**
     * Returns the registration year the user has written in register year-field
     * @return the year the car was registered
     */
    public String getRegYear() {
        return regYear.getText();
    }

    /**
     * Returns the amount the user has written in the km per year-field
     * @return the number of kilometers the car gets driven per year
     */
    public String getKmPerYear() {
        return kmPerYear.getText();
    }
    
    /**
     * Returns the amount the user has written in the price per km-field
     * @return the price per kilometer in NOK
     */
    public String getPricePerKm()
    {
        return pricePerKm.getText();
    }
    
    /**
     * Returns the type of car the user has chosen from the dropdown menu
     * @return a car type
     */
    public String getCarType() {
        return carType.getItemAt(n);
    }
    
    /**
     * Returns the text the user has written in the bonus-field
     * @return the customers insurance bonus
     */
    public String getBonus()
    {
        return bonus.getText();
    }
    
    /**
     * Returns the text the user has written in the yearly premium-field
     * @return amount in NOK the yearly premium
     */
    public String getPremium() {
        return premium.getText();
    }
    
    /**
     * Returns the text the user has written in the insurance amount-field
     * @return the amount the car should be insured for
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
    
    
    public void clearFields()
    {
        
        carOwner.setText("");
        regNr.setText("");
        model.setText("");
        horsepower.setText("");
        regYear.setText("");
        kmPerYear.setText("");
        pricePerKm.setText("");
        premium.setText("");
        conditions.setText("");
        bonus.setText("");
   
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
