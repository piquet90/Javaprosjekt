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
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;

/**
 *
 * @author Audun
 */

public class NewCarInsurance extends CustomPanel {
    
    private CustomTextField carOwner, regNr, model, horsepower, regYear, kmPerYear;
    private JComboBox<String> carType;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private boolean check = false;
    private int n = 0;
    
    /**
     * NyBilforsikring constructor
     */
    public NewCarInsurance() {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        carOwner = new CustomTextField(17);
        carOwner.setEditable(false);
        carOwner.setText("Satt til valgt kunde");
        regNr = new CustomTextField(9);
        model = new CustomTextField(17);
        horsepower = new CustomTextField(6);
        regYear = new CustomTextField(6);
        kmPerYear = new CustomTextField(9);
        
        String[] t = {"Velg type...", "Stasjonsvogn ", "Kombi, 5-dørs", "SUV", "Sedan", "Kasse", "Flerbruk",
                      "Coupe", "Kombi, 3-dørs", "Cabriolet", "Pickup", "Veteran", "Elektrisk", "Lastebil", "Sport", "Terreng"};
        
        carType = new JComboBox<>(t);
        carType.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        carType.addActionListener((e)-> n = carType.getSelectedIndex());
        carType.setBackground(new Color(250, 250, 250));

        endreEier = new CustomButton2("Endre");
        
        endreEier.addActionListener((e) -> test());
        
        submit = new CustomButton("Registrer");
        
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
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(endreEier, gbc);
    }

    public String getCarOwner() {
        return carOwner.getText();
    }

    public String getRegNr() {
        return regNr.getText();
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

    public String getCarType() {
        return carType.getItemAt(n);
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

   
    public boolean addController(Controller c) {
        return true;
    }
}
