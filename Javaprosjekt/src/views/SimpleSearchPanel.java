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
import DAO.Constants;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 * Panel for simple search
 * @author Audun
 */
public class SimpleSearchPanel extends CustomPanel {
    
    private GridBagConstraints gbc;
    private CustomTextField searchField;
    private CustomButton srcBtn, showAll;
    private JCheckBox showInactive;
    private CustomListener listener;
    
    
    /**
     * SimpleSearchPanel constructor
     */
    public SimpleSearchPanel() 
    {
        searchField = new CustomTextField(20);
        
        searchField.setFont(new Font("Arial", Font.PLAIN, 22));
        
        srcBtn = new CustomButton("Søk");
        showAll = new CustomButton("Vis alle kunder");
        
        
        showInactive = new JCheckBox("Vis inaktive kunder");  
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(25, 15, 25, 5);
        gbc.ipadx = 1;
        gbc.ipady = 1;
        gbc.weighty = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(new CustomLabel("Søkeord: "), gbc);
        
        gbc.gridx++;
        add(searchField, gbc);
        
        gbc.gridx++;
        gbc.insets = new Insets(0, 15, 0, 5);
        add(showInactive, gbc);
        
        gbc.gridx++;
        add(srcBtn, gbc);
        
        gbc.gridx++;
        add(showAll, gbc);
        
        
        srcBtn.addActionListener((e) -> {listener.customActionPerformed(new CustomEvent(Constants.SEARCH_CUSTOMER));});
        showAll.addActionListener((e) -> {listener.customActionPerformed(new CustomEvent(Constants.SHOW_ALL_CUSTOMERS));});
    }
    
    
    /**
     * Returns the search word
     * @return search word
     */
    public String getSearch()
    {
        return searchField.getText();
    }
    
    /**
     * Returns the statse of the show inactive-checkbox
     * @return true for checked, false for unchecked
     */
    public boolean showInactive()
    {
        return showInactive.isSelected();

    }
  
    
    /**
     * Method that recieves an error message and displays it to the user
     * @param error error message
     */
    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    /**
     * Method that connect controllers listener to the panel
     * @param l CustomListener
     */
    public void addCustomListener(CustomListener l)
    {
        this.listener = l;
    }
    
}
