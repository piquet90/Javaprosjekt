/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JFileChooser;
import javax.swing.JTextArea;

/**
 *
 * @author Audun
 */
public class NyForsikringPanel extends JPanel {
    
    private JTextField kundeNr, premie, belop;
    private JButton submit, betingelser;
    private GridBagConstraints gbc, gbc2;
    private JFileChooser filvelger;
    private String filUrl;
    
    private void initComponents()
    {
        kundeNr = new JTextField(10);
        premie = new JTextField(10);
        belop = new JTextField(5);
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

    }
    
    public NyForsikringPanel()
    {
        this.setLayout(new GridBagLayout());
        this.setSize(getPreferredSize());
        initComponents();
        
        
        gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.weighty = 1;
        
        
        
       
        
        //// Første rad /////////////////////
        
        gbc.gridx = 0;
        gbc.gridy = -1;
 
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Kundenr:"), gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(15, 0, 0, 50);
        add(kundeNr, gbc);
        
        gbc.gridx = 2;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Premie"), gbc);
        
        gbc.gridx = 3;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(premie, gbc);
        
        //// Andre rad /////////////////////
        
        gbc.gridx = 0;
        gbc.gridy = -2;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(new JLabel("Beløp:"), gbc);
        
        gbc.gridx = 1;
        gbc.insets = new Insets(15, 0, 0, 30);
        add(belop, gbc);
        
        gbc.gridx = 2;
        gbc.insets = new Insets(15, 0, 0, 5);
        
        add(new JLabel(""), gbc);
        
        gbc.gridx = 3;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(betingelser, gbc);
        
        //// Tredje rad /////////////////////
        
        gbc.gridx = 0;
        gbc.gridy = -3;
        gbc.insets = new Insets(15, 0, 0, 5);
        add(submit, gbc);  

    }
    
    public Dimension getMinimumSize()
    {
        return super.getPreferredSize();
    }
}