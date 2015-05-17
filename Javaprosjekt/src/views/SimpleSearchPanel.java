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
 * Panel for simple search
 * @author Audun
 */
public class SimpleSearchPanel extends CustomPanel {
    
    private GridBagConstraints gbc;
    private CustomTextField srcField;
    private JComboBox<String> srcType;
    private CustomButton srcBtn;
    private JCheckBox showInactive;
    
    
    /**
     * Method that initalizes the GUI components
     */
    public void initComponents()
    {
        srcField = new CustomTextField(20);
        srcField.setFont(new Font("Arial", Font.PLAIN, 22));
        String[] t = {"Velg s�ktype...", "Kunder", "Forsikringer", "Skademeldinger"};
        srcType = new JComboBox<>(t);
        srcType.setFont(new Font("Arial", Font.PLAIN, 18));
        
        srcBtn = new CustomButton("S�k");
        srcBtn.addActionListener((e) -> search());
        
        showInactive = new JCheckBox("Vis inaktive kunder");  
    }
    
    /**
     * SimpleSearchPanel constructor
     */
    public SimpleSearchPanel() 
    {
        initComponents();
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(25, 15, 25, 5);
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(new CustomLabel("S�keord: "), gbc);
        
        gbc.gridx++;
        add(srcField, gbc);
        
        gbc.gridx++;
        add(srcType, gbc);
        
        gbc.gridx++;
        gbc.insets = new Insets(0, 15, 0, 5);
        add(showInactive, gbc);
        
        gbc.gridx++;
        add(srcBtn, gbc);
    }
    
    /**
     * Method calls the controller and recieves the search results
     */
    public void search()
    {
        String type = String.valueOf(srcType.getSelectedItem());
        boolean i = showInactive.isSelected();
        
        if(!srcField.getText().equals(""))
        {
            System.out.println("S�kt etter: " + srcField.getText() + "\nType: " + type + "\nVise inaktive kunder: " + i);
        }
        else if(type.equals("Velg s�ktype..."))
        {
            showError("Velg s�ktype");
        }
        else 
        {
            showError("Vennligst fyll inn alle felter");
        }
    }
    
    /**
     * Method that recieves an error message and displays it to the user
     * @param error error message
     */
    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
