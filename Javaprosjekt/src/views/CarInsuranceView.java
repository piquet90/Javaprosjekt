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
public class CarInsuranceView extends CustomPanel {
    
    private CustomTextField carOwner, type, regNr, model, horsepower, regYear, kmPerYear, premium, amount, conditions;
    private GridBagConstraints gbc;
    private CustomButton2 change;
    private boolean edit = false;
    
    
    public void initComponents()
    {
        carOwner = new CustomTextField(17);
        carOwner.setEditable(false);
        type = new CustomTextField(15);
        type.setEditable(false);
        regNr = new CustomTextField(9);
        regNr.setEditable(false);
        model = new CustomTextField(17);
        model.setEditable(false);
        horsepower = new CustomTextField(6);
        horsepower.setEditable(false);
        regYear = new CustomTextField(6);
        regYear.setEditable(false);
        kmPerYear = new CustomTextField(9);
        kmPerYear.setEditable(false);
        premium = new CustomTextField(5);
        premium.setEditable(false);
        amount = new CustomTextField(5);
        amount.setEditable(false);
        conditions = new CustomTextField(15);
        conditions.setEditable(false);
        
        change = new CustomButton2("Endre");
        change.addActionListener((e) -> change());
    }
    
    public CarInsuranceView()
    {
        initComponents();
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
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
        add(new CustomLabel("Forsikringspremie: "), gbc);

        gbc.gridy++;
        add(new CustomLabel("Forsikringsbeløp: "), gbc);        

        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(carOwner, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(type, gbc);
        
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
        add(premium, gbc);

        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);

        
    }
    
    /**
     * Sets car owners name in car owner name-field
     * @param co car owners name
     */
    public void setCarOwner(String co) {
        carOwner.setText(co);
    }

    /**
     * Sets car type in the car type-field
     * @param t car type
     */
    public void setType(String t) {
        type.setText(t);
    }

    /**
     * Sets the cars register number in the register number-field
     * @param rn cars register number
     */
    public void setRegNr(String rn) {
        regNr.setText(rn);
    }

    /**
     * Sets the cars model in the car model-field
     * @param m cars model
     */
    public void setModel(String m) {
        model.setText(m);
    }

    /**
     * Sets the cars horsepower in the horsepower-field
     * @param hp cars horsepower
     */
    public void setHorsepower(String hp) {
        horsepower.setText(hp);
    }

    /**
     * Sets the cars registered year in the registered year-field
     * @param y cars register year
     */
    public void setRegYear(String y) {
        regYear.setText(y);
    }

    /**
     * Sets the kilometer driven per year in the km per year-field
     * @param km kilometer per year
     */
    public void setKmPerYear(String km) {
        kmPerYear.setText(km);
    }
    
    /**
     * Sets the price per kilometer in the price pr km-field
     * @param ppkm price in NOK per kilometer driven
     */
    public void setPricePerKm(String ppkm) {
        kmPerYear.setText(ppkm);
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
            carOwner.setEditable(true);
            type.setEditable(true);
            regNr.setEditable(true);
            model.setEditable(true);
            regYear.setEditable(true);
            kmPerYear.setEditable(true);
            horsepower.setEditable(true);
            premium.setEditable(true);
            amount.setEditable(true);
            conditions.setEditable(true);
            
            change.setText("Lagre");
            
            edit = true;  
        }
        else {
            String bo = carOwner.getText();
            String t = type.getText();
            String rnr = regNr.getText();
            String m = model.getText();
            String ry = regYear.getText();
            String et = kmPerYear.getText();
            String hp = horsepower.getText();
            String p = premium.getText();
            String a = amount.getText();
            String c = conditions.getText();

            carOwner.setEditable(false);
            type.setEditable(false);
            regNr.setEditable(false);
            model.setEditable(false);
            regYear.setEditable(false);
            kmPerYear.setEditable(false);
            horsepower.setEditable(false);
            premium.setEditable(false);
            amount.setEditable(false);
            conditions.setEditable(false);
            
            change.setText("Endre");
            
            edit = false;
        } 
    }
}
