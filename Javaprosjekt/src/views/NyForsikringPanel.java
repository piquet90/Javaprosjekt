/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JFileChooser;

import CustomSwing.*;
import controllers.Controller;
import controllers.NewInsuranceController;
/**
 *
 * @author Audun
 */
public class NyForsikringPanel extends CustomPanel implements View{
    
    private CustomTextField kundeNr, premie, belop;
    private JButton submit, betingelser;
    private GridBagConstraints gbc, gbc2;
    private JFileChooser filvelger;
    private String filUrl;
    
    private NewInsuranceController controller;
    
    public void initComponents()
    {
        // this.setLayout(new GridBagLayout());
        
        
        // gbc = new GridBagConstraints();
        // gbc.anchor = GridBagConstraints.LINE_START; 
        kundeNr = new CustomTextField(10);
        premie = new CustomTextField(10);
        belop = new CustomTextField(5);
        
        filvelger = new JFileChooser();
        
     
        betingelser = new JButton("Betingelser");
        betingelser.addActionListener((e) ->
        {
                int returnVal = filvelger.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION)
                {
                    String path = filvelger.getSelectedFile().getAbsolutePath();
                    filUrl = (path);
                }});
        
        submit = new JButton("Submit");
        submit.addActionListener((e) -> System.out.println("trykk"));
        
        add(kundeNr);
        add(premie);
        add(belop);
        
        add(betingelser);

    }
    
    public NyForsikringPanel()
    {
        
    }

    @Override
    public boolean addController(Controller c) {
        if(c instanceof NewInsuranceController)
        {
            this.controller = (NewInsuranceController)c;
            return true;
        }
        return false;
    }
}