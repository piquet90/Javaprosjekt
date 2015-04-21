/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import javax.swing.JFileChooser;
import CustomSwing.*;
import controllers.Controller;
import controllers.NewInsuranceController;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;

/**
 *
 * @author Audun
 */

public class NewInsurancePanel extends CustomPanel implements View{
    
    private CustomButton submit, betingelser;
    private JFileChooser filvelger;
    private String filUrl;
    private CardLayout cl;
    private JComboBox<String> insType;
    
    private NewCarInsurance bil;
    private InsurancePanel ip;
    
    
    //midlertidig
    private CustomPanel container, panelFirst, panelSecond, panelBlank;
    
    private NewInsuranceController controller;
    
    public void initComponents()
    {
        setLayout(new BorderLayout());
        
        ip = new InsurancePanel();
        ip.initComponents();
        
        bil = new NewCarInsurance();
        bil.initComponents();

        cl = new CardLayout();
        
        String[] t = {"Velg type forsikring...", "Bilforsikring", "Husforsikring"}; 
        insType = new JComboBox<>(t);
        insType.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
        insType.setSize(new Dimension(100, 100));
        
        container = new CustomPanel();
        container.setLayout(cl);
        
        panelBlank = new CustomPanel();
        
        panelFirst = new CustomPanel();
        panelFirst.setBackground(Color.RED);
        panelFirst.add(new CustomLabel("Panel 1"));
        
        panelSecond = new CustomPanel();
        panelSecond.setBackground(Color.BLUE);
        panelSecond.add(new CustomLabel("Panel 2"));
        
        container.add(panelBlank, "0");
        container.add(bil, "1");
        container.add(panelSecond, "2");
        cl.show(container, "0");
        

        
        //add(new CustomLabel("Opprett forsikring"), BorderLayout.PAGE_START);
       
        add(ip, BorderLayout.PAGE_START);
        add(new CustomLabel("Velg type forsikring: "), BorderLayout.LINE_START);
        add(insType, BorderLayout.LINE_END);
        add(container, BorderLayout.PAGE_END);
                
        insType.addActionListener((e)->{
        int n = insType.getSelectedIndex();
                String s = String.valueOf(n);
                cl.show(container, s);});
                
    }
    
    public NewInsurancePanel()
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
