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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Audun
 */

public class NyBilforsikring extends CustomPanel implements View{
    
    private CustomTextField dato, bilEier, regNr, biltype, regAar, kmPerAar;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomButton2 endreEier;
    private NewCustomerController controller;
    private int check = 0;
    
    /**
     * Initializes the GUI components (cleaner constructor)
     */
    public void initComponents()
    {
        dato = new CustomTextField(10);
        dato.setEditable(false);
        bilEier = new CustomTextField(15);
        bilEier.setEditable(false);
        bilEier.setText("Satt til eier");
        regNr = new CustomTextField(10);
        biltype = new CustomTextField(15);
        regAar = new CustomTextField(10);
        kmPerAar = new CustomTextField(10);
        
        
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();
        dato.setText(dateFormat.format(cal.getTime()));
        
        endreEier = new CustomButton2("Endre");
        
        endreEier.addActionListener((e) -> { if(check == 0){bilEier.setEditable(true); check=1;}else{bilEier.setEditable(false); bilEier.setText("Satt til eier");check=0;}});
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> { controller.test();});

    }
    /**
     * NyBilforsikring constructor
     */
    public NyBilforsikring()
    {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        initComponents();
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Dato: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Bileier: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. nummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Biltype: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Reg. år: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Km per år: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(new CustomLabel("Opprette ny bilforsikring"));
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(dato, gbc);
        
        gbc.gridy++;
        add(bilEier, gbc);
        
        gbc.gridy++;
        add(regNr, gbc);
        
        gbc.gridy++;
        add(biltype, gbc);
        
        gbc.gridy++;
        add(regAar, gbc);
        
        gbc.gridy++;
        add(kmPerAar, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        
        gbc.gridx = 2;
        gbc.gridy = 2;
        add(endreEier, gbc);
    }

    @Override
    public boolean addController(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
