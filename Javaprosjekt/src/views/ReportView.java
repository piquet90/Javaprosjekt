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
import CustomSwing.CustomTextArea;
import controllers.ReportController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

/**
 * ReportView panel
 * @author Audun
 */
public class ReportView extends JTabbedPane {
    
    private CustomTextField date, estimation, paid, type,
            vitneFornavn, vitneEtternavn, vitneAdresse, vitneBy, vitnePnr, vitneTlf;

    private CustomTextArea description;
    private JScrollPane bScroll;
    private GridBagConstraints gbc, gbc2, gbc3;
    private CustomPanel txtTab, ulTab, wiTab;
    private CustomButton2 changeInfo, endreVitne;
    private ReportController controller;
    private boolean edit = false;
    private boolean edit2 = false;
    
    
    /**
     * Method that initalizes the GUI components
     */
    public void initComponents()
    {
        txtTab = new CustomPanel();
        txtTab.setLayout(new GridBagLayout());
        ulTab = new CustomPanel();
        ulTab.setLayout(new GridBagLayout());
        wiTab = new CustomPanel();
        wiTab.setLayout(new GridBagLayout());
        
        changeInfo = new CustomButton2("Endre");
        changeInfo.addActionListener((e) -> endreInfo());
        
        endreVitne = new CustomButton2("Endre");
        endreVitne.addActionListener((e) -> endreVitne());
        
        description = new CustomTextArea(8, 22);
        description.setEditable(false);
        bScroll = new JScrollPane(description);
        bScroll.setPreferredSize(description.getPreferredSize());

        date = new CustomTextField(10);
        date.setEditable(false);
        type = new CustomTextField(10);
        type.setEditable(false);
        estimation = new CustomTextField(6);
        estimation.setEditable(false);
        paid = new CustomTextField(6);
        paid.setEditable(false);
        
        vitneFornavn = new CustomTextField(15);
        vitneEtternavn = new CustomTextField(15);
        vitneAdresse = new CustomTextField(20);
        vitneBy = new CustomTextField(15);
        vitnePnr = new CustomTextField(6);
        vitneTlf = new CustomTextField(10);
        vitneFornavn.setEditable(false);
        vitneEtternavn.setEditable(false);
        vitneAdresse.setEditable(false);
        vitneBy.setEditable(false);
        vitnePnr.setEditable(false);
        vitneTlf.setEditable(false);
    }
    
    
    /**
     * ReportViews constructor
    */
    public ReportView()
    {
        setBackground(new Color(159, 196, 232));
        setFont(new Font("Arial", Font.BOLD, 18));
        
        
        // txtTab - tab for basic injury information ///////////////////////////
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 5, 0, 5);
        txtTab.add(new CustomLabelHeader("Skademelding nr 0"), gbc);
        
        gbc.gridy++;
        gbc.insets = new Insets(15, 0, 0, 5);
        txtTab.add(new CustomLabel("Hendelsesdato: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Type skade: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Beskrivelse av skade: "), gbc);

