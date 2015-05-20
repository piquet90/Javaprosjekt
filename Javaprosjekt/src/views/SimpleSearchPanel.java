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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Panel for simple search
 * @author Audun
 */
public class SimpleSearchPanel extends CustomPanel {
    
    private GridBagConstraints gbc;
    public CustomTextField srcField;
    private JComboBox<String> srcType;
    private CustomButton srcBtn;
    private JCheckBox showInactive;
    private CustomListener listener;
    
    
    /**
     * SimpleSearchPanel constructor
     */
    public SimpleSearchPanel() 
    {
        srcField = new CustomTextField(20);
        srcField.setFont(new Font("Arial", Font.PLAIN, 22));
        String[] t = {"Velg søktype...", "Kunder", "Forsikringer", "Skademeldinger"};
        srcType = new JComboBox<>(t);
        srcType.setFont(new Font("Arial", Font.PLAIN, 18));
        
        srcBtn = new CustomButton("Søk");
            srcBtn.addActionListener((e) -> listener.customActionPerformed(new CustomEvent(Constants.SEARCH_INSURANCES)));
        
        
        
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
            System.out.println("Søkt etter: " + srcField.getText() + "\nType: " + type + "\nVise inaktive kunder: " + i);
        }
        else if(type.equals("Velg søktype..."))
        {
            showError("Velg søktype");
        }
        else 
        {
            showError("Vennligst fyll inn alle felter");
        }
    }
    
    
    public int getSrcTest()
    {
        int i = Integer.parseInt(srcField.getText());
        return 8;
    }
    
    /**
     * Method that recieves an error message and displays it to the user
     * @param error error message
     */
    public void showError(String error) {
        JOptionPane.showMessageDialog(this, error, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    /**
     * NewCustomerPanels ActionListener
     * @param e ActionEvent
     */
    
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==srcBtn)
        {
            listener.customActionPerformed(new CustomEvent(Constants.SEARCH_INSURANCES));
        }
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
