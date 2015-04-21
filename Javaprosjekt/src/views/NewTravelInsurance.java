/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton;
import CustomSwing.CustomButton2;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import CustomSwing.CustomTextField;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JCheckBox;

/**
 *
 * @author Audun
 */



public class NewTravelInsurance extends CustomPanel {
    
    private CustomTextField insTaker, amount;
    private JCheckBox asia, africa, europe, nAmerica, sAmerica, oceania;
    private CustomButton submit;
    private CustomButton2 changeTaker;
    private GridBagConstraints g;
    private String area;
    private boolean check = false;
    
    public NewTravelInsurance() {
        setLayout(new GridBagLayout());
        
        insTaker = new CustomTextField(16);
        insTaker.setEditable(false);
        insTaker.setText("Satt til kunde");
        
        amount = new CustomTextField(10);
        asia = new JCheckBox("Asia");
        africa = new JCheckBox("Afrika");
        europe = new JCheckBox("Europa");
        nAmerica = new JCheckBox("Nord-Amerika");
        sAmerica = new JCheckBox("Sør-Amerika");
        oceania = new JCheckBox("Oseania");
        
        submit = new CustomButton("Registrer");
        
        
        changeTaker = new CustomButton2("Endre");
        changeTaker.setToolTipText("Endre forsikringstaker");
        changeTaker.addActionListener((e) -> change());
        
        g = new GridBagConstraints();
        g.insets = new Insets(15, 0, 0, 5);
        g.ipadx = 2;
        g.ipady = 5;
        g.anchor = GridBagConstraints.LINE_END;
        
        g.gridx = 0;
        g.gridy = 0;
        add(new CustomLabel("Forsikringstaker: "), g);
        
        g.gridy++;
        add(new CustomLabel("Beløp: "), g);

        g.gridy++;
        add(new CustomLabel("Gyldig i: "), g);
        
        g.anchor = GridBagConstraints.LINE_START;
        
        g.gridx = 1;
        g.gridy = 0;
        add(insTaker, g);
        
        g.gridx++;
        add(changeTaker, g);
        
        g.gridx = 1;
        g.gridy++;
        add(amount, g);

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
        
        
    }

    public String getInsTaker() {
        return insTaker.getText();
    }

    public String getAmount() {
        return amount.getText();
    }

    public String getArea() {
        if(asia.isSelected())
            area += "Asia";
        if(africa.isSelected())
            area += "\nAfrika";
        if(europe.isSelected())
            area += "\nEuropa";
        if(nAmerica.isSelected())
            area += "\nNord-Amerika";
        if(sAmerica.isSelected())
            area += "\nSør-Amerika";
        if(oceania.isSelected())
            area += "\nOseania";

        return area;
    }
    
    public void change() {
        
        if(!check) {
            insTaker.setEditable(true);
            check = true;
        }
        else {
            insTaker.setEditable(false);
            insTaker.setText("Satt til kunde");
            check = false;
        }
    }
    
}
