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

public class NewCarInsurance extends CustomPanel implements View {
    
    private CustomTextField bilEier, regNr, modell, effekt, regAar, kmPerAar;
    private JComboBox<String> carType;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private NewCustomerController controller;
    private boolean check = false;
    private int n = 0;
    
    /**
     * Initializes the GUI components (cleaner constructor)
     */
    public void initComponents() {
        
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        bilEier = new CustomTextField(15);
        bilEier.setEditable(false);
        bilEier.setText("Satt til valgt kunde");
        regNr = new CustomTextField(10);
        modell = new CustomTextField(15);
        effekt = new CustomTextField(10);
        regAar = new CustomTextField(10);
        kmPerAar = new CustomTextField(10);
        
        String[] t = {"Stasjonsvogn", "Kombi 5-dørs", "SUV", "Sedan", "Kasse", "Flerbruksbil",
                      "Coupe", "Kombi 3-dørs", "Cabriolet", "Pickup", "Veteran", "Elbil"};
        carType = new JComboBox<>(t);
        carType.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        carType.addActionListener((e)-> n = carType.getSelectedIndex());

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
        add(bilEier, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 2;
        add(carType, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        add(modell, gbc);
        
        gbc.gridy++;
        add(effekt, gbc);
        
        gbc.gridy++;
        add(regAar, gbc);
        
        gbc.gridy++;
        add(kmPerAar, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        //Knapp som gjør eier-felt editable/uneditable
        gbc.gridx = 2;
        gbc.gridy = 1;
        add(endreEier, gbc);
        
        

    }

    public String getBilEier() {
        return bilEier.getText();
    }

    public String getRegNr() {
        return regNr.getText();
    }

    public String getModell() {
        return modell.getText();
    }

    public String getEffekt() {
        return effekt.getText();
    }

    public String getRegAar() {
        return regAar.getText();
    }

    public String getKmPerAar() {
        return kmPerAar.getText();
    }

    public String getCarType() {
        return carType.getItemAt(n);
    }
    
    /**
     * NyBilforsikring constructor
     */
    public NewCarInsurance() {
        
    }
    
    public void test() {
        
        if(!check) {
            bilEier.setEditable(true);
            check = true;
        }
        else {
            bilEier.setEditable(false);
            bilEier.setText("Satt til valgt kunde");
            check = false;
        }
    }

    @Override
    public boolean addController(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
