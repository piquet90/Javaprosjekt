/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton3;
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
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewReportPanel extends JTabbedPane {
    
    private CustomTextField dato, taksering, utbetalt, mPath,
            vitneFornavn, vitneEtternavn, vitneAdresse, vitneBy, vitnePnr, vitneTlf;
    private JFileChooser bildeVelger, meldingVelger;
    private CustomTextArea beskrivelse, links;
    private JScrollPane bScroll, fcScroll;
    private GridBagConstraints gbc, gbc2, gbc3;
    private CustomButton submit;
    private CustomButton3 bKnapp, sKnapp;
    private CustomPanel txtTab, ulTab, wiTab;
    private JComboBox<String> type;
    private ReportController controller;
    
    
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
        

        bKnapp = new CustomButton3("Last opp bilder");
        sKnapp = new CustomButton3("Last opp fil");
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> {});
        
        // Filechoosers settings ///////////////////////////////////////////////
        bildeVelger = new JFileChooser("Velg bilde(r)");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG / GIF / PNG", "jpg", "gif", "png");
        bildeVelger.setFileFilter(filter);
        bildeVelger.setMultiSelectionEnabled(true);
        
        bKnapp.addActionListener((e) -> { int returnVal = bildeVelger.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File[] f = bildeVelger.getSelectedFiles();
                    lagreBilder(f);
                }});
        
        
        meldingVelger = new JFileChooser("Velg fil(");
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("PDF / JPG", "pdf", "jpg");
        meldingVelger.setFileFilter(filter2);
        meldingVelger.setMultiSelectionEnabled(false);
        
        sKnapp.addActionListener((e) -> { int returnVal = meldingVelger.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File f = meldingVelger.getSelectedFile();
                    lagreSkademelding(f);
                }});

        
        
        
        
        

        
        // txtTab - tab for basic injury information ///////////////////////////
        beskrivelse = new CustomTextArea(8, 22);
        bScroll = new JScrollPane(beskrivelse);
        bScroll.setPreferredSize(beskrivelse.getPreferredSize());

        String[] t = {"Velg type...", "Bil", "Hus/innbo", "Fritidshus", "Båt"};
        type = new JComboBox<>(t);
        
        dato = new CustomTextField(10);
        dato.setEditable(false);
        dato.setText("Mottar dato");
        taksering = new CustomTextField(6);
        utbetalt = new CustomTextField(6);
        
        
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        txtTab.add(new CustomLabel("Dato: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Type skade: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Beskrivelse: "), gbc);

        gbc.gridy++;
        txtTab.add(new CustomLabel("Taksering: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Utbetalt: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 5);
        txtTab.add(new CustomLabelHeader("Opprett ny skademelding"));
        
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
        txtTab.add(submit, gbc);
        
        
        
        
        // ulTab - tab for uploading images and injury report //////////////////
        
        mPath = new CustomTextField(40);
        mPath.setBorder(BorderFactory.createTitledBorder(null, "Valgt fil"));
        mPath.setFont(new Font("Arial", Font.PLAIN, 10));
        mPath.setEditable(false);
        mPath.setBackground(Color.WHITE);
        
   
        links = new CustomTextArea(5, 40);
        links.setBorder(BorderFactory.createTitledBorder(null, "Valgte bilder"));
        links.setFont(new Font("Arial", Font.PLAIN, 10));
        links.setEditable(false);
        fcScroll = new JScrollPane(links);
        fcScroll.setPreferredSize(links.getPreferredSize());
        
        
        
        
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
        ulTab.add(bKnapp, gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.gridy++;
        gbc2.gridy++;
        gbc2.gridwidth = 2;
        ulTab.add(new CustomLabelHeader("Skademeldingsskjema"), gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_END;
        gbc2.gridy++;
        gbc2.gridwidth = 1;
        ulTab.add(sKnapp, gbc2);
       
        gbc2.gridy = 1;
        gbc2.gridx++;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 2;
        ulTab.add(fcScroll, gbc2);
        
        gbc2.gridy = 4;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 2;
        gbc2.anchor = GridBagConstraints.LINE_START;
        ulTab.add(mPath, gbc2);

        
        
        // wiTab - tab for witness contact information /////////////////////////
        
        vitneFornavn = new CustomTextField(15);
        vitneEtternavn = new CustomTextField(15);
        vitneAdresse = new CustomTextField(20);
        vitneBy = new CustomTextField(15);
        vitnePnr = new CustomTextField(6);
        vitneTlf = new CustomTextField(10);
        
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
        
        //Adding tabs

        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Informasjon</body></html>", txtTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Opplastninger</body></html>", ulTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Vitner</body></html>", wiTab);
        
        
        
    }
    
    
    public void lagreBilder(File[] f)
    {
        File[] files = f;
        links.setText("");
        
        for(int i = 0; i < f.length; i++)
        {
            if(f[i] != null)
            {
                links.append(f[i].getAbsolutePath() + "\n");
            }
        }
    }
    
    public void lagreSkademelding(File f) 
    {
        File file = f;
        
        if(f != null)
            mPath.setText(f.getAbsolutePath());
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
 
    

    
    public NewReportPanel()
    {
        
    }

    public boolean addController(ReportController c) {
        this.controller = c;
        return true;
    }
}