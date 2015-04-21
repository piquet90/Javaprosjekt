/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import controllers.Controller;
import controllers.NewCustomerController;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;

/**
 *
 * @author Audun
 */

public class NewBoatInsurance extends CustomPanel implements View {
    
    private CustomTextField baatEier, regNr, modell, lengde, regAar, motorType, effekt;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private JComboBox<String> type;
    private NewCustomerController controller;
    private boolean check = false;
    private int n = 0;
    
    /**
     * Initializes the GUI components (cleaner constructor)
     */
    public void initComponents() {
        
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        baatEier = new CustomTextField(15);
        baatEier.setEditable(false);
        baatEier.setText("Satt til valgt kunde");
        regNr = new CustomTextField(10);
        modell = new CustomTextField(15);
        regAar = new CustomTextField(5);
        motorType = new CustomTextField(10);
        effekt = new CustomTextField(5);
        lengde = new CustomTextField(5);
        
        endreEier = new CustomButton2("Endre");
        
        endreEier.addActionListener((e) -> test());
        
        submit = new CustomButton("Registrer");
        
        String[] t = {"Velg type...", "Cabincruiser", "Daycruiser", "RIB", "Jolle","Landstedsbåt",
                       "Seilbåt/Motorseiler", "Speedbåt", "Trebåt/snekke", "Vannscooter", "Yacht", "Yrkesbåt" };
        
        type = new JComboBox<>(t);
        type.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        type.addActionListener((e)-> n = type.getSelectedIndex());
        
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
        add(baatEier, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        add(type, gbc);
        
        gbc.gridy++;
        add(modell, gbc);
        
        gbc.gridy++;
        add(regAar, gbc);
        
        gbc.gridy++;
        add(motorType, gbc);
        
        gbc.gridy++;
        add(effekt, gbc);
        
        gbc.gridy++;
        add(lengde, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(endreEier, gbc);
    }

    public String getBaatEier() {
        return baatEier.getText();
    }

    public String getRegNr() {
        return regNr.getText();
    }

    public String getModell() {
        return modell.getText();
    }

    public String getLengde() {
        return lengde.getText();
    }

    public String getRegAar() {
        return regAar.getText();
    }

    public String getMotorType() {
        return motorType.getText();
    }

    public String getEffekt() {
        return effekt.getText();
    }

    public String getType() {
        return type.getItemAt(n);
    }
    
    /**
     * NyBilforsikring constructor
     */
    public NewBoatInsurance() {
        
    }
    
    public void test() {
        
        if(!check) {
            baatEier.setEditable(true);
            check = true;
        }
        else {
            baatEier.setEditable(false);
            baatEier.setText("Satt til valgt kunde");
            check = false;
        }
    }

    @Override
    public boolean addController(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}



/* For båtforsikringer skal det i tillegg registreres

    eier (kan være forskjellig fra forsikringskunde)
    registreringsnummer (hvis det foreligger)
    båttype og modell
    lengde i fot
    årsmodell
    motortype og motorstyrke HK
    annet?*/
