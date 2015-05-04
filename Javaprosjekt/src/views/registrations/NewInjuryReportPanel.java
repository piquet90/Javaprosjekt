/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
import CustomSwing.CustomTextField;
import CustomSwing.CustomLabel;
import CustomSwing.CustomLabelHeader;
import CustomSwing.CustomPanel;
import controllers.Controller;
import controllers.NewCustomerController;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import views.View;

public class NewInjuryReportPanel extends CustomPanel implements View {
    
    private CustomTextField dato, typeSkade, beskrivelse, vitner, taksering, utbetalt;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private NewCustomerController controller;
    
    /**
     * Initializes the GUI components
    */
    public void initComponents()
    {
        dato = new CustomTextField(10);
        dato.setEditable(false);
        dato.setText("Mottar dato");
        typeSkade = new CustomTextField(10);
        beskrivelse = new CustomTextField(20);
        taksering = new CustomTextField(6);
        utbetalt = new CustomTextField(6);
        vitner = new CustomTextField(10);
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> { controller.register();});
        
        this.setLayout(new GridBagLayout());
        this.setSize(getPreferredSize());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Dato: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Type skade: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Skademeldingsskjema: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Beskrivelse: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Bilder: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Vitner: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Taksering: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Ubetalt: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 5);
        add(new CustomLabelHeader("Opprett ny skademelding"));
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(dato, gbc);
        
        gbc.gridy++;
        add(typeSkade, gbc);
        
        gbc.gridy++;
        add(new CustomButton2("Last opp"), gbc);
        
        gbc.gridy++;
        add(beskrivelse, gbc);
         
        gbc.gridy++;
        add(new CustomButton2("Last opp"), gbc);
        
        gbc.gridy++;
        add(vitner, gbc);
        
        gbc.gridy++;
        add(taksering, gbc);
        
        gbc.gridy++;
        add(utbetalt, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
    }

    public String getTypeSkade() {
        return typeSkade.getText();
    }

    public String getBeskrivelse() {
        return beskrivelse.getText();
    }
    
    public String getVitner() {
        return vitner.getText();
    }

    public String getTaksering() {
        return taksering.getText();
    }

    public String getUtbetalt() {
        return utbetalt.getText();
    }
 
    

    
    public NewInjuryReportPanel()
    {
        
    }

    @Override
    public boolean addController(Controller c) {
        return false;
    }
}