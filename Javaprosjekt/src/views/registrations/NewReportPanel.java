/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
import CustomSwing.CustomTextField;
import CustomSwing.CustomLabel;
import CustomSwing.CustomLabelHeader;
import CustomSwing.CustomPanel;
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
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NewReportPanel extends JTabbedPane {
    
    private CustomTextField date, estimation, paid, mPath,
            vitneFornavn, vitneEtternavn, vitneAdresse, vitneBy, vitnePnr, vitneTlf;
    private JFileChooser imageChooser, fileChooser;
    private JTextArea description, links;
    private JScrollPane bScroll, fcScroll;
    private GridBagConstraints gbc, gbc2, gbc3;
    private CustomButton submit;
    private CustomButton2 bButton, sButton;
    private CustomPanel txtTab, ulTab, wiTab;
    private JComboBox<String> type;
    private ReportController controller;
    
    
    /**
     * Initializes the GUI components
    */
    public void initComponents()
    {
        txtTab = new CustomPanel();
        txtTab.setLayout(new GridBagLayout());
        ulTab = new CustomPanel();
        ulTab.setLayout(new GridBagLayout());
        wiTab = new CustomPanel();
        wiTab.setLayout(new GridBagLayout());
        

        bButton = new CustomButton2("Last opp bilder");
        sButton = new CustomButton2("Last opp fil");
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> {});
        
        // Filechoosers settings ///////////////////////////////////////////////
        imageChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG / GIF / PNG", "jpg", "gif", "png");
        imageChooser.setFileFilter(filter);
        imageChooser.setMultiSelectionEnabled(true);
        imageChooser.setDialogTitle("Velg bilder");
        imageChooser.setApproveButtonText("Velg");
        
        bButton.addActionListener((e) -> { int returnVal = imageChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File[] f = imageChooser.getSelectedFiles();
                    saveImages(f);
                }});
        
        
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("PDF / JPG", "pdf", "jpg");
        fileChooser.setFileFilter(filter2);
        fileChooser.setMultiSelectionEnabled(false);
        
        sButton.addActionListener((e) -> { int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File f = fileChooser.getSelectedFile();
                    saveFile(f);
                }});
 
        
        description = new JTextArea(8, 22);
        bScroll = new JScrollPane(description);
        bScroll.setPreferredSize(description.getPreferredSize());

        String[] t = {"Velg type...", "Bil", "Hus/innbo", "Fritidshus", "B�t"};
        type = new JComboBox<>(t);
        type.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        
        date = new CustomTextField(10);
        estimation = new CustomTextField(6);
        paid = new CustomTextField(6);
        
        mPath = new CustomTextField(40);
        mPath.setBorder(BorderFactory.createTitledBorder(null, "Valgt fil"));
        mPath.setFont(new Font("Arial", Font.PLAIN, 10));
        mPath.setEditable(false);
        mPath.setBackground(Color.WHITE);
        
   
        links = new JTextArea(5, 40);
        links.setBorder(BorderFactory.createTitledBorder(null, "Valgte bilder"));
        links.setFont(new Font("Arial", Font.PLAIN, 10));
        links.setEditable(false);
        fcScroll = new JScrollPane(links);
        fcScroll.setPreferredSize(links.getPreferredSize());
        
        vitneFornavn = new CustomTextField(15);
        vitneEtternavn = new CustomTextField(15);
        vitneAdresse = new CustomTextField(20);
        vitneBy = new CustomTextField(15);
        vitnePnr = new CustomTextField(6);
        vitneTlf = new CustomTextField(10);
        
    }
    
    
    /**
     * NewReportPanel constructor
     */
    public NewReportPanel()
    {
        initComponents();
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
        gbc.gridy = 1;
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
        gbc.insets = new Insets(15, 0, 15, 5);
        txtTab.add(new CustomLabelHeader("Opprett ny skademelding"));
        
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
        gbc.insets = new Insets(15, 0, 22, 5);
        txtTab.add(submit, gbc);
        
        
   
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
        ulTab.add(bButton, gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.gridy++;
        gbc2.gridy++;
        gbc2.gridwidth = 2;
        ulTab.add(new CustomLabelHeader("Skademeldingsskjema"), gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_END;
        gbc2.gridy++;
        gbc2.gridwidth = 1;
        ulTab.add(sButton, gbc2);
       
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
        
        //Adding the tabs

        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Informasjon</body></html>", txtTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Opplastninger</body></html>", ulTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Vitner</body></html>", wiTab);
    }
    
    /**
     * Method that saves an array of images
     * @param f an array of images to be saved
     */
    public void saveImages(File[] f)
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
    
    /**
     * Method that saves a file
     * @param f file to be saved
     */
    public void saveFile(File f) 
    {
        File file = f;
        
        if(f != null)
            mPath.setText(f.getAbsolutePath());
    }


    /**
     * Returns the text the user has written in the damage description-field
     * @return damage description
     */
    public String getDescription() {
        return description.getText();
    }
    
    /**
     * Returns the text the user has written in the damage value estimation-field
     * @return the value estimation of the damage
     */
    public String getEstimation() {
        return estimation.getText();
    }
    
    /**
     * Returns the text the user has written in the paid-field
     * @return the amount the customer got from the insurance company for the damage
     */
    public String getPaid() {
        return paid.getText();
    }

    /**
     * 
     * @param c Report Controller
     * @return HOPPASALASIMIMA IMSDF M
     */
    public boolean addController(ReportController c) {
        this.controller = c;
        return true;
    }
}