/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package registrations;

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


public class ReportView extends JTabbedPane {
    
    private CustomTextField dato, taksering, utbetalt, type,
            vitneFornavn, vitneEtternavn, vitneAdresse, vitneBy, vitnePnr, vitneTlf;
    private CustomTextArea beskrivelse;
    private JScrollPane bScroll;
    private GridBagConstraints gbc, gbc2, gbc3;
    private CustomPanel txtTab, ulTab, wiTab;
    private CustomButton2 endreInfo, endreVitne;
    private ReportController controller;
    private boolean edit = false;
    private boolean edit2 = false;
    
    
    /**
     * Initializes the GUI components
    */
    public void initComponents()
    {
        this.setBackground(new Color(159, 196, 232));
        this.setFont(new Font("Arial", Font.BOLD, 18));
        
        // GUI Components
        
        txtTab = new CustomPanel();
        txtTab.setLayout(new GridBagLayout());
        ulTab = new CustomPanel();
        ulTab.setLayout(new GridBagLayout());
        wiTab = new CustomPanel();
        wiTab.setLayout(new GridBagLayout());
        
        endreInfo = new CustomButton2("Endre");
        endreInfo.addActionListener((e) -> endreInfo());
        
        endreVitne = new CustomButton2("Endre");
        endreVitne.addActionListener((e) -> endreVitne());
        
        
        
        

        
        // txtTab - tab for basic injury information ///////////////////////////
        beskrivelse = new CustomTextArea(8, 22);
        beskrivelse.setEditable(false);
        bScroll = new JScrollPane(beskrivelse);
        bScroll.setPreferredSize(beskrivelse.getPreferredSize());

        
        dato = new CustomTextField(10);
        dato.setEditable(false);
        type = new CustomTextField(10);
        type.setEditable(false);
        taksering = new CustomTextField(6);
        taksering.setEditable(false);
        utbetalt = new CustomTextField(6);
        utbetalt.setEditable(false);
        
        
        
        
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
        txtTab.add(dato, gbc);
        
        gbc.gridy++;
        txtTab.add(type, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 3;
        txtTab.add(bScroll, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        txtTab.add(taksering, gbc);
        
        gbc.gridy++;
        txtTab.add(utbetalt, gbc);
        
        gbc.gridy++;
        gbc.insets = new Insets(15, 0, 25, 5);
        txtTab.add(endreInfo, gbc);
        
        
        
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
        
        
        setFelter();
    }
    


    public String getBeskrivelse() {
        return beskrivelse.getText();
    }

    public String getTaksering() {
        return taksering.getText();
    }

    public String getUtbetalt() {
        return utbetalt.getText();
    }
    
    public void setFelter()
    {
        dato.setText("06.05.2015");
        type.setText("Bil");
        beskrivelse.setText("Beskrivelse av skaden");
        taksering.setText("68 000");
        utbetalt.setText("61 518");
        
        vitneFornavn.setText("Jørgen");
        vitneEtternavn.setText("Jørgensen");
        vitneAdresse.setText("Jørgenveien 12 jørgen");
        vitneBy.setText("Jørgem");
        vitnePnr.setText("11");
        vitneTlf.setText("22Jørgen");
    }
    
    public void endreInfo()
    {
        if(!edit) {
            dato.setEditable(true);
 
            beskrivelse.setEditable(true);
            taksering.setEditable(true);
            utbetalt.setEditable(true);

            endreInfo.setText("Lagre");
            
            edit = true;
        }
        else {
            String d = dato.getText();
            String t = type.getText();
            String bes = beskrivelse.getText();
            String ps = taksering.getText();
            String pn = utbetalt.getText();
            
            //controller.endre(f, e, a, ps, pn);

            dato.setEditable(false);
            beskrivelse.setEditable(false);
            taksering.setEditable(false);
            utbetalt.setEditable(false);
            
            endreInfo.setText("Endre");
            
            edit = false;
        }

        
    }
    
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
 
    

    
    public ReportView()
    {

    }

    public boolean addController(ReportController c) {
        this.controller = c;
        return true;
    }
}