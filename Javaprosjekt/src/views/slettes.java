/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
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
 *
 * @author Audun

public class InsuranceView extends CustomPanel {
    
    private CustomPanel defaultIns;
    private CustomTextField date, customer, price, coverage, other;
    private JScrollPane cScroll;
    private CustomTextArea conditions;
    private GridBagConstraints gbc;
    
    public InsuranceView()
    {
        
        this.setLayout(new GridBagLayout());

        date = new CustomTextField(10);
        date.setEditable(false);
        customer = new CustomTextField(20);
        customer.setEditable(false);
        price = new CustomTextField(10);
        price.setEditable(false);
        coverage = new CustomTextField(10);
        coverage.setEditable(false);
        other = new CustomTextField(20);
        other.setEditable(false);
        
        conditions = new CustomTextArea(10, 20);
        conditions.setEditable(false);
        cScroll = new JScrollPane(conditions);

        
        //GridBagConstraint for default insurance panel
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
    
    

    public void setDate(String d) {
        date.setText(d);
    }

    public void setCustomer(String cus) {
        customer.setText(cus);
    }

    public void setPrice(String p) {
        price.setText(p);
    }

    public void setCoverage(String c) {
        coverage.setText(c);
    }

    public void setOther(String o) {
        other.setText(o);
    }

    public void setConditions(String cond) {
        conditions.setText(cond);
    }
}
*/