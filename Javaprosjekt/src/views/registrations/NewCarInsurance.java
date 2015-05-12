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
 *
 * @author Audun
 */

public class NewCarInsurance extends CustomPanel {
    
    private CustomTextField carOwner, regNr, model, horsepower, regYear, kmPerYear, pricePerKm, bonus;
    private JComboBox<String> carType;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private boolean check = false;
    private int n = 0;
    private CustomListener listener;
    
    /**
     * NyBilforsikring constructor
     */
    public NewCarInsurance() {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        carOwner = new CustomTextField(17);
        regNr = new CustomTextField(9);
        model = new CustomTextField(17);
        horsepower = new CustomTextField(6);
        regYear = new CustomTextField(6);
        kmPerYear = new CustomTextField(9);
        pricePerKm = new CustomTextField(6);
        bonus = new CustomTextField(6);
        
        String[] t = {"Velg type...", "Stasjonsvogn ", "Kombi, 5-dørs", "SUV", "Sedan", "Kasse", "Flerbruk",
                      "Coupe", "Kombi, 3-dørs", "Cabriolet", "Pickup", "Veteran", "Elektrisk", "Lastebil", "Sport", "Terreng"};
        
        carType = new JComboBox<>(t);
        carType.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        carType.addActionListener((e)-> n = carType.getSelectedIndex());
        carType.setBackground(new Color(250, 250, 250));

        endreEier = new CustomButton2("Endre");
        
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) ->{listener.customActionPerformed(new CustomEvent(Constants.CAR_INSURANCE_INT));});
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
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
        add(bonus, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        /*
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(endreEier, gbc);
        */
    }
    
    public void setCarOwner(String s)
    {
        carOwner.setText(s);
    }
    public String getCarOwner() {
        return carOwner.getText();
    }

    public String getRegNr() {
        return regNr.getText();
    }
    public void setRegNr(String s)
    {
        regNr.setText(s);
    }

    public String getModel() {
        return model.getText();
    }

    public String getHorsepower() {
        return horsepower.getText();
    }

    public String getRegYear() {
        return regYear.getText();
    }

    public String getKmPerYear() {
        return kmPerYear.getText();
    }
    
    public String getPricePerKm()
    {
        return pricePerKm.getText();
    }
    
    public void setPricePerKm(String s)
    {
        pricePerKm.setText(s);
    }

    public String getCarType() {
        return carType.getItemAt(n);
    }
    
    public String getBonus()
    {
        return bonus.getText();
    }
    
    public void setBonus(String s)
    {
        bonus.setText(s);
    }
    
    
    public void test() {
        
        if(!check) {
            carOwner.setEditable(true);
            check = true;
        }
        else {
            carOwner.setEditable(false);
            carOwner.setText("Satt til valgt kunde");
            check = false;
        }
    }
    
    public void addCustomListener(CustomListener l)
    {
        this.listener = l;
    }
}
