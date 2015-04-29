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
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import javax.swing.JOptionPane;

public class CustomerView extends CustomPanel implements View {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private CustomPanel test, test2;
    private GridBagConstraints gbc, g;
    private CustomButton2 endre, slett;
    private NewCustomerController controller;
    
    
    public void initComponents()
    {
        
        this.setSize(getPreferredSize());
        this.setLayout(new GridBagLayout());
        test = new CustomPanel();
        test2 = new CustomPanel();
        test2.setPreferredSize(new Dimension(300, 310));
        test2.setBackground(Color.WHITE);
        
        g = new GridBagConstraints();
        g.anchor = GridBagConstraints.LINE_START;
        g.ipadx = 10;
        g.ipady = 0;
        
        //TIL INFOPANEL
        fNavn = new CustomTextField(12);
        fNavn.setEditable(false);
        eNavn = new CustomTextField(12);
        eNavn.setEditable(false);
        adresse = new CustomTextField(15);
        adresse.setEditable(false);
        postSted = new CustomTextField(12);
        postSted.setEditable(false);
        postNr = new CustomTextField(5);
        postNr.setEditable(false);
        
        endre = new CustomButton2("Endre");
        slett = new CustomButton2("Slett kunde");
        
        //Layout initalizing
        test.setLayout(new GridBagLayout());
 
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        //Adding the components to the panel
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        test.add(new CustomLabel("Fornavn: "), gbc);
        
        gbc.gridy++;
        test.add(new CustomLabel("Etternavn: "), gbc);
        
        gbc.gridy++;
        test.add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        test.add(new CustomLabel("Postnummer: "), gbc);
        
        gbc.gridy++;
        test.add(new CustomLabel("Poststed: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 5);
        test.add(new CustomLabelHeader("Se på kunde"));
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.gridwidth = 2;
        test.add(fNavn, gbc);
        
        gbc.gridy++;
        test.add(eNavn, gbc);
        
        gbc.gridy++;
        test.add(adresse, gbc);
        
        gbc.gridy++;
        test.add(postNr, gbc);
        
        gbc.gridy++;
        test.add(postSted, gbc);
        
        gbc.gridy++;
        test.add(new CustomLabel(""), gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        test.add(endre, gbc);
        
        gbc.insets = new Insets(15, 25, 0, 5);
        gbc.gridx++;
        test.add(slett, gbc);
        
        g.gridy = 0;
        g.gridx = 0;
        g.gridheight = 2;
        
        this.add(test, g);
        g.gridx++;
        g.gridheight = 1;
        g.insets = new Insets(0, 20, 0, 0);
        test2.add(new CustomLabel("Liste med kundens forsikringer"));
        this.add(test2, g);
         
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
        initComponents();
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