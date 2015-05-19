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
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * Statistics panel
 * @author Audun
 */
public class StatisticsView extends JTabbedPane {
    
    private GridBagConstraints gbcCus, gbcIns, gbcRep;
    private CustomPanel cusPanel, insPanel, repPanel;
    private CustomTextField amountCus, amountActiveCus, amountIns, amountRep, paidRep, premiumIncome;
    private JTextArea insurances;
    private JComboBox<String> damageType, insuranceType;
    
    /**
     * Initalizes the GUI components
     */
    public void initComponents()
    {
        cusPanel = new CustomPanel();
        cusPanel.setLayout(new GridBagLayout());
        insPanel = new CustomPanel();
        insPanel.setLayout(new GridBagLayout());
        repPanel = new CustomPanel();
        repPanel.setLayout(new GridBagLayout());
        
        amountCus = new CustomTextField(5);
        amountCus.setEditable(false);
        amountActiveCus = new CustomTextField(5);
        amountActiveCus.setEditable(false);
        amountIns = new CustomTextField(5);
        amountIns.setEditable(false);
        amountRep = new CustomTextField(5);
        amountRep.setEditable(false);
        
        premiumIncome = new CustomTextField(10);
        premiumIncome.setEditable(false);
        paidRep = new CustomTextField(10);
        paidRep.setEditable(false);
        
        insurances = new JTextArea(5, 25);
        insurances.setEditable(false);
        insurances.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
        
        String[] dType = {"Alle skader", "Bilskader", "Båtskader", "Hus- / innboskader", "Fritidsboligskader", "Reiseskader"};
        damageType = new JComboBox<>(dType);
        damageType.setFont(new Font("Arial", Font.PLAIN, 15));
        damageType.addActionListener((e) -> reportSearch());
        
        String[] iType = {"Alle forsikringer", "Bilforsikring", "Båtforsikring", "Hus- og innboforsikring", "Fritidsboligforsikring", "Reiseforsikring"};
        insuranceType = new JComboBox<>(iType);
        insuranceType.setFont(new Font("Arial", Font.PLAIN, 15));
        insuranceType.addActionListener((e) -> insuranceSearch());
    }
    
    
    /**
     * StatisticsView constructor
     */
    public StatisticsView()
    {
        initComponents();
        setFont(new Font("Arial", Font.BOLD, 18));
        
        //// Customer tab /////////////////////////////////////////////////////
        gbcCus = new GridBagConstraints();
        gbcCus.ipadx = 2;
        gbcCus.ipady = 2;
        gbcCus.anchor = GridBagConstraints.LINE_START;
        
        
        gbcCus.insets = new Insets(30, 15, 10, 15);
        gbcCus.gridx = 0;
        gbcCus.gridy = 0;
        cusPanel.add(new CustomLabelHeader("Kunder"), gbcCus);
        
        gbcCus.insets = new Insets(10, 15, 10, 15);
        gbcCus.gridy++;
        gbcCus.gridwidth = 2;
        cusPanel.add(new CustomLabel("Totalt antall registrerte kunder: "), gbcCus);
        
        gbcCus.gridx = 2;
        gbcCus.gridwidth = 1;
        cusPanel.add(amountCus, gbcCus);
        
        
        gbcCus.gridx++;
        cusPanel.add(new CustomLabel("Antall aktive: "), gbcCus);
        
        gbcCus.gridx++;
        gbcCus.gridwidth = 1;
        cusPanel.add(amountActiveCus, gbcCus);
        
        

        //// Insurance tab ////////////////////////////////////////////////////
        gbcIns = new GridBagConstraints();
        gbcIns.ipadx = 2;
        gbcIns.ipady = 2;
        gbcIns.anchor = GridBagConstraints.LINE_START;
        
        gbcIns.insets = new Insets(30, 15, 10, 15);
        gbcIns.gridy++;
        gbcIns.gridx = 0;
        insPanel.add(new CustomLabelHeader("Forsikringer"), gbcIns);
        
        gbcIns.insets = new Insets(10, 15, 10, 15);
        gbcIns.gridy++;
        gbcIns.gridwidth = 2;
        insPanel.add(new CustomLabel("Antall aktive forsikringer: "), gbcIns);
        
        gbcIns.gridx = 2;
        gbcIns.gridwidth = 1;
        insPanel.add(amountIns, gbcIns);
        
        gbcIns.gridy++;
        gbcIns.gridx = 0;
        gbcIns.gridwidth = 2;
        insPanel.add(new CustomLabel("Sum årlige forsikringspremieinntekter: "), gbcIns);
        
        gbcIns.gridx = 2;
        gbcIns.gridwidth = 1;
        insPanel.add(insuranceType, gbcIns);
        
        gbcIns.gridx++;
        insPanel.add(premiumIncome, gbcIns);
        
        gbcIns.gridx = 0;
        gbcIns.gridy++;
        gbcIns.gridwidth = 2;
        insPanel.add(new CustomLabel("Forsikringsoversikt: "), gbcIns);
        
        gbcIns.gridx = 2;
        gbcIns.gridwidth = 2;
        insPanel.add(insurances, gbcIns);
        
        

        //// Damage report tab ////////////////////////////////////////////////
        gbcRep = new GridBagConstraints();
        gbcRep.ipadx = 2;
        gbcRep.ipady = 2;
        gbcRep.anchor = GridBagConstraints.LINE_START;
        gbcRep.insets = new Insets(30, 15, 10, 15);
        
        gbcRep.gridy++;
        gbcRep.gridx = 0;
        repPanel.add(new CustomLabelHeader("Skademeldinger"), gbcRep);
        
        gbcRep.insets = new Insets(10, 15, 10, 15);
        gbcRep.gridy++;
        gbcRep.gridwidth = 2;
        repPanel.add(new CustomLabel("Antall skademeldinger: "), gbcRep);
        
        gbcRep.gridx = 2;
        gbcRep.gridwidth = 1;
        repPanel.add(amountRep, gbcRep);
        
        gbcRep.gridy++;
        gbcRep.gridx = 0;
        gbcRep.gridwidth = 2;
        repPanel.add(new CustomLabel("Sum årlig utbetalte skadeerstatninger: "), gbcRep);
        
        gbcRep.gridx = 2;
        gbcRep.gridwidth = 1;
        repPanel.add(damageType, gbcRep);
        
        gbcRep.gridx++;
        gbcRep.gridwidth = 2;
        repPanel.add(paidRep, gbcRep);
        

       
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Kunder</body></html>", cusPanel);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Forsikringer</body></html>", insPanel);
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Skademeldinger</body></html>", repPanel);
 
    }
    
    /**
     * Returns total paid for all of the selected report type
     */
    public void reportSearch()
    {
        int n = damageType.getSelectedIndex();
        String t = damageType.getItemAt(n);
        
        paidRep.setText(n + " " + t);
    }
    
    /**
     * Returns total premium income for all of the insurences of the selected insurance type
     */
    public void insuranceSearch()
    {
        int n = insuranceType.getSelectedIndex();
        String t = insuranceType.getItemAt(n);
        
        premiumIncome.setText(n + " " + t);
    }

    /**
     * Sets the total amount of registered customers in the total cusomter amount-field
     * @param ac amount of registered customers
     */
    public void setAmountCus(String ac) {
        amountCus.setText(ac);
    }
    
    /**
     * Sets the amount of active customers in the active customers amount-field
     * @param ac amount of active customers
     */
    public void setAmountActiveCus(String ac) {
        amountCus.setText(ac);
    }

    /**
     * Sets the amount of insurances the insurance amount-field
     * @param ai amount of registered insurances
     */
    public void setAmountIns(String ai) {
        amountIns.setText(ai);
    }

    /**
     * Sets the amount of damage reports the report amount-field
     * @param ar amount of damage reports
     */
    public void setAmountRep(String ar) {
        amountRep.setText(ar);
    }

    /**
     * Sets the yearly amount of paid damage reports the paid reports-field
     * @param p this years total paid damage reports in NOK
     */
    public void setPaidRep(String p) {
        paidRep.setText(p);
    }

    /**
     * Sets the yearly insurance premium income in the premium income-field
     * @param pi total yearly insurance premium income
     */
    public void setPremiumIncome(String pi) {
        premiumIncome.setText(pi);
    }

    /**
     * Sets the number of the different insurance types in descending order the insurances overview-field
     * @param car number of car insurances
     * @param boat number of boat insurances
     * @param house number of house insurances
     * @param lhouse number of leisure house insurances
     * @param travel number of travel insurances
     */
    public void setInsurances(int car, int boat, int house, int lhouse, int travel)
    {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(car);
        a.add(boat);
        a.add(house);
        a.add(lhouse);
        a.add(travel);
        
        Collections.sort(a, Collections.reverseOrder());
        
        String[] s = new String[a.size()];
        s[a.indexOf(car)] = "Bilforsikringer: " + car;
        s[a.indexOf(boat)] = "Båtforsikringer: " + boat;
        s[a.indexOf(house)] = "Hus- og innboforsikringer: " + house;
        s[a.indexOf(lhouse)] = "Fritidshus- og innboforsikringer: " + lhouse;
        s[a.indexOf(travel)] = "Reiseforsikringer: " + travel;
        
        
        String print = "";
        for(int i = 0; i < s.length; i++)
        {
            print += s[i];
            if(i != s.length-1)
                print += "\n";
        }
        
        insurances.setText(print);
    }  
}


    /*
    øking/minking av skademeldinger av en bestemt type innenfor en gitt tidsperiode
    øking/minking av erstatningskostnadene for en gitt skadetype innenfor en gitt tidsperiode
    */