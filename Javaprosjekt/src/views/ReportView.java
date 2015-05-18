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
import controllers.ReportController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * ReportView panel
 * @author Audun
 */
public class ReportView extends JTabbedPane {
    
    private CustomTextField reportNo, date, estimation, paid, type,
            witFn, witLn, witAdr, witCity, witZip, witPhone;
    private JTextArea description;
    private JScrollPane bScroll;
    private GridBagConstraints gbc, gbc2, gbc3;
    private CustomPanel txtTab, ulTab, wiTab, imgPanel;
    private CustomButton2 changeInfo, changeWitness;
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
        imgPanel = new CustomPanel();
        
        changeInfo = new CustomButton2("Endre");
        changeInfo.addActionListener((e) -> change());
        
        changeWitness = new CustomButton2("Endre");
        changeWitness.addActionListener((e) -> changeWitness());
        
        description = new JTextArea(8, 22);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        description.setFont(new Font("Arial", Font.PLAIN, 15));
        description.setEditable(false);
        bScroll = new JScrollPane(description);
        bScroll.setPreferredSize(description.getPreferredSize());

        reportNo = new CustomTextField(12);
        reportNo.setFont(new Font("Arial", Font.BOLD, 21));
        reportNo.setEditable(false);
        reportNo.setBorder(null);
        
        date = new CustomTextField(10);
        date.setEditable(false);
        type = new CustomTextField(10);
        type.setEditable(false);
        estimation = new CustomTextField(6);
        estimation.setEditable(false);
        paid = new CustomTextField(6);
        paid.setEditable(false);

        
        witFn = new CustomTextField(15);
        witLn = new CustomTextField(15);
        witAdr = new CustomTextField(20);
        witCity = new CustomTextField(15);
        witZip = new CustomTextField(6);
        witPhone = new CustomTextField(10);
        witFn.setEditable(false);
        witLn.setEditable(false);
        witAdr.setEditable(false);
        witCity.setEditable(false);
        witZip.setEditable(false);
        witPhone.setEditable(false);
    }
    
    
    /**
     * ReportViews constructor
    */
    public ReportView()
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
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 5, 0, 5);
        txtTab.add(reportNo, gbc);
        
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
        
        
        
        // ulTab - tab for images and injury report ///////////////////////////
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
        ulTab.add(new CustomLabel("en jtable med bilde-nr, bilde-url som ved dobbeltklikk kalles showImage()"), gbc2);
        
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
        wiTab.add(witFn, gbc3);
        
        gbc3.gridy++;
        wiTab.add(witLn, gbc3);
        
        gbc3.gridy++;
        wiTab.add(witAdr, gbc3);
        
        gbc3.gridy++;
        wiTab.add(witCity, gbc3);
        
        gbc3.gridy++;
        wiTab.add(witZip, gbc3);
        
        gbc3.gridy++;
        wiTab.add(witPhone, gbc3);
        
        gbc3.gridy++;
        wiTab.add(changeWitness, gbc3);
        
        //Adding tabs
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Informasjon</body></html>", txtTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Opplastninger</body></html>", ulTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Vitner</body></html>", wiTab);
    
    }
    
    /**
     * Sets the damage report number in the damage report field
     * @param no damage report number
     */
    public void setReportNo(int no) {
        reportNo.setText("Skademelding nr. " + no);
    }
    
    /**
     * Adds a JTable to imgPanel
     * @param p image table
     */
    public void addImgPanel(ViewTable p)
    {
        imgPanel.add(new JScrollPane(p));
    }
    
    /**
     * Displays the image received in a dialog and its name as dialog title
     * @param icon image to be displayed
     * @param imgName the image name
     */
    public void showImage(ImageIcon icon, String imgName) {
        
        //icon = new ImageIcon(getClass().getResource("/resources/evil_logo.png"));
        //imgName = "evil_logo.png";

        JOptionPane.showMessageDialog(null, icon, imgName, JOptionPane.PLAIN_MESSAGE);
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
    
    /**
     * Sets witness first name in the witness first name-field
     * @param wfn witness first name
     */
    public void setWitFn(String wfn) {
        witFn.setText(wfn);
    }

    /**
     * Sets witness last name in the witness last name-field
     * @param wln witness last name
     */
    public void setWitLn(String wln) {
        witLn.setText(wln);
    }

    /**
     * Sets witness adress in the witness adress-field
     * @param wa 
     */
    public void setWitAdr(String wa) {
        witAdr.setText(wa);
    }

    /**
     * Sets witness city in the witness city-field
     * @param wc witness city
     */
    public void setWitCity(String wc) {
        witCity.setText(wc);
    }

    /**
     * Sets witness zip code in the witness zip-field
     * @param wz witness zip code
     */
    public void setWitZip(String wz) {
        witZip.setText(wz);
    }

    /**
     * Sets witness phone number in the witness phone number-field
     * @param wp witness phonenumber
     */
    public void setWitPhone(String wp) {
        witPhone.setText(wp);
    }

    

    /**
     * Makes damage report-fields editable and saves changes
     */
    public void change()
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

            date.setEditable(false);
            description.setEditable(false);
            estimation.setEditable(false);
            paid.setEditable(false);
            
            changeInfo.setText("Endre");
            
            edit = false;
        }
    }
    
    
    /**
     * Makes witness fields editable and saves changes
     */
    public void changeWitness()
    {
        if(!edit2) {
            witFn.setEditable(true);
            witLn.setEditable(true);
            witAdr.setEditable(true);
            witCity.setEditable(true);
            witZip.setEditable(true);
            witPhone.setEditable(true);
            
            changeWitness.setText("Lagre");
            edit2 = true;
        }
        else {
            
            String fnavn = witFn.getText();
            String enavn = witLn.getText();
            String adresse = witAdr.getText();
            String by = witCity.getText();
            String pnr = witZip.getText();
            String tlf = witPhone.getText();
            
            witFn.setEditable(false);
            witLn.setEditable(false);
            witAdr.setEditable(false);
            witCity.setEditable(false);
            witZip.setEditable(false);
            witPhone.setEditable(false);
            
            changeWitness.setText("Endre");
            edit2 = false;
        }
    }
 

    /**
     * Sets controller
     * @param c Report controller
     * @return true when its set
     */
    public boolean addController(ReportController c) {
        this.controller = c;
        return true;
    }
}