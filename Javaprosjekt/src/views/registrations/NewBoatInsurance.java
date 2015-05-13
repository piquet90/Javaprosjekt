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
import controllers.Controller;
import controllers.CustomerController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;
import views.CustomListener;

/**
 *
 * @author Audun
 */

public class NewBoatInsurance extends CustomPanel {
    
    private CustomTextField boatOwner, regNr, model, length, regYear, engineType, horsepower;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private JComboBox<String> type;
    private CustomerController controller;
    private boolean check = false;
    private int n = 0;
    
    private CustomListener listener;
    
    /**
     * NyBilforsikring constructor
     */
    public NewBoatInsurance() {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        boatOwner = new CustomTextField(17);
        boatOwner.setEditable(false);
        boatOwner.setText("Satt til valgt kunde");
        regNr = new CustomTextField(9);
        model = new CustomTextField(17);
        regYear = new CustomTextField(6);
        engineType = new CustomTextField(10);
        horsepower = new CustomTextField(6);
        length = new CustomTextField(6);
        
        endreEier = new CustomButton2("Endre");
        
        endreEier.addActionListener((e) -> change());
        
        submit = new CustomButton("Registrer");
        
        String[] t = {"Velg type...", "Cabincruiser", "Daycruiser", "RIB", "Jolle","Landstedsbåt ",
                       "Seilbåt", "Motorseiler", "Speedbåt", "Trebåt", "Vannscooter", "Yacht", "Yrkesbåt" };
        
        type = new JComboBox<>(t);
        type.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        type.addActionListener((e)-> n = type.getSelectedIndex());
        type.setBackground(new Color(250, 250, 250));
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Båteier: "), gbc);
        
        //gbc.gridy++;
        //TODO add buttongroup (båt har / har ikke reg nr
        
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
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(endreEier, gbc);
    }
    
    

    public String getBoatOwner() {
        return boatOwner.getText();
    }

    public String getRegNr() {
        return regNr.getText();
    }

    public String getModel() {
        return model.getText();
    }

    public String getLength() {
        return length.getText();
    }

    public String getRegYear() {
        return regYear.getText();
    }

    public String getEngineType() {
        return engineType.getText();
    }

    public String getHorsepower() {
        return horsepower.getText();
    }

    public String getType() {
        return type.getItemAt(n);
    }
    
    
    
    public void change() {
        
        if(!check) {
            boatOwner.setEditable(true);
            check = true;
        }
        else {
            boatOwner.setEditable(false);
            boatOwner.setText("Satt til valgt kunde");
            check = false;
        }
    }

   public void addCustomListener(CustomListener l)
   {
       this.listener = l;
   }
}