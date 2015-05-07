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
import DAO.Constants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class CustomerView extends JTabbedPane implements ActionListener{
    
    private CustomTextField fNavn, eNavn, adresse, postSted, postNr;

    
    private CustomPanel cusTab, repTab;
    private GridBagConstraints gbc;
    private CustomButton2 endre;
    private CustomButton3 newIns, newRep;
    private boolean edit = false;
    
    private CustomListener listener;
    
    
    
    
    /**
     * Constructor that recieves the customer information and sets the textfields
     * @param fn Fornavn
     * @param en Etternavn
     * @param adr Adresse
     * @param ps Poststed
     * @param pnr Postnummer
     */
    public CustomerView()
    {
        this.setBackground(new Color(159, 196, 232));
        this.setFont(new Font("Arial", Font.BOLD, 18));
        
        cusTab = new CustomPanel();
        // insTab = new CustomPanel();
        // insTab.setPreferredSize(new Dimension(600, 400));
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
        
        
        // Buttons
        endre = new CustomButton2("Endre");
        newIns = new CustomButton3("Ny Forsikring");       
        newRep = new CustomButton3("Ny Skademelding");
        
        endre.addActionListener(this);
        newIns.addActionListener(this);
        newRep.addActionListener(this);
        
        // end of buttons
        
        //cusTab Layout initalizing
        cusTab.setLayout(new GridBagLayout());
 
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 0, 5);
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
        gbc.insets = new Insets(15, 0, 0, 10);
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
        g.insets = new Insets(15, 0, 5, 0);
        
        p.setBorder(BorderFactory.createTitledBorder("Handlinger"));
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 4;
        gbc.insets = new Insets(0, 50, 0, 15);
        cusTab.add(p, gbc);
        
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Kundeinformasjon</body></html>", cusTab);
        // this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Forsikringer</body></html>", insTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Skademeldinger</body></html>", repTab);

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
    
    public boolean isEditable()
    {
        return edit;
    }
    
    public String getfNavn() {
        return fNavn.getText();
    }

    public void setfNavn(String fNavn) {
        this.fNavn.setText(fNavn);
    }

    public String geteNavn() {
        return eNavn.getText();
    }

    public void seteNavn(String eNavn) {
        this.eNavn.setText(eNavn);
    }

    public String getAdresse() {
        return adresse.getText();
    }

    public void setAdresse(String adresse) {
        this.adresse.setText(adresse);
    }

    public String getPostSted() {
        return postSted.getText();
    }

    public void setPostSted(String postSted) {
        this.postSted.setText(postSted);
    }

    public String getPostNr() {
        return postNr.getText();
    }

    public void setPostNr(String postNr) {
        this.postNr.setText(postNr);
    }
 
    /**
     * 
     * @param error Recieves error message from controller and displays it to user
     */
    public void showError(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }
    
    public void addTable(String s, ViewTable v)
    {
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>"+s+"</body></html>", new JScrollPane(v));
    }
    
    public void setEditable(Boolean b)
    {
        this.edit = b;
    }
    
    public void addCustomListener(CustomListener e)
    {
        this.listener = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==endre)// tilate endring av felt
            if(!edit)
                endre();
            else
                listener.customActionPerformed(new CustomEvent(Constants.NEW_CUSTOMER));
        if(e.getSource()==newIns)// ny forsikring
            listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE));
        if(e.getSource()==newRep)
            listener.customActionPerformed(new CustomEvent(Constants.NEW_REPORT));
    }

}