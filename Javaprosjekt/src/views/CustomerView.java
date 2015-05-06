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
import CustomSwing.CustomPanel;
import controllers.Controller;
import controllers.NewCustomerController;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

public class CustomerView extends JTabbedPane implements View {
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;
    private CustomPanel cusTab, insTab, repTab;
    private GridBagConstraints gbc, g;
    private CustomButton2 endre;
    private CustomButton3 slett, newIns, newRep;
    private NewCustomerController controller;
    private boolean edit = false;
    
    
    public void initComponents()
    {
        this.setBackground(new Color(159, 196, 232));
        this.setFont(new Font("Arial", Font.BOLD, 18));
        
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
        endre.addActionListener((e) -> endre());
        
        slett = new CustomButton3("Slett kunde");
        slett.addActionListener((e) -> slett());
        
        newIns = new CustomButton3("Ny Forsikring");
        newRep = new CustomButton3("Ny Skademelding");
        
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
        g.insets = new Insets(15, 0, 0, 0);
        g.gridx = 0;
        g.gridy = 0;
        p.add(newIns, g);
        g.gridy++;
        p.add(newRep, g);
        g.gridy++;
        g.insets = new Insets(15, 0, 15, 0);
        p.add(slett, g);
        
        p.setBorder(BorderFactory.createTitledBorder("Handlinger"));
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 4;
        gbc.insets = new Insets(0, 50, 0, 0);
        cusTab.add(p, gbc);
        
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Kundeinformasjon</body></html>", cusTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Forsikringer</body></html>", insTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Skademeldinger</body></html>", repTab);
         
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
    public void endre()
    {
        if(!edit) {
            fNavn.setEditable(true);
            eNavn.setEditable(true);
            adresse.setEditable(true);
            postSted.setEditable(true);
            postNr.setEditable(true);
            
            endre.setText("Lagre");
            
            edit = true;  
        }
        else {
            String f = fNavn.getText();
            String e = eNavn.getText();
            String a = adresse.getText();
            String ps = postSted.getText();
            String pn = postNr.getText();
            
            //controller.endre(f, e, a, ps, pn);

            fNavn.setEditable(false);
            eNavn.setEditable(false);
            adresse.setEditable(false);
            postSted.setEditable(false);
            postNr.setEditable(false);
            
            endre.setText("Endre");
            
            edit = false;
        }

        
    }
    
    public void slett() {
        
        String[] j = {"Slett kunde", "Avbryt"};
               
        int y = JOptionPane.showOptionDialog(this, "Er du sikker på at du vil slette kunde " + fNavn.getText() + " " + eNavn.getText() + "?", "Slette kunde", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, j, j[1]);
        
        if(y ==  JOptionPane.YES_OPTION)
            System.out.println("Brukeren er slettet");
        else
            System.out.println("Brukeren er IKKE slettet");
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