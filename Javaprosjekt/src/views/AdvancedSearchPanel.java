/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;


import CustomSwing.CustomButton;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author Audun
 */
public class AdvancedSearchPanel extends CustomPanel {
    
    private JTabbedPane tabs;
    private CustomPanel customerSrc, insuranceSrc, reportSrc;
    private JTextArea resultInfo;
    private GridBagConstraints gbc, gbcCus, gbcRep, gbcIns;
    private CustomTextField customerSrcField, reportSrcField, insuranceSrcField, reportDate1, reportDate2, insDate1, insDate2;
    private CustomButton srcBtn, clrBtn;
    private JCheckBox showInactiveCustomers;
    private JComboBox<String> insType, repType;
    private SimpleDateFormat sdf;
    
    /**
     * Method that initalizes the GUI components
     */
    public void initComponents()
    {
        sdf = new SimpleDateFormat("dd.MM.yyyy");
        customerSrcField = new CustomTextField(22);
        showInactiveCustomers = new JCheckBox();
        
        String[] t = {"Velg forsikringstype", "Bilforsikring", "Båtforsikring", "Hus- og innboforsikring", "Fritidshusforsikring", "Reiseforsikring"};
        insType = new JComboBox<>(t);
        
        insuranceSrcField = new CustomTextField(5);
        insDate1 = new CustomTextField(8);
        insDate2 = new CustomTextField(8);
        
        reportSrcField = new CustomTextField(5);
        reportDate1 = new CustomTextField(8);
        reportDate2 = new CustomTextField(8);
        
        String[] r = {"Velg skadetype", "Bilskade", "Båtskade", "Hus-/ innboskade", "Fritidshusskade", "Reiseskade"};
        repType = new JComboBox<>(r);
        
        resultInfo = new JTextArea(2, 50);
        resultInfo.setEditable(false);
        resultInfo.setBackground(null);
        resultInfo.setFont(new Font("Arial", Font.PLAIN, 12));
        
        srcBtn = new CustomButton("Søk");
        srcBtn.addActionListener((e) -> customerSearch());
        clrBtn = new CustomButton("Nullstill felter");
        clrBtn.addActionListener((e) -> clearFields());
    }
    
    
    /**
     * AdvancedSearchPanels constructor
     */
    public AdvancedSearchPanel()
    {
        initComponents();
        setLayout(new GridBagLayout());
        
 
        //Customer search tab/////////////////////////////////////////////////
        customerSrc = new CustomPanel();
        customerSrc.setLayout(new GridBagLayout());
        customerSrc.setPreferredSize(new Dimension(800, 200));
   
        gbcCus = new GridBagConstraints();
        gbcCus.anchor = GridBagConstraints.LINE_END;
        gbcCus.insets = new Insets(10, 5, 10, 5);
        gbcCus.ipadx = 2;
        gbcCus.ipady = 3;
        
        gbcCus.gridx = 0;
        gbcCus.gridy = 0;
        customerSrc.add(new CustomLabel("Kundenavn / -nummer: "), gbcCus);
        
        gbcCus.gridy++;
        customerSrc.add(new CustomLabel("Vis inaktive kunder: "), gbcCus);
        
        gbcCus.gridy++;
        customerSrc.add(new CustomLabel("Vis kunder med en gitt forsikringstype: "), gbcCus);
        

        gbcCus.anchor = GridBagConstraints.LINE_START;
        gbcCus.gridx = 1;
        gbcCus.gridy = 0;
        customerSrc.add(customerSrcField, gbcCus);
        
        gbcCus.gridy++;
        customerSrc.add(showInactiveCustomers, gbcCus);

        gbcCus.gridy++;
        customerSrc.add(insType, gbcCus);

        
        
        //Insurance search tab/////////////////////////////////////////////////

        insuranceSrc = new CustomPanel();
        insuranceSrc.setLayout(new GridBagLayout());
        
        gbcIns = new GridBagConstraints();
        gbcIns.anchor = GridBagConstraints.LINE_END;
        gbcIns.insets = new Insets(10, 5, 10, 5);
        gbcIns.ipadx = 2;
        gbcIns.ipady = 3;
        
        gbcIns.gridx = 0;
        gbcIns.gridy = 0;
        insuranceSrc.add(new CustomLabel("Søk med forsikringsnummer: "), gbcIns);
        
        gbcIns.gridy++;
        insuranceSrc.add(new CustomLabel("Vis forsikringer registrert i perioden: "), gbcIns);
        
        gbcIns.anchor = GridBagConstraints.LINE_START;
        gbcIns.gridx = 1;
        gbcIns.gridy = 0;
        insuranceSrc.add(insuranceSrcField, gbcIns);
        
        gbcIns.gridy++;
        insuranceSrc.add(insDate1, gbcIns);
        
        gbcIns.gridx++;
        insuranceSrc.add(new CustomLabel(" - "), gbcIns);
        
        gbcIns.gridx++;
        insuranceSrc.add(insDate2, gbcIns);
        
        
        //Report search tab////////////////////////////////////////////////////

        reportSrc = new CustomPanel();
        reportSrc.setLayout(new GridBagLayout());
        reportSrc.setPreferredSize(new Dimension(800, 200));
       
        gbcRep = new GridBagConstraints();
        gbcRep.anchor = GridBagConstraints.LINE_END;
        gbcRep.insets = new Insets(10, 5, 10, 5);
        gbcRep.ipadx = 2;
        gbcRep.ipady = 3;
        
        gbcRep.gridx = 0;
        gbcRep.gridy = 0;
        reportSrc.add(new CustomLabel("Søk med skadenummer: "), gbcRep);
        
        gbcRep.gridy++;
        reportSrc.add(new CustomLabel("Vis skader registrert i perioden: "), gbcRep);
        
        gbcRep.gridy++;
        reportSrc.add(new CustomLabel("Vis skader av en gitt type: "), gbcRep);
        
        
        gbcRep.gridx = 1;
        gbcRep.gridy = 0;
        gbcRep.anchor = GridBagConstraints.LINE_START;
        reportSrc.add(reportSrcField, gbcRep);
        
        gbcRep.gridy++;
        reportSrc.add(reportDate1, gbcRep);
        
        gbcRep.gridx++;
        reportSrc.add(new CustomLabel(" - "), gbcRep);
        
        gbcRep.gridx++;
        reportSrc.add(reportDate2, gbcRep);
        
        gbcRep.gridx = 1;
        gbcRep.gridy++;
        reportSrc.add(repType, gbcRep);
        
        
        //Initalizing the main panel
        
        tabs = new JTabbedPane();
        tabs.setFont(new Font("Arial", Font.BOLD, 18));

        tabs.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Kundesøk</body></html>", customerSrc);
        tabs.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Forsikringsøk</body></html>", insuranceSrc);
        tabs.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Skademeldingsøk</body></html>", reportSrc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(5, 10, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.weighty = 1;
        this.add(tabs, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.weighty = 0.5;
        this.add(srcBtn, gbc);
        
        gbc.gridx++;
        this.add(clrBtn, gbc);
        
        gbc.gridx = 0;     
        gbc.gridwidth = 2;
        gbc.gridy++;
        gbc.weighty = 1;
        this.add(resultInfo, gbc);
        
    }
    
    /**
     * Displays search results in resultInfo text area
     * @param src search word
     * @param n number of hits on search word
     */
    public void setResultInfo(String src, int n)
    {
        resultInfo.setText("Viser " + n + " treff på " + src);
    }
    
    
    /**
     * Method that finds the correct search criteria for a search
     */
    public void customerSearch()
    {
        
        int srcType = tabs.getSelectedIndex();
        
        if(srcType == 0)
        {
            System.out.println("Kundesøk");
            String src = customerSrcField.getText();
            int type = insType.getSelectedIndex();
            String t = insType.getItemAt(type);
            boolean in = showInactiveCustomers.isSelected();
            
            
            if(src.equals("") && type != 0)
            {
                //søk som viser alle kunder med en gitt type forsikring
                setResultInfo("søk etter kunder med forsikringstype " + t + "\nViser inaktive kunder: " + in, 1);
                
            }
            else if(!src.equals("") && type != 0)
            {
                //Søk som viser alle kunder med gitt type forsikring og som treffer på søkeord
                setResultInfo("søk etter kunde " + src + " med forsikringstype " + t + "\nViser inaktive kunder: " + in, 1);
            }
            else if(!src.equals("") && type == 0)
            {
                //vanlig søk der brukeren skriver inn søkeord i søkefeltet
                setResultInfo("søk etter kunde " + src + "\nViser inaktive kunder: " + in, 1);
                
            }
            else
            {
                //brukeren har ikke skrevet inn noe i søkefeltet og heller ikke valgt type
                setResultInfo("", 0);
   
            }
            
            
            
        }
        else if(srcType == 1)
        {
            System.out.println("Forsikringsøk");
            
            String src = insuranceSrcField.getText();
            boolean date = true;
            
            String d1 = insDate1.getText();
            String d2 = insDate2.getText();
            
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            
            try
            {
                startDate.setTime(sdf.parse(d1));
                endDate.setTime(sdf.parse(d2));
            }
            catch(ParseException pe)
            {
                date = false;
            }
            
            if(src.equals("") && date)
            {
                //viser resultater mellom start dato og slutt dato
                setResultInfo("søk etter forsikringer registrert mellom " + sdf.format(startDate.getTime())+ " og " + sdf.format(endDate.getTime()), 1);
                
            }
            else if(src.equals("") && !date)
            {
                //feil i dato eller ikke skrevet søkeord
                setResultInfo("", 0);
            }
            else
            {
                
                //viser resultater på søkeord
                setResultInfo("søk etter " + src, 1);
                
            }
            
        }
        else
        {
            System.out.println("Skademeldingsøk");
            
            int type = repType.getSelectedIndex();
            String t = repType.getItemAt(type);
            String src = reportSrcField.getText();
            boolean date = true;
            
            String d1 = reportDate1.getText();
            String d2 = reportDate2.getText();
            
            Calendar startDate = Calendar.getInstance();
            Calendar endDate = Calendar.getInstance();
            
            try
            {
                startDate.setTime(sdf.parse(d1));
                endDate.setTime(sdf.parse(d2));
            }
            catch(ParseException pe)
            {
                date = false;
            }
            
            
            if(type != 0 && !date)
            {
                //søk som viser skader med en gitt skadetype
                
                setResultInfo("søk etter skadetype " + t, 1);
                
            }
            else if(!src.equals(""))
            {
                //vanlig søk der brukeren skriver inn søkeord i søkefeltet
                
                setResultInfo(src, 1);
            }
            else if(type == 0 && date)
            {
                //Søk som viser alle skader registrert iløpet av innskrevet periode
                
                setResultInfo("søk etter skader registrert mellom " + sdf.format(startDate.getTime()) + " og " + sdf.format(endDate.getTime()), 1);
            }
            else if(type != 0 && date)
            {
                //Søk som viser alle skader av en gitt type som er registrert iløpet av innskrevet periode
                
                setResultInfo("søk etter skader registrert mellom " + sdf.format(startDate.getTime()) + " og " + sdf.format(endDate.getTime()) + " av type " + t, 1);
            }
            else
            {
                //brukeren har ikke skrevet inn noe i søkefeltet og heller ikke valgt type
                setResultInfo("", 0); 
            }
        }
    }

    /**
     * Method that clears all fields and combo-boxes when called
     */
    public void clearFields()
    {
        resultInfo.setText("");
        customerSrcField.setText("");
        reportSrcField.setText("");
        insuranceSrcField.setText("");
        reportDate1.setText("");
        reportDate2.setText("");
        insDate1.setText("");
        insDate2.setText("");
        insType.setSelectedIndex(0);
        repType.setSelectedIndex(0);
        showInactiveCustomers.setSelected(false);
    }

}