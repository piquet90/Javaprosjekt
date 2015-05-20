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
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 * Panel for simple search
 * @author Audun
 */
public class SimpleSearchPanel extends CustomPanel {
    
    private GridBagConstraints gbc;
    private CustomTextField searchField, test;
    private CustomButton srcBtn;
    private JCheckBox showInactive;
    private CustomListener listener;
    
    
    /**
     * SimpleSearchPanel constructor
     */
    public SimpleSearchPanel() 
    {
        searchField = new CustomTextField(20);
        
        test = new CustomTextField(5);
        
        searchField.setFont(new Font("Arial", Font.PLAIN, 22));
        
        srcBtn = new CustomButton("Søk");
        
        
        
        
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
        add(test, gbc);
        
        gbc.gridx++;
        gbc.insets = new Insets(0, 15, 0, 5);
        add(showInactive, gbc);
        
        gbc.gridx++;
        add(srcBtn, gbc);
        
        
        srcBtn.addActionListener((e) -> {listener.customActionPerformed(new CustomEvent(Constants.SEARCH_INSURANCE));});
    }
    
    /**
     * Method calls the controller and recieves the search results
     */
    public void search()
    {
        
        boolean i = showInactive.isSelected();
        
        if(!searchField.getText().equals(""))
        {
            System.out.println("Søkt etter: " + searchField.getText() + "\nVise inaktive kunder: " + i);
        }
        else 
        {
            showError("Vennligst fyll inn alle felter");
        }
    }
   
    
    public void setSearch()
    {
        searchField.setText("fffff");
    }
    
    public String getSearch()
    {
        return test.getText();
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
