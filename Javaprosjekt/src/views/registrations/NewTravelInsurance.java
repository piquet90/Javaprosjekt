/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views.registrations;

import CustomSwing.CustomButton;
import CustomSwing.CustomCheckBox;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import DAO.Constants;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import views.CustomEvent;
import views.CustomListener;

/**
 * Panel for registering a travel insurance
 * @author Audun
 */
public class NewTravelInsurance extends CustomPanel {
    
    private CustomTextField insTaker, amount, premium, conditions;
    private CustomCheckBox asia, africa, europe, nAmerica, sAmerica, oceania;
    private CustomButton submit;
    private GridBagConstraints g;
    
    private CustomListener listener;
    
    
    /**
     * Method that initalizes the GUI components
     */
    public void initComponents()
    {

    }
    
    /**
     * NewTravelInsurance constructor
     */
    public NewTravelInsurance()
    {
        insTaker = new CustomTextField(16);
        premium = new CustomTextField(5);
        amount = new CustomTextField(5);
        conditions = new CustomTextField(15);
        
        asia = new CustomCheckBox("Asia");
        africa = new CustomCheckBox("Afrika");
        europe = new CustomCheckBox("Europa");
        nAmerica = new CustomCheckBox("Nord-Amerika");
        sAmerica = new CustomCheckBox("Sør-Amerika");
        oceania = new CustomCheckBox("Oseania");
        
        submit = new CustomButton("Registrer");
        setLayout(new GridBagLayout());
        
        g = new GridBagConstraints();
        g.insets = new Insets(15, 0, 0, 5);
        g.ipadx = 2;
        g.ipady = 5;
        g.anchor = GridBagConstraints.LINE_END;
        
        g.gridx = 0;
        g.gridy = 0;
        add(new CustomLabel("Forsikringstaker: "), g);
        
        g.gridy++;
        add(new CustomLabel("Forsikringsbeløp: "), g);
        
        g.gridy++;
        add(new CustomLabel("Forsikringspremie: "), g);
        
        g.gridy++;
        add(new CustomLabel("Betingelser: "), g);

        g.gridy++;
        add(new CustomLabel("Gyldig i: "), g);
        
        
        g.anchor = GridBagConstraints.LINE_START;
        
        g.gridx = 1;
        g.gridy = 0;
        add(insTaker, g);
        
        g.gridy++;
        add(amount, g);
        
        g.gridy++;
        add(premium, g);
        
        g.gridy++;
        add(conditions, g);

        g.insets = new Insets(12, 5, 0, 5);
        g.ipadx = 2;
        g.ipady = 5;
        
        g.gridy++;
        add(asia, g);
        
        g.gridy++;
        add(africa, g);
        
        g.gridy++;
        add(europe, g);
        
        g.gridy++;
        add(nAmerica, g);
        
        g.gridy++;
        add(sAmerica, g);
        
        g.gridy++;
        add(oceania, g);
        
        g.gridy++;
        add(submit, g);
        
        submit.addActionListener((e)->{listener.customActionPerformed(new CustomEvent(Constants.TRAVEL_INSURANCE_INT));});
        
        
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
            area += "Asia";
        if(africa.isSelected())
            area += "Afrika";
        if(europe.isSelected())
            area += "Europa";
        if(nAmerica.isSelected())
            area += "Nord-Amerika";
        if(sAmerica.isSelected())
            area += "Sør-Amerika";
        if(oceania.isSelected())
            area += "Oseania";

        return area;
    }
    
    public void clearFields()
    {
        insTaker.setText("");
        amount.setText("");
        premium.setText("");
        conditions.setText("");
        asia.setContentAreaFilled(false);
        africa.setContentAreaFilled(false);
        europe.setContentAreaFilled(false);
        nAmerica.setContentAreaFilled(false);
        sAmerica.setContentAreaFilled(false);
        oceania.setContentAreaFilled(false);
    } // end of clearfields
    
    /**
     * Method that connect controllers listener to the panel
     * @param l CustomListener
     */
    public void addCustomListener(CustomListener l)
    {
        this.listener = l;
    }
    
}
