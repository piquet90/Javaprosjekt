/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.*;
import controllers.Controller;
import controllers.NewInsuranceController;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JComboBox;

/**
 *
 * @author Audun
 */

public class NewInsurancePanel extends CustomPanel implements View {
    
    private CardLayout cl;
    private JComboBox<String> insType;
    private GridBagConstraints g;
    private String insuranceType;
    private CustomPanel container, panelBlank;
    
    private NewCarInsurance bil;
    private NewBoatInsurance boat;
    private InsurancePanel ip;
    private NewHouseInsurance house;
    private NewLeisureHouseInsurance leisureHouse;
    private NewTravelInsurance travel;
    
    private NewInsuranceController controller;
    
    public void initComponents() {
        
        setLayout(new GridBagLayout());
        cl = new CardLayout();
        
        ip = new InsurancePanel();
        ip.initComponents();
        
        bil = new NewCarInsurance();
        bil.initComponents();
        
        boat = new NewBoatInsurance();
        boat.initComponents();
        
        house = new NewHouseInsurance();
        house.initComponents();
        
        leisureHouse = new NewLeisureHouseInsurance();
        leisureHouse.initComponents();
        
        travel = new NewTravelInsurance();

        String[] t = {"Velg type forsikring...", "Bilforsikring", "Båtforsikring", "Hus- og innboforsikring", "Fritidsboligforsikring", "Reiseforsikring"}; 
        insType = new JComboBox<>(t);
        insType.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
        insType.setBackground(new Color(250, 250, 250));
        
        container = new CustomPanel();
        container.setLayout(cl);
        
        panelBlank = new CustomPanel();
        
        container.add(panelBlank, "0");
        container.add(bil, "1");
        container.add(boat, "2");
        container.add(house, "3");
        container.add(leisureHouse, "4");
        container.add(travel, "5");
        
        //Startpanel 0 = panelBlank
        cl.show(container, "0");
        
        g = new GridBagConstraints();
        g.insets = new Insets(15, 0, 0, 5);
        g.ipadx = 2;
        g.ipady = 5;
        
        g.anchor = GridBagConstraints.LINE_START;
        
        g.gridx = 0;
        g.gridy = 0;
        g.weighty = 0.5;
        add(new CustomLabelHeader("Opprette ny forsikring"), g);
        
        g.gridy++;
        g.gridwidth = 2;
        add(ip, g);
        
        g.gridy++;
        g.gridwidth = 1;
        add(new CustomLabel("Forsikringstype: "), g);
        
        g.gridy++;
        g.gridwidth = 2;
        add(container, g);
        
        g.gridx = 1;
        g.gridy = 2;
        g.ipadx = 5;
        g.ipady = 10;
        g.gridwidth = 1;
        add(insType, g);
                
        insType.addActionListener((e)->{
        int n = insType.getSelectedIndex();
                String s = String.valueOf(n);
                cl.show(container, s);
        insuranceType = insType.getItemAt(n);});
                
    }
    
    public NewInsurancePanel() {
        
    }
    
    public String getInsuranceType() {
        return insuranceType;
    }
    
    public String getTravelInsuranceArea()
    {
        return travel.getArea();
    }

    @Override
    public boolean addController(Controller c) {
        if(c instanceof NewInsuranceController)
        {
            this.controller = (NewInsuranceController) c;
            return true;
        }
        return false;
    }
}
