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
import controllers.Controller;
import controllers.NewCustomerController;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JScrollPane;

/**
 *
 * @author Audun
 */

public class InsurancePanel extends CustomPanel implements View {
    
    private CustomTextField date, customer, price, coverage, other;
    private JScrollPane cScroll;
    private CustomTextArea conditions;
    private GridBagConstraints gbc;
    private NewCustomerController controller;
    
    /**
     * Initializes the GUI components
     */

    public void initComponents() {
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
        //_______________________
        
        setLayout(new GridBagLayout());
        setSize(getPreferredSize());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
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
    /**
     * NyBilforsikring constructor
     */
    public InsurancePanel() {
        
    }

    @Override
    public boolean addController(Controller c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
