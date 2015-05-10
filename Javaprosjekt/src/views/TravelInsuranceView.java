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
 *
 * @author Audun
 */
public class TravelInsuranceView extends CustomPanel {
    
    private CustomTextField insTaker, amount;
    private CustomTextArea valid;
    private JScrollPane scroll;
    private GridBagConstraints gbc;
    private boolean check = false;
    
    public TravelInsuranceView() {
        setLayout(new GridBagLayout());
        
        insTaker = new CustomTextField(15);
        insTaker.setEditable(false);
        amount = new CustomTextField(10);
        amount.setEditable(false);
        valid = new CustomTextArea(15, 15);
        valid.setEditable(false);
        scroll = new JScrollPane(valid);

        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new CustomLabel("Forsikringstaker: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Beløp: "), gbc);

        gbc.gridy++;
        add(new CustomLabel("Gyldig i: "), gbc);
        
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(insTaker, gbc);
        
        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(scroll, gbc);
        
        
    }

    public void setInsTaker(String i) {
        insTaker.setText(i);
    }

    public void setAmount(String a) {
        amount.setText(a);
    }

    public void setValid(String v) {
        valid.setText(v);
    }

}