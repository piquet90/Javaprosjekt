/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomTextField;
import CustomSwing.CustomLabel;
import CustomSwing.CustomLabelHeader;
import CustomSwing.CustomPanel;
import DAO.Constants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.CustomEvent;
import views.CustomListener;

/**
 * Panel for registering new customers
 * @author Audun
 */

public class NewCustomerPanel extends CustomPanel implements ActionListener {
    
    private CustomTextField firstName, lastName, adress, city, zip;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomListener listener;

    
    /**
     * Method that initalizes the GUI components
     */
    public void initComponents()
    {
        firstName = new CustomTextField(15);
        lastName = new CustomTextField(15);
        adress = new CustomTextField(20);
        city = new CustomTextField(15);
        zip = new CustomTextField(6);
        
        submit = new CustomButton("Registrer");
        submit.addActionListener(this);
    }
    
    /**
     * NyCustomerPanel constructor
     */
    public NewCustomerPanel()
    {
        initComponents();
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new CustomLabel("Fornavn: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Etternavn: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Postnummer: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Poststed: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 15, 5);
        add(new CustomLabelHeader("Registrer ny kunde"));
        
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(firstName, gbc);
        
        gbc.gridy++;
        add(lastName, gbc);
        
        gbc.gridy++;
        add(adress, gbc);
        
        gbc.gridy++;
        add(zip, gbc);
        
        gbc.gridy++;
        add(city, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
    }

    /**
     * Returns what the user has written in the first name-field
     * @return the customers first name
     */
    public String getFirstName() {
        return firstName.getText();
    }

    /**
     * Returns what the user has written in the last name-field
     * @return the customers last name
     */
    public String getLastName() {
        return lastName.getText();
    }

    /**
     * Returns what the user has written in the adress-field
     * @return the customers adress
     */
    public String getAdress() {
        return adress.getText();
    }

    /**
     * Returns what the user has written in the city-field
     * @return the customers current city
     */
    public String getCity() {
        return city.getText();
    }

    /**
     * Returns what the user has written in the zip-field
     * @return the customers zip number
     */
    public String getZip() {
        return zip.getText();
    }
    
    /**
     * Clears all fields
     */
    public void clearAll()
    {
        firstName.setText("");
        lastName.setText("");
        adress.setText("");
        city.setText("");
        zip.setText("");
    }
    
    /**
     * Method that recieves and displays an error message 
     * @param error error message from controller
     */
    public void showError(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }
    
    /**
     * NewCustomerPanels ActionListener
     * @param e ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submit)
        {
            listener.customActionPerformed(new CustomEvent(Constants.REGISTER_BUTTON_PRESSED, Constants.NEW_CUSTOMER));
        }
    }
    
    public void addCustomListener(CustomListener e)
    {
        this.listener = e;
    }
} // end of class