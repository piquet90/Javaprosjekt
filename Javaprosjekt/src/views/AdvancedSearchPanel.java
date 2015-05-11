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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
    
    public AdvancedSearchPanel()
    {
        this.setLayout(new GridBagLayout());
        
        
        
        
        //Customer search tab/////////////////////////////////////////////////
        customerSrc = new CustomPanel();
        customerSrc.setLayout(new GridBagLayout());
        customerSrc.setPreferredSize(new Dimension(800, 200));
        
        customerSrcField = new CustomTextField(22);
        showInactiveCustomers = new JCheckBox();
        
        String[] t = {"Velg forsikringstype", "Bilforsikring", "Båtforsikring", "Hus- og innboforsikring", "Fritidshusforsikring", "Reiseforsikring"};
        insType = new JComboBox<>(t);
        
        gbcCus = new GridBagConstraints();
        gbcCus.anchor = GridBagConstraints.LINE_END;
        gbcCus.insets = new Insets(10, 5, 10, 5);
        gbcCus.ipadx = 2;
        gbcCus.ipady = 3;
        
        
        gbcCus.gridx = 0;
        gbcCus.gridy = 0;
        customerSrc.add(new CustomLabel("Kundenavn / -nummer: "), gbcCus);
        gbcCus.gridy++;
        customerSrc.add(new CustomLabel("Vis kunder med en gitt forsikringsstype: "), gbcCus);
        
        
        gbcCus.anchor = GridBagConstraints.LINE_START;
        gbcCus.gridx = 1;
        gbcCus.gridy = 0;
        customerSrc.add(customerSrcField, gbcCus);

        gbcCus.gridy++;
        customerSrc.add(insType, gbcCus);
        
        gbcCus.gridx = 2;
        gbcCus.gridy = 0;
        customerSrc.add(new CustomLabel("Vis inaktive kunder: "), gbcCus);
        
        gbcCus.gridx++;
        customerSrc.add(showInactiveCustomers, gbcCus);
        
        
        
        
        //Insurance search tab/////////////////////////////////////////////////

        insuranceSrc = new CustomPanel();
        insuranceSrc.setLayout(new GridBagLayout());
        
        insuranceSrcField = new CustomTextField(5);
        insDate1 = new CustomTextField(8);
        insDate2 = new CustomTextField(8);
        
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
       
        reportSrcField = new CustomTextField(5);
        reportDate1 = new CustomTextField(8);
        reportDate2 = new CustomTextField(8);
        
        String[] r = {"Velg skadetype", "Bilskade", "Båtskade", "Hus-/ innboskade", "Fritidshusskade", "Reiseskade"};
        repType = new JComboBox<>(r);
        
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

        
        
        //panel init
        
        tabs = new JTabbedPane();
        resultInfo = new JTextArea(2, 50);
        resultInfo.setText("Fant 10 treff på søkeord");
        resultInfo.setEditable(false);
        
        srcBtn = new CustomButton("Søk");
        clrBtn = new CustomButton("Tøm felter");
        
        tabs.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Kundesøk</body></html>", customerSrc);
        tabs.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Forsikringssøk</body></html>", insuranceSrc);
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
    
    
    
    public void customerSearch()
    {
        String insuranceType = (String) insType.getSelectedItem();
        
    }
    
    public void insuranceSearch()
    {
        
        
    }
    
    public void reportSearch()
    {
        String reportType = (String) repType.getSelectedItem();
        
    }
    
    
}