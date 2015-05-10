/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
/**
 *
 * @author Audun
 */

public class NewInsurancePanel extends CustomPanel{
    
    private GridBagConstraints g;
    private String insuranceType;
    private CustomPanel container;
    private String type;
    
    private NewCarInsurance bil;
    private NewBoatInsurance boat;
    private NewDefaultInsurancePanel defaultPanel;
    private NewHouseInsurance house;
    private NewLeisureHouseInsurance leisureHouse;
    private NewTravelInsurance travel;
    
    
    public NewInsurancePanel() {
        setLayout(new GridBagLayout());
        
        defaultPanel = new NewDefaultInsurancePanel();
        
        bil = new NewCarInsurance();
        
        boat = new NewBoatInsurance();
        
        house = new NewHouseInsurance();
        
        leisureHouse = new NewLeisureHouseInsurance();
        leisureHouse.initComponents();
        
        travel = new NewTravelInsurance();
        
        container = new CustomPanel();

        
        
        
        //GridBagConstraints init
        g = new GridBagConstraints();
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(15, 0, 0, 5);
        g.ipadx = 2;
        g.ipady = 5;
        
        //Components added to window
        g.gridx = 0;
        g.gridy = 0;
        g.weighty = 0.5;
        g.gridwidth = 2;
        add(new CustomLabelHeader("Opprette ny forsikring"), g);
        
        g.gridy++;
        g.weighty = 1;
        add(defaultPanel, g);
        
        ////////////////////
        
        g.anchor = GridBagConstraints.LINE_END;
        g.insets = new Insets(15, 70, 0, 5);
        
        g.gridx = 3;
        g.gridy = 0;
        g.weighty = 0.5;
        g.gridwidth = 1;
        add(new CustomLabel("under skal type-panelet legges"), g);
        
        g.gridx = 2;
        g.gridy++;
        g.gridwidth = 2;
        g.weighty = 1;
        add(container, g);    
        
    }
    
    public void setInsuranceType(String type) {
        this.type = type;
        //eksempel: 
        if(type.equals("Bilforsikring"))
            container.add(new NewCarInsurance());
    }
    
    public String getInsuranceType()
    {
        return type;
    }
    
    //testmetode
    public String getTravelInsuranceArea()
    {
        return travel.getArea();
    }
}