        gbc.gridy++;
        txtTab.add(new CustomLabel("Taksering av skade: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Utbetalt: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 55);
        txtTab.add(date, gbc);
        
        gbc.gridy++;
        txtTab.add(type, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 3;
        txtTab.add(bScroll, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        txtTab.add(estimation, gbc);
        
        gbc.gridy++;
        txtTab.add(paid, gbc);
        
        gbc.gridy++;
        gbc.insets = new Insets(15, 0, 25, 5);
        txtTab.add(changeInfo, gbc);
        
        
        
        // ulTab - tab for uploading images and injury report //////////////////
        gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(15, 0, 0, 5);
        gbc2.ipadx = 2;
        gbc2.ipady = 5;

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.anchor = GridBagConstraints.LINE_START;
        ulTab.add(new CustomLabelHeader("Bilder av skade"), gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_END;
        gbc2.gridy++;
        ulTab.add(new CustomLabel("Bilder i editorpane"), gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.gridy++;
        gbc2.gridwidth = 2;
        ulTab.add(new CustomLabelHeader("Skademeldingsskjema"), gbc2);
        
        gbc2.gridy = 4;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 2;
        gbc2.anchor = GridBagConstraints.LINE_START;
        ulTab.add(new CustomLabel("link til skademeldingsskjema"), gbc2);

        
        
        // wiTab - tab for witness contact information /////////////////////////
        wiTab.add(new CustomLabelHeader("Kontaktinformasjon"));
        
        gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(15, 0, 0, 5);
        gbc3.ipadx = 2;
        gbc3.ipady = 5;
        gbc3.anchor = GridBagConstraints.LINE_END;
        
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        wiTab.add(new CustomLabel("Fornavn: "), gbc3);
        
        gbc3.gridy++;
        wiTab.add(new CustomLabel("Etternavn: "), gbc3);
        
        gbc3.gridy++;
        wiTab.add(new CustomLabel("Adresse: "), gbc3);
        
        gbc3.gridy++;
        wiTab.add(new CustomLabel("Poststed: "), gbc3);
        
        gbc3.gridy++;
        wiTab.add(new CustomLabel("Postnummer: "), gbc3);
        
        gbc3.gridy++;
        wiTab.add(new CustomLabel("Telefonnummer: "), gbc3);
        
  
        
        
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.anchor = GridBagConstraints.LINE_START;
        wiTab.add(vitneFornavn, gbc3);
        
        gbc3.gridy++;
        wiTab.add(vitneEtternavn, gbc3);
        
        gbc3.gridy++;
        wiTab.add(vitneAdresse, gbc3);
        
        gbc3.gridy++;
        wiTab.add(vitneBy, gbc3);
        
        gbc3.gridy++;
        wiTab.add(vitnePnr, gbc3);
        
        gbc3.gridy++;
        wiTab.add(vitneTlf, gbc3);
        
        gbc3.gridy++;
        wiTab.add(endreVitne, gbc3);
        
        //Adding tabs
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Informasjon</body></html>", txtTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Opplastninger</body></html>", ulTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Vitner</body></html>", wiTab);
    
    }
    
    /**
     * Sets the date the damage report was registered in the date-field
     * @param d date
     */
    public void setDate(String d) {
        date.setText(d);
    }

    /**
     * Sets the damage value estimation in the damage value-field
     * @param d damage value in NOK
     */
    public void setEstimation(String d) {
        estimation.setText(d);
    }

    /**
     * Sets the amount the customer was paid in the paid-field
     * @param p paid amount in NOK
     */
    public void setPaid(String p) {
        paid.setText(p);
    }

    /**
     * Sets the type of damage in the damage type-field
     * @param t damage type
     */
    public void setType(String t) {
        type.setText(t);
    }
    
    /**
     * Sets the damage descripton in the description-field
     * @param d damage description
     */
    public void setDescription(String d) {
        description.setText(d);
    }
    
    

    public void setVitneFornavn(String vf) {
        vitneFornavn.setText(vf);
    }

    public void setVitneEtternavn(String ve) {
        vitneEtternavn.setText(ve);
    }

    public void setVitneAdresse(String va) {
        vitneAdresse.setText(va);
    }

    public void setVitneBy(String vb) {
        vitneBy.setText(vb);
    }

    public void setVitnePnr(String vp) {
        vitnePnr.setText(vp);
    }

    public void setVitneTlf(String vt) {
        vitneTlf.setText(vt);
    }

    

    
    
    /**
     * Method that makes damage report-fields editable and saves changes
     */
    public void endreInfo()
    {
        if(!edit) {
            date.setEditable(true);
 
            description.setEditable(true);
            estimation.setEditable(true);
            paid.setEditable(true);

            changeInfo.setText("Lagre");
            
            edit = true;
        }
        else {
            String d = date.getText();
            String t = type.getText();
            String bes = description.getText();
            String ps = estimation.getText();
            String pn = paid.getText();
            
            //controller.endre(f, e, a, ps, pn);

            date.setEditable(false);
            description.setEditable(false);
            estimation.setEditable(false);
            paid.setEditable(false);
            
            changeInfo.setText("Endre");
            
            edit = false;
        }
    }
    
    
    /**
     * Method that makes witness fields editable and saves changes
     */
    public void endreVitne()
    {
        if(!edit2) {
            vitneFornavn.setEditable(true);
            vitneEtternavn.setEditable(true);
            vitneAdresse.setEditable(true);
            vitneBy.setEditable(true);
            vitnePnr.setEditable(true);
            vitneTlf.setEditable(true);
            
            endreVitne.setText("Lagre");
            edit2 = true;
        }
        else {
            
            String fnavn = vitneFornavn.getText();
            String enavn = vitneEtternavn.getText();
            String adresse = vitneAdresse.getText();
            String by = vitneBy.getText();
            String pnr = vitnePnr.getText();
            String tlf = vitneTlf.getText();
            
            vitneFornavn.setEditable(false);
            vitneEtternavn.setEditable(false);
            vitneAdresse.setEditable(false);
            vitneBy.setEditable(false);
            vitnePnr.setEditable(false);
            vitneTlf.setEditable(false);
            
            endreVitne.setText("Endre");
            edit2 = false;
        }
    }
 

    public boolean addController(ReportController c) {
        this.controller = c;
        return true;
    }
}