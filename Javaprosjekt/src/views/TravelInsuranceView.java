/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextArea;
import CustomSwing.CustomTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JScrollPane;

/**
 * Panel for viewing a travel insurance
 * @author Audun
 */
public class TravelInsuranceView extends CustomPanel {
    
    private CustomTextField insTaker, amount, premium, conditions;
    private CustomTextArea valid;
    private JScrollPane scroll;
    private GridBagConstraints gbc;
    private boolean check = false;
    
    public void initComponents()
    {
        insTaker = new CustomTextField(15);
        insTaker.setEditable(false);
        amount = new CustomTextField(10);
        amount.setEditable(false);
        premium = new CustomTextField(10);
        premium.setEditable(false);
        conditions = new CustomTextField(15);
        conditions.setEditable(false);
        valid = new CustomTextArea(15, 15);
        valid.setEditable(false);
        scroll = new JScrollPane(valid);
    }
    /**
     * TravelInsuranceViews constructor
     */
    public TravelInsuranceView()
    {
        initComponents();
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new CustomLabel("Forsikringstaker: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringsbeløp: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringspremie: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);

        gbc.gridy++;
        add(new CustomLabel("Gyldig i: "), gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(insTaker, gbc);
        
        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(premium, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);
        
        gbc.gridy++;
        add(scroll, gbc);

    }

    /**
     * Method that sets a name in the insurance taker name-field
     * @param i insurance takers name
     */
    public void setInsTaker(String i) {
        insTaker.setText(i);
    }

    /**
     * Method that sets an amount in the insurance amount-field
     * @param a insurance amount in NOK
     */
    public void setAmount(String a) {
        amount.setText(a);
    }
    
    /**
     * Method that sets an amount in the yearly premium-field
     * @param p yearly premium in NOK
     */
    public void setPremium(String p) {
        premium.setText(p);
    }
    
    /**
     * Method that sets insurance conditions in the conditions-field
     * @param c insurance conditions
     */
    public void setConditions(String c) {
        conditions.setText(c);
    }

    /**
     * Method that sets the insurance valid continents in the valid-field
     * @param v valid continents
     */
    public void setValid(String v) {
        valid.setText(v);
    }

}