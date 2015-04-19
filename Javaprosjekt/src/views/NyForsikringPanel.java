/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import javax.swing.JFileChooser;
import CustomSwing.*;
//import controllers.Controller;
//import controllers.NewInsuranceController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import CustomSwing.*;
import controllers.Controller;
import controllers.NewInsuranceController;
/**
 *
 * @author Audun
 */

public class NyForsikringPanel extends CustomPanel implements View{

    
    private CustomButton submit, betingelser;
    private JFileChooser filvelger;
    private String filUrl;
    private CardLayout cl;
    private JComboBox<String> insType;
    
    
    

    private NewInsuranceController controller;
    
    public void initComponents()
    {
        // this.setLayout(new GridBagLayout());
        
        
        // gbc = new GridBagConstraints();
        // gbc.anchor = GridBagConstraints.LINE_START; 
        /* 
        kundeNr = new CustomTextField(10);
        premie = new CustomTextField(10);
        belop = new CustomTextField(5);
        
        filvelger = new JFileChooser();
        
        betingelser = new CustomButton("Betingelser");
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
        setLayout(new BorderLayout());
        setSize(getPreferredSize());
        
        initComponents();
        cl = new CardLayout();
        
        String[] t = {"Velg ny forsikring...", "Bilforsikring", "Husforsikring"}; 
        insType = new JComboBox<>(t);
        insType.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
        
        container = new JPanel();
        container.setLayout(cl);
        
        panelBlank = new JPanel();
        
        panelFirst = new JPanel();
        panelFirst.setBackground(Color.RED);
        panelFirst.add(new CustomLabel("Panel 1"));
        
        panelSecond = new JPanel();
        panelSecond.setBackground(Color.BLUE);
        panelSecond.add(new CustomLabel("Panel 2"));
        
        container.add(panelBlank, "0");
        container.add(bil, "1");
        container.add(panelSecond, "2");
        cl.show(container, "0");
        
        add(new CustomLabel("Opprett forsikring"), BorderLayout.PAGE_START);
        add(insType, BorderLayout.CENTER);
        add(container, BorderLayout.PAGE_END);
                
        insType.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                int n = insType.getSelectedIndex();
                String s = String.valueOf(n);
                cl.show(container, s);
            }});
        */
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