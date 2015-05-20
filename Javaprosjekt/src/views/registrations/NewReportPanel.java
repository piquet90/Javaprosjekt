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
import DAO.Constants;
import TableModels.ImageTable;
import TableModels.ReportTable;
import controllers.ReportController;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.File;
import java.util.HashSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import models.Report;
import views.CustomEvent;
import views.CustomListener;

/**
 * New report panel
 * @author Audun
 */

public class NewReportPanel extends JTabbedPane {
    
    private CustomTextField date, estimation, paid, insNumber, fileURL, type, witName1, witPhone1;
    private JFileChooser imageChooser, fileChooser;
    private JTextArea description, imageURL;
    private JScrollPane descriptionScroll, imageURLScroll;
    private GridBagConstraints gbc, gbc2, gbc3;
    private CustomButton submit;
    private CustomButton2 imagesButton, fileButton;
    private CustomPanel txtTab, ulTab, wiTab;
    private boolean edit = false;
    private boolean viewMode = false;
    private CustomListener listener;
    
  
    
    /**
     * NewReportPanel constructor
     */
    public NewReportPanel()
    {
        txtTab = new CustomPanel();
        txtTab.setLayout(new GridBagLayout());
        ulTab = new CustomPanel();
        ulTab.setLayout(new GridBagLayout());
        wiTab = new CustomPanel();
        wiTab.setLayout(new GridBagLayout());
        
        imagesButton = new CustomButton2("Last opp bilder");
        fileButton = new CustomButton2("Last opp fil");
        
        submit = new CustomButton("Registrer");
        submit.addActionListener((e) -> {change();});
        
        
        description = new JTextArea(8, 22);
        descriptionScroll = new JScrollPane(description);
        descriptionScroll.setPreferredSize(description.getPreferredSize());
        
        date = new CustomTextField(10);
        estimation = new CustomTextField(6);
        insNumber = new CustomTextField(5);
        paid = new CustomTextField(6);
        type = new CustomTextField(15);
        type.setEditable(false);
        
        witName1 = new CustomTextField(15);
        witPhone1 = new CustomTextField(10);
        
        // Filechoosers settings ///////////////////////////////////////////////
        imageChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG / GIF / PNG", "jpg", "gif", "png");
        imageChooser.setFileFilter(filter);
        imageChooser.setMultiSelectionEnabled(true);
        imageChooser.setDialogTitle("Velg bilder");
        imageChooser.setApproveButtonText("Velg");
        
        imagesButton.addActionListener((e) -> { int returnVal = imageChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File[] f = imageChooser.getSelectedFiles();
                    saveImages(f);
                }});
        
        
        fileChooser = new JFileChooser();
        FileNameExtensionFilter filter2 = new FileNameExtensionFilter("PDF / JPG", "pdf", "jpg");
        fileChooser.setFileFilter(filter2);
        fileChooser.setMultiSelectionEnabled(false);
        
        fileButton.addActionListener((e) -> { int returnVal = fileChooser.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File f = fileChooser.getSelectedFile();
                    saveFile(f);
                }});
        

        
        
        setBackground(new Color(159, 196, 232));
        setFont(new Font("Arial", Font.BOLD, 18));

        imageURL = new JTextArea(5, 40);
        imageURL.setBorder(BorderFactory.createTitledBorder(null, "Valgte bilder"));
        imageURL.setFont(new Font("Arial", Font.PLAIN, 10));
        imageURL.setEditable(false);
        imageURLScroll = new JScrollPane(imageURL);
        imageURLScroll.setPreferredSize(imageURL.getPreferredSize());
        
        fileURL = new CustomTextField(40);
        fileURL.setBorder(BorderFactory.createTitledBorder(null, "Valgt fil"));
        fileURL.setFont(new Font("Arial", Font.PLAIN, 10));
        fileURL.setEditable(false);
        fileURL.setBackground(Color.WHITE);
        
        
        
        
        // txtTab - tab for basic injury information ///////////////////////////
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        gbc.weighty = 1;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(15, 15, 0, 5);
        txtTab.add(new CustomLabelHeader("Opprett ny skademelding"), gbc);
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Hendelsesdato: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Forsikringsnr.: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Type skade: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Beskrivelse av skade: "), gbc);

        gbc.gridy++;
        txtTab.add(new CustomLabel("Taksering av skade: "), gbc);
        
        gbc.gridy++;
        txtTab.add(new CustomLabel("Utbetalt: "), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 55);
        gbc.anchor = GridBagConstraints.LINE_START;
        txtTab.add(date, gbc);
        
        gbc.gridy++;
        txtTab.add(insNumber, gbc);
        
        gbc.gridy++;
        txtTab.add(type, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 3;
        txtTab.add(descriptionScroll, gbc);
        
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
        gbc2.insets = new Insets(15, 15, 15, 5);
        gbc2.ipadx = 2;
        gbc2.ipady = 5;

        gbc2.gridx = 0;
        gbc2.gridy = 0;
        gbc2.anchor = GridBagConstraints.LINE_START;
        ulTab.add(new CustomLabelHeader("Bilder av skade"), gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_END;
        gbc2.gridy++;
        ulTab.add(imagesButton, gbc2);
        ulTab.add(new CustomLabel("LEGG TIL ET JTABLE HER"), gbc);
        
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.gridy++;
        gbc2.gridy++;
        gbc2.gridwidth = 2;
        ulTab.add(new CustomLabelHeader("Skademeldingsskjema"), gbc2);
        
        gbc2.anchor = GridBagConstraints.LINE_END;
        gbc2.gridy++;
        gbc2.gridwidth = 1;
        ulTab.add(fileButton, gbc2);
       
        gbc2.gridy = 1;
        gbc2.gridx++;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 2;
        ulTab.add(imageURLScroll, gbc2);
        
        gbc2.gridy = 4;
        gbc2.gridwidth = 2;
        gbc2.gridheight = 2;
        gbc2.anchor = GridBagConstraints.LINE_START;
        ulTab.add(fileURL, gbc2);

        
        
        // wiTab - tab for witness contact information /////////////////////////

        wiTab.add(new CustomLabelHeader("Kontaktinformasjon"));
        
        gbc3 = new GridBagConstraints();
        gbc3.insets = new Insets(15, 0, 0, 5);
        gbc3.ipadx = 2;
        gbc3.ipady = 5;
        gbc3.anchor = GridBagConstraints.LINE_END;
        
        gbc3.gridx = 0;
        gbc3.gridy = 1;
        wiTab.add(new CustomLabel("1. vitne, navn: "), gbc3);
        
        gbc3.gridy++;
        wiTab.add(new CustomLabel("1. vitne, telefonnummer: "), gbc3);        
        
        gbc3.gridx = 1;
        gbc3.gridy = 1;
        gbc3.anchor = GridBagConstraints.LINE_START;
        wiTab.add(witName1, gbc3);
        
        gbc3.gridy++;
        wiTab.add(witPhone1, gbc3);
        
        submit.addActionListener((e)->{listener.customActionPerformed(new CustomEvent(Constants.NEW_REPORT));});
        
        //Adding the tabs

        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Informasjon</body></html>", txtTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Opplastninger</body></html>", ulTab);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Vitner</body></html>", wiTab);
    }
    
    /**
     * Changes text-fields to uneditable if panel is used for viewing
     */
    public void setViewMode()
    {
        date.setEditable(false);
        estimation.setEditable(false);
        paid.setEditable(false);
        witName1.setEditable(false);
        witPhone1.setEditable(false);
        description.setEditable(false);
        insNumber.setEditable(false);
        
        imageURL.setVisible(false);
        imageURLScroll.setVisible(false);
        imageChooser.setVisible(false);
        fileChooser.setVisible(false);
        fileURL.setVisible(false);
        imagesButton.setVisible(false);
        fileButton.setVisible(false);
        
        submit.setText("Endre");
        
        viewMode = true;
    }
    
    /**
     * Returns whether or not the panel is in viewmode
     * @return boolean viewmode
     */
    public boolean isViewMode() {
        return viewMode;
    }

    /**
     * Sets the view mode
     * @param vm true or false
     */
    public void setViewMode(boolean vm) {
        viewMode = vm;
    }
    
    /**
     * Method that saves an array of images
     * @param f an array of images to be saved
     */
    public void saveImages(File[] f)
    {
        File[] files = f;
        
        imageURL.setText("");
        
        for (File f1 : f) {
            if (f1 != null) {
                imageURL.append(f1.getAbsolutePath() + "\n");
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
            fileURL.setText(f.getAbsolutePath());
    }

    /**
     * Returns insurance number
     * @return insurance number
     */
    public String getInsNumber() {
        return insNumber.getText();
    }
    
    /**
     * Sets the parent insurance number in the insurance number field
     * @param inr insurance number
     */
    public void setInsNumber(String inr) {
        insNumber.setText(inr);
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
     * Returns the injury report-type
     * @return injury type
     */
    public String getType() {
        return type.getText();
    }
    
    /**
     * Returns the first witness' name
     * @return witness name 
     */
    public String getWitName1()
    {
        return witName1.getText();
    }
    
    /**
     * Returns the first witness' telephone number
     * @return witness telephone number
     */
    public String getWitPhone1()
    {
        return witPhone1.getText();
    }
    
    
    /**
     * Sets the damage description in the description-field
     * @param s 
     */
    public void setDescription(String s) {
        description.setText(s);
    }
    
    /**
     * Sets the damage value estimation the estimation-field
     * @param e damage value estimation in NOK
     */
    public void setEstimation(String e) {
        estimation.setText(e);
    }
    
    /**
     * Sets the paid-amount in the paid-field
     * @param p amount paid for damage in NOK
     */
    public void setPaid(String p) {
        paid.setText(p);
    }
    
    /**
     * Sets the injury report type in the type-field
     * @param t injury report type
     */
    public void setType(String t) {
        type.setText(t);
    }
    
    /**
     * Sets the first witness' name in the first witness name text-field
     * @param wn witness name
     */
    public void setWitnessName1(String wn) {
        witName1.setText(wn);
    }
    
    /**
     * Sets the first witness' phone number in the first witness phone number text-field
     * @param wp witness phone number
     */
    public void setWitnessPhone1(String wp) {
        witName1.setText(wp);
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
    
<<<<<<< HEAD
    public String getDate()
    {
        return this.date.getText();
    }
    
    public void setDate(String s)
    {
        this.date.setText(s);
    }
    
=======
    
    public void clearFields()
    {
        date.setText("");
        estimation.setText("");
        paid.setText("");
        witName1.setText("");
        witPhone1.setText("");
    }
>>>>>>> 636cde6fa1cb467e18e34eb17a0a061669d3683a
  
    
    /**
     * Method makes textfields editable and passes the changed information to registry
     */
    public void change()
    {
        if(!edit) {
            estimation.setEditable(true);
            paid.setEditable(true);
            witName1.setEditable(true);
            witPhone1.setEditable(true);
            
            
            submit.setText("Lagre");
            
            edit = true;  
        }
        else {
            estimation.setEditable(false);
            paid.setEditable(false);
            witName1.setEditable(false);
            witPhone1.setEditable(false);
            
            
            
            submit.setText("Endre");
            
            edit = false;
        } 
    }
    
    public void addCustomListener(CustomListener l)
    {
        this.listener = l;
    }

  
}