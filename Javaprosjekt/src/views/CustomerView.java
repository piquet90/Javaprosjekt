/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton2;
import CustomSwing.CustomButton3;
import CustomSwing.CustomTextField;
import CustomSwing.CustomLabel;
import CustomSwing.CustomLabelHeader;
import CustomSwing.CustomPanel;
import controllers.Controller;
import controllers.NewCustomerController;
<<<<<<< HEAD
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
=======
import java.awt.*;
>>>>>>> 8f90656e17348c209aa3eb6fbf5fabf488d408a7
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

public class CustomerView extends JTabbedPane implements View {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private CustomPanel cusTab, insTab, repTab;
    private GridBagConstraints gbc, g;
    private CustomButton2 endre, slett;
    private NewCustomerController controller;
    
    
    public void initComponents()
    {
        this.setBackground(new Color(159, 196, 232));
        this.setFont(new Font("Arial", Font.BOLD, 20));
        
        cusTab = new CustomPanel();
        insTab = new CustomPanel();
        insTab.setPreferredSize(new Dimension(600, 400));
        repTab = new CustomPanel();

  
        
        
        
        //cusTab components
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
        
        //cusTab Layout initalizing
        cusTab.setLayout(new GridBagLayout());
 
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        //Adding the components to cusTab panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        cusTab.add(new CustomLabel("Fornavn: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Etternavn: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Postnummer: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Poststed: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.gridwidth = 2;
        cusTab.add(fNavn, gbc);
        
        gbc.gridy++;
        cusTab.add(eNavn, gbc);
        
        gbc.gridy++;
        cusTab.add(adresse, gbc);
        
        gbc.gridy++;
        cusTab.add(postNr, gbc);
        
        gbc.gridy++;
        cusTab.add(postSted, gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel(""), gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        cusTab.add(endre, gbc);
        
        gbc.insets = new Insets(15, 25, 0, 5);
        gbc.gridx++;
        cusTab.add(slett, gbc);
        
        gbc.gridx = 2;
        gbc.gridy = 1;
        cusTab.add(new CustomLabel(""), gbc);
        
        gbc.gridx = 3;
        gbc.gridy = 1;
        cusTab.add(new CustomLabel(""), gbc);
        
        
        
        CustomPanel p = new CustomPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(10, 0, 0, 0);
        g.gridx = 0;
        g.gridy = 0;
        p.add(new CustomButton3("Ny Forsikring"), g);
        g.insets = new Insets(20, 0, 10, 0);
        g.gridy++;
        p.add(new CustomButton3("Ny Skademelding"), g);
        p.setBorder(BorderFactory.createTitledBorder("Handlinger"));
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 3;
        cusTab.add(p, gbc);
        
        this.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=15 marginheight=5>Kundeinformasjon</body></html>", cusTab);
        this.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=15 marginheight=5>Forsikringer</body></html>", insTab);
        this.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=15 marginheight=5>Skademeldinger</body></html>", repTab);
         
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