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


public class NewCustomerPanel extends CustomPanel implements ActionListener{
    
    private CustomTextField firstName, lastName, adress, city, zip;
    private GridBagConstraints gbc;
    private CustomButton submit;
    private CustomListener listener;

    
    /**
     * NyBrukerPanel constructor
     */
    public NewCustomerPanel()
    {
        firstName = new CustomTextField(15);
        lastName = new CustomTextField(15);
        adress = new CustomTextField(20);
        city = new CustomTextField(15);
        zip = new CustomTextField(6);
        
        submit = new CustomButton("Registrer");
        submit.addActionListener(this);
        
        this.setLayout(new GridBagLayout());
        this.setSize(getPreferredSize());
        
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

    public String getFirstName() {
        return firstName.getText();
    }

    public String getLastName() {
        return lastName.getText();
    }

    public String getAdress() {
        return adress.getText();
    }

    public String getCity() {
        return city.getText();
    }

    public String getZip() {
        return zip.getText();
    }
    
    public void clearAll()
    {
        firstName.setText("");
        lastName.setText("");
        adress.setText("");
        city.setText("");
        zip.setText("");
    }
    /**
     * 
     * @param error Recieves error message from controller and displays it to user
     */
    
    public void showError(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }
    

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