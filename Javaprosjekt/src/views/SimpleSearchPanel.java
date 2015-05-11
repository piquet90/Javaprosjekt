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
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Audun
 */
public class SimpleSearchPanel extends CustomPanel {
    
    private GridBagConstraints gbc;
    private CustomTextField srcField;
    private JComboBox<String> srcType;
    private CustomButton srcBtn;
    private JCheckBox showInactive;
    
    
    public SimpleSearchPanel() 
    {
        initComponents();
    }
    
    /**
     * TODO: BUTTON GROUP WITH SIMPLE SEARCH OPTIONS
     */
    
    public void initComponents()
    {
        this.setLayout(new GridBagLayout());
        srcField = new CustomTextField(20);
        srcField.setFont(new Font("Arial", Font.PLAIN, 22));
        String[] t = {"Velg søktype...", "Kunder", "Forsikringer", "Skademeldinger"};
        srcType = new JComboBox<>(t);
        srcType.setFont(new Font("Arial", Font.PLAIN, 18));
        
        srcBtn = new CustomButton("Søk");
        srcBtn.addActionListener((e) -> search());
        
        showInactive = new JCheckBox("Vis inaktive kunder");
        
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(25, 15, 25, 5);
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        this.add(new CustomLabel("Søkeord: "), gbc);
        
        gbc.gridx++;
        this.add(srcField, gbc);
        
        gbc.gridx++;
        this.add(srcType, gbc);
        
        gbc.gridx++;
        gbc.insets = new Insets(0, 15, 0, 5);
        this.add(showInactive, gbc);
        
        gbc.gridx++;
        this.add(srcBtn, gbc);
        
    }
    
    public void search()
    {
        String type = String.valueOf(srcType.getSelectedItem());
        boolean i = showInactive.isSelected();
        
        if(!srcField.getText().equals(""))
        {
            System.out.println("Søkt etter: " + srcField.getText() + "\nType: " + type + "\nVise inaktive kunder: " + i);
        }
        else if(type.equals("Velg søktype..."))
        {
            JOptionPane.showMessageDialog(null, "velg søktyppe plz");
        }
        else 
        {
            JOptionPane.showMessageDialog(null, "fyll felter plz");
        }
        
        
        
    }
    
}
