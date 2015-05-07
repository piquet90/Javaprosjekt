/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextArea;
import CustomSwing.CustomTextField;
import controllers.Controller;
import controllers.CustomerController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

/**
 *
 * @author Audun
 */

public class NewDefaultInsurancePanel extends CustomPanel {
    
    private CustomTextField date, customer, price, coverage, other;
    private JScrollPane cScroll;
    private CustomTextArea conditions;
    private GridBagConstraints gbc;
    private CustomerController controller;
    

    /**
     * NyBilforsikring constructor
     */
    public NewDefaultInsurancePanel() {
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        date = new CustomTextField(10);
        date.setEditable(false);
        customer = new CustomTextField(20);
        customer.setEditable(false);
        customer.setText("Satt til valgt kunde");
        price = new CustomTextField(10);
        coverage = new CustomTextField(10);
        other = new CustomTextField(20);
        
        conditions = new CustomTextArea(10, 20);
        cScroll = new JScrollPane(conditions);

        //få dato fra controller?
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar cal = Calendar.getInstance();
        date.setText(dateFormat.format(cal.getTime()));
        ///////////////////////////////////////////
        
        //GridBagConstraint init
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Dato: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Kunde: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Årlig premie: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Sum dekning: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Annet: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;   
        gbc.insets = new Insets(15, 0, 0, 5);
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(date, gbc);
        
        gbc.gridy++;
        add(customer, gbc);
        
        gbc.gridy++;
        add(price, gbc);
        
        gbc.gridy++;
        add(coverage, gbc);
        
        gbc.gridy++;
        add(cScroll, gbc);
        
        gbc.gridy++;
        add(other, gbc);
        
        gbc.gridy++;
        gbc.insets = new Insets(15, 0, 45, 5);
        add(new CustomLabel(""), gbc);
    }
    

    public String getCustomer() {
        return customer.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public String getCoverage() {
        return coverage.getText();
    }

    public String getOther() {
        return other.getText();
    }

    public String getConditions() {
        return conditions.getText();
    }
    
    
    public void showError(String s) {
        JOptionPane.showMessageDialog(this, s);
    }
}
