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
    private GridBagConstraints gbc, gbc2, gbcRep;
    private CustomTextField customerSrcField, reportSrcField, reportDate1, reportDate2;
    private CustomButton cusSrc, insSrc, repSrc;
    private JCheckBox showInactiveCustomers;
    private JComboBox<String> insType, repType;
    
    public AdvancedSearchPanel()
    {
        this.setLayout(new GridBagLayout());
        
        
        
        
        //Customer search tab/////////////////////////////////////////////////
        customerSrc = new CustomPanel();
        customerSrc.setLayout(new GridBagLayout());
        customerSrc.setPreferredSize(new Dimension(800, 200));
        
        cusSrc = new CustomButton("Kundesøk-");
        cusSrc.addActionListener((e) -> customerSearch());
        
        customerSrcField = new CustomTextField(22);
        showInactiveCustomers = new JCheckBox();
        
        String[] t = {"Velg forsikringstype", "Bilforsikring", "Båtforsikring", "Hus- og innboforsikring", "Fritidshusforsikring", "Reiseforsikring"};
        insType = new JComboBox<>(t);
        
        gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.LINE_END;
        gbc2.insets = new Insets(10, 5, 10, 5);
        gbc2.ipadx = 2;
        gbc2.ipady = 3;
        
        
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        customerSrc.add(new CustomLabel("Kundenavn / -nummer: "), gbc2);
        gbc2.gridy++;
        customerSrc.add(new CustomLabel("Vis kunder med en gitt forsikringsstype: "), gbc2);
        
        
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.gridx = 1;
        gbc2.gridy = 0;
        customerSrc.add(customerSrcField, gbc2);

        gbc2.gridy++;
        customerSrc.add(insType, gbc2);
        
        gbc2.gridx = 2;
        gbc2.gridy = 0;
        customerSrc.add(new CustomLabel("Vis inaktive kunder: "), gbc2);
        
        gbc2.gridx++;
        customerSrc.add(showInactiveCustomers, gbc2);
        
        gbc2.gridx = 2;
        gbc2.gridy = 2;
        customerSrc.add(cusSrc, gbc2);
        
        
        
        //Insurance search tab/////////////////////////////////////////////////

        insuranceSrc = new CustomPanel();
        
        
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
        reportSrc.add(new CustomLabel(" og "), gbcRep);
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
        
        
        tabs.add("Kundesøk", customerSrc);
        tabs.add("Forsikringssøk", insuranceSrc);
        tabs.add("Skademeldingsøk", reportSrc);
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
        this.add(tabs, gbc);
        
        gbc.gridy++;
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