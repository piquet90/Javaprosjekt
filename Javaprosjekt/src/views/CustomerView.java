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
import java.awt.*;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class CustomerView extends JTabbedPane implements View {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private CustomPanel cusTab, insTab, repTab;
    private GridBagConstraints gbc, g;
    private CustomButton2 endre, slett;
    private NewCustomerController controller;
    
    
    public void initComponents()
    {
        this.setBackground(Color.YELLOW);
        this.setFont(new Font("Arial", Font.BOLD, 20));
        
        cusTab = new CustomPanel();
        insTab = new CustomPanel();
        insTab.setPreferredSize(new Dimension(600, 400));

  
        
        
        
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
        
       
        
        this.addTab("<html><body leftmargin=15 topmargin=8 marginwidth=15 marginheight=5>Kundeinformasjon</body></html>", cusTab);
        this.addTab("Forsikringer", insTab);
         
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