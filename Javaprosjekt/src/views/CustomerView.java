/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

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
import javax.swing.JOptionPane;

public class CustomerView extends CustomPanel implements View {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private GridBagConstraints gbc;
    private CustomButton2 endre, slett;
    private NewCustomerController controller;
    
    /**
     * Initializes the GUI components
    */
    public void initComponents()
    {
        //Initalizing the GUI components
        fNavn = new CustomTextField(15);
        fNavn.setEditable(false);
        eNavn = new CustomTextField(15);
        eNavn.setEditable(false);
        adresse = new CustomTextField(20);
        adresse.setEditable(false);
        postSted = new CustomTextField(15);
        postSted.setEditable(false);
        postNr = new CustomTextField(6);
        postNr.setEditable(false);
        
        endre = new CustomButton2("Endre");
        slett = new CustomButton2("Slett kunde");
        
        //Layout initalizing
        this.setLayout(new GridBagLayout());
        this.setSize(getPreferredSize());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        //Adding the components to the panel
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Fornavn: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Etternavn: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Postnummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Poststed: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 5);
        add(new CustomLabelHeader("Se på kunde"));
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(fNavn, gbc);
        
        gbc.gridy++;
        add(eNavn, gbc);
        
        gbc.gridy++;
        add(adresse, gbc);
        
        gbc.gridy++;
        add(postNr, gbc);
        
        gbc.gridy++;
        add(postSted, gbc);
        
        gbc.gridy++;
        add(endre, gbc);
        
        gbc.gridx++;
        add(slett, gbc);
         
    }
    
    
    
    /**
     * Constructor that recieves the customer information and sets the textfields
     * @param fn Fornavn
     * @param en Etternavn
     * @param adr Adresse
     * @param ps Poststed
     * @param pnr Postnummer
     */
    public CustomerView(String fn, String en, String adr, String ps, String pnr)
    {

        fNavn.setText(fn);
        eNavn.setText(en);
        adresse.setText(adr);
        postSted.setText(ps);
        postNr.setText(pnr);
    }
    
    /**
     * Method makes textfields editable and passes the changed information to registry
     */
    public void endre() {

        String f = fNavn.getText();
        String e = eNavn.getText();
        String a = adresse.getText();
        String ps = postSted.getText();
        String pn = postNr.getText();
        
        //controller.endre(f, e, a, ps, pn);
    }
    
    public void slett() {
        //controller.slett();
    }

 
    /**
     * 
     * @param error Recieves error message from controller and displays it to user
     */
    public void showError(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }
    

    @Override
    public boolean addController(Controller c) {
        return false;
    }
}