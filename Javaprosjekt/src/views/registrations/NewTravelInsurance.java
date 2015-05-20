/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
import CustomSwing.CustomCheckBox;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import DAO.Constants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import views.CustomEvent;
import views.CustomListener;

/**
 * Panel for registering a travel insurance
 * @author Audun
 */
public class NewTravelInsurance extends CustomPanel {
    
    private CustomTextField insTaker, amount, premium, conditions, active;
    private JTextArea valid;
    private CustomPanel actions;
    private CustomCheckBox asia, africa, europe, nAmerica, sAmerica, oceania;
    private CustomButton2 delete, report;
    private CustomButton submit;
    private GridBagConstraints gbc, gbc2;
    private boolean viewMode = false;
    private boolean edit = false;
    private CustomListener listener;
    
    
    /**
     * NewTravelInsurance constructor
     */
    public NewTravelInsurance()
    {
        
        insTaker = new CustomTextField(16);
        premium = new CustomTextField(8);
        amount = new CustomTextField(8);
        conditions = new CustomTextField(15);
        
        asia = new CustomCheckBox("Asia");
        africa = new CustomCheckBox("Afrika");
        europe = new CustomCheckBox("Europa");
        nAmerica = new CustomCheckBox("Nord-Amerika");
        sAmerica = new CustomCheckBox("Sør-Amerika");
        oceania = new CustomCheckBox("Oseania");
        
        valid = new JTextArea(12, 15);
        valid.setEditable(false);
        valid.setVisible(false);
        valid.setFont(new Font("Arial", Font.PLAIN, 16));
        
        active = new CustomTextField(10);
        active.setBackground(null);
        active.setBorder(null);
        active.setForeground(Color.RED);
        active.setVisible(false);
        
        
        submit = new CustomButton("Registrer");
        delete = new CustomButton2("Avslutt forsikring");
        report = new CustomButton2("Opprett skademelding");
        actions = new CustomPanel();
        actions.setLayout(new GridBagLayout());
        gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.LINE_START;
        gbc2.insets = new Insets(10, 5, 10, 5);
        actions.setBorder(BorderFactory.createTitledBorder("Handlinger"));
        gbc2.weighty = 1;
        gbc2.weightx = 1;
        gbc2.gridx = 0;
        gbc2.gridy = 0;
        actions.add(report, gbc2);
        gbc2.gridy++;
        actions.add(delete, gbc2);
        actions.setVisible(false);
        
        setLayout(new GridBagLayout());
        
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 0, 0, 5);
        gbc.weighty = 1;
        gbc.weightx = 1;
        gbc.ipadx = 2;
        gbc.ipady = 5;
        gbc.anchor = GridBagConstraints.LINE_END;
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new CustomLabel("Forsikringstaker: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringsbeløp: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Forsikringspremie: "), gbc);
        
        gbc.gridy++;
        add(new CustomLabel("Betingelser: "), gbc);

        gbc.gridy++;
        add(new CustomLabel("Gyldig i: "), gbc);
        
        
        gbc.anchor = GridBagConstraints.LINE_START;
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        add(insTaker, gbc);
        
        gbc.gridy++;
        add(amount, gbc);
        
        gbc.gridy++;
        add(premium, gbc);
        
        gbc.gridy++;
        add(conditions, gbc);

        gbc.insets = new Insets(12, 5, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.gridy++;
        add(asia, gbc);
        add(valid, gbc);
        
        gbc.gridy++;
        add(africa, gbc);
        
        gbc.gridy++;
        add(europe, gbc);
        
        gbc.gridy++;
        add(nAmerica, gbc);
        
        gbc.gridy++;
        add(sAmerica, gbc);
        
        gbc.gridy++;
        add(oceania, gbc);
        
        gbc.gridy++;
        add(submit, gbc);
        
        gbc.gridy = 1;
        gbc.gridx = 2;
        gbc.gridwidth = 3;
        gbc.gridheight = 3;
        gbc.insets = new Insets(5, 40, 0, 5);
        add(actions, gbc);
        
        gbc.gridy = 4;
        add(active, gbc);
        
        
        
        submit.addActionListener((e) -> {
                if(!viewMode)
                {
                    listener.customActionPerformed(new CustomEvent(Constants.TRAVEL_INSURANCE_INT));
                }
                else if(edit)
                {
                    listener.customActionPerformed(new CustomEvent(Constants.TRAVEL_INSURANCE_INT));
                    change();
                }
                else {
                    change();
                }

                
        });
        
        
        delete.addActionListener((e) -> System.out.println("slett reiseforsikring"));
        
        report.addActionListener((e) ->{listener.customActionPerformed(new CustomEvent(Constants.NEW_REPORT));});
        
        
    }
    
    
    /**
     * Changes text-fields to uneditable if panel is used for viewing
     */
    public void setViewMode()
    {
        asia.setVisible(false);
        europe.setVisible(false);
        oceania.setVisible(false);
        nAmerica.setVisible(false);
        sAmerica.setVisible(false);
        africa.setVisible(false);
        
        actions.setVisible(true);
        active.setVisible(true);
        
        valid.setVisible(true);
        
        insTaker.setEditable(false);
        amount.setEditable(false);
        premium.setEditable(false);
        conditions.setEditable(false);
        
        
        submit.setText("Endre");
        delete.setVisible(true);
        
        viewMode = true;
    }
    
    
    /**
     * Returns whether or not the panel is in viewmode
     * @return boolean viewmode
     */
    public boolean isViewMode() {
        return viewMode;
    }

    /**
     * Sets the view mode
     * @param vm true or false
     */
    public void setViewMode(boolean vm) {
        viewMode = vm;
    }
    
    
    /**
     * Returns a string of the active status
     * @return active statis
     */
    public String getActive()
    {
        return active.getText();
    }
    
    /**
     * Sets the active status
     * @param a active status
     */
    public void setActive(String a)
    {
        active.setText(a);
    }
    
    
    
    /**
     * Method that sets the insurance taker-field with the customers name as a standard
     * @param n Customer name
     */
    public void setInsTaker(String n) {
        insTaker.setText(n);
    }
    
    /**
     * Returns the name the user has written in the insurance taker-field
     * @return insurance takers name
     */
    public String getInsTaker() {
        return insTaker.getText();
    }

    /**
     * Returns the amount the user has written in the insurance amount-field
     * @return insurance amount in NOK
     */
    public String getAmount() {
        return amount.getText();
    }
    
    /**
     * Returns the text the user has written in the yearly premium-field
     * @return amount in NOK the yearly premium
     */
    public String getPremium() {
        return premium.getText();
    }
    
    /**
     * Returns the text the user has written in the conditions-field
     * @return conditions for the insurance
     */
    public String getConditions() {
        return conditions.getText();
    }
    
    /**
     * Returns the continents the user has checked where the travel insurance will be valid
     * @return continents where the travel insurance are valid
     */
    public String getArea() {
        
        String area = "";
        
        if(asia.isSelected())
            area += "Asia\n";
        if(africa.isSelected())
            area += "Afrika\n";
        if(europe.isSelected())
            area += "Europa\n";
        if(nAmerica.isSelected())
            area += "Nord-Amerika\n";
        if(sAmerica.isSelected())
            area += "Sør-Amerika\n";
        if(oceania.isSelected())
            area += "Oseania\n";

        return area;
    }
    

    /**
     * Method that sets an amount in the insurance amount-field
     * @param a insurance amount in NOK
     */
    public void setAmount(String a) {
        amount.setText(a);
    }
    
    /**
     * Method that sets an amount in the yearly premium-field
     * @param p yearly premium in NOK
     */
    public void setPremium(String p) {
        premium.setText(p);
    }
    
    /**
     * Method that sets insurance conditions in the conditions-field
     * @param c insurance conditions
     */
    public void setConditions(String c) {
        conditions.setText(c);
    }

    /**
     * Method that sets the insurance valid continents in the valid-field
     * @param v valid continents
     */
    public void setValid(String v) {
        valid.setText(v);
    }
    
    
    
    
    /**
     * Clears all text fields
     */
    public void clearFields()
    {
        amount.setText("");
        premium.setText("");
        conditions.setText("");
        asia.setSelected(false);
        africa.setSelected(false);
        europe.setSelected(false);
        nAmerica.setSelected(false);
        sAmerica.setSelected(false);
        oceania.setSelected(false);
    }
    
    
    /**
     * Method makes textfields editable and passes the changed information to registry
     */
    public void change()
    {
        if(!edit) {
            amount.setEditable(true);
            premium.setEditable(true);
            conditions.setEditable(true);
            
            asia.setVisible(true);
            europe.setVisible(true);
            oceania.setVisible(true);
            nAmerica.setVisible(true);
            sAmerica.setVisible(true);
            africa.setVisible(true);
        
            valid.setVisible(false);
            
            submit.setText("Lagre");
            
            edit = true;  
        }
        else {
            amount.setEditable(false);
            premium.setEditable(false);
            conditions.setEditable(false);
            
            asia.setVisible(false);
            europe.setVisible(false);
            oceania.setVisible(false);
            nAmerica.setVisible(false);
            sAmerica.setVisible(false);
            africa.setVisible(false);
        
            valid.setVisible(true);
            
            submit.setText("Endre");
            
            edit = false;
            /*asia.setSelected(true);
            asia.setModel(new DefaultButtonModel() {

            @Override
            public boolean isSelected() {
                return true;
            }

            @Override
            public void setSelected(boolean b) {
                // Stop events from being raised...
            }

        });*/
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
