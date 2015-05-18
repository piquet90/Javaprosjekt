/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomLabel;
import CustomSwing.CustomLabelHeader;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;

/**
 * Statistics panel
 * @author Audun
 */
public class StatisticsView extends CustomPanel {
    
    private GridBagConstraints gbc;
    private CustomTextField amountCus, amountIns, amountRep, paidRep, premiumIncome;
    private JComboBox<String> damageType, insuranceType;
    
    /**
     * Initalizes the GUI components
     */
    public void initComponents()
    {
        amountCus = new CustomTextField(5);
        amountIns = new CustomTextField(5);
        amountRep = new CustomTextField(5);
        
        premiumIncome = new CustomTextField(10);
        paidRep = new CustomTextField(10);
        
        String[] dType = {"Alle skader", "Bilskader", "Båtskader", "Hus- / innboskader", "Fritidsboligskader", "Reiseskader"};
        damageType = new JComboBox<>(dType);
        damageType.addActionListener((e) -> reportSearch());
        
        String[] iType = {"Alle forsikringer", "Bilforsikring", "Båtforsikring", "Hus- og innboforsikring", "Fritidsboligforsikring", "Reiseforsikring"};
        insuranceType = new JComboBox<>(iType);
        insuranceType.addActionListener((e) -> insuranceSearch());
    }
    
    /**
     * StatisticsView constructor
     */
    public StatisticsView()
    {
        initComponents();
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.ipadx = 2;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(10, 5, 10, 5);
        
        //// Kunder ////////////////////////////////////////////////////////////
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new CustomLabelHeader("Kunder"), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Antall aktive kunder: "), gbc);
        
        gbc.gridx++;
        add(amountCus, gbc);
        
        
        
        
        
        //// Forsikring ////////////////////////////////////////////////////////
        
        gbc.insets = new Insets(30, 5, 10, 5);
        gbc.gridy++;
        gbc.gridx = 0;
        add(new CustomLabelHeader("Forsikringer"), gbc);
        
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.gridy++;
        add(new CustomLabel("Antall forsikringer: "), gbc);
        
        gbc.gridx++;
        add(amountIns, gbc);
        
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(new CustomLabel("Sum årlige forsikringspremieinntekter: "), gbc);
        
        gbc.gridx = 2;
        gbc.gridwidth = 1;
        add(insuranceType, gbc);
        
        gbc.gridx++;
        add(premiumIncome, gbc);
        
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        
        
        
        
        //// Skademelding //////////////////////////////////////////////////////
        
        gbc.insets = new Insets(30, 5, 10, 5);
        gbc.gridy++;
        gbc.gridx = 0;
        add(new CustomLabelHeader("Skademeldinger"), gbc);
        
        gbc.insets = new Insets(10, 5, 10, 5);
        gbc.gridy++;
        add(new CustomLabel("Antall skademeldinger: "), gbc);
        
        gbc.gridx++;
        add(amountRep, gbc);
        
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        add(new CustomLabel("Sum årlig utbetalte skadeerstatninger: "), gbc);
        
        gbc.gridx++;
        gbc.gridx++;
        gbc.gridwidth = 1;
        add(damageType, gbc);
        
        gbc.gridx++;
        gbc.gridwidth = 2;
        add(paidRep, gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        
        gbc.gridy++;
        add(new CustomLabel("Sum utbetalte skademeldinger (i år): "), gbc);
        
        
  
    }
    
    
    public void reportSearch()
    {
        int n = damageType.getSelectedIndex();
        String t = damageType.getItemAt(n);
        
        System.out.println(n + " " + t);
    }
    
    public void insuranceSearch()
    {
        int n = insuranceType.getSelectedIndex();
        String t = insuranceType.getItemAt(n);
        
        System.out.println(n + " " + t);
    }
    
}


/*
    Inntekter og utgifter:
    
    
    
    
    
    selskapets forsikringspremieinntekter på en gitt forsikringskunde i løpet av kundeforholdet
    
    Statistikk:
    øking/minking av antall skademeldinger innenfor en gitt tidsperiode
    øking/minking av skademeldinger av en bestemt type innenfor en gitt tidsperiode
    øking/minking av de totale erstatningskostnadene
    øking/minking av erstatningskostnadene for en gitt skadetype innenfor en gitt tidsperiode
    type forsikringer rangert etter antall
    */