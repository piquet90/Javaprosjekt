/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;
    
    /**
     * @author Rudi Yu
     */


import CustomSwing.CustomButton;
import javax.swing.*;
import helpers.*;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class MainFrame extends JFrame{
    
    private JPanel panel;
    private CustomButton nyBruker, nyForsikring, nySkademelding;
    private NyBrukerPanel nyBrukerPanel;
    private NyForsikringPanel nyForsikringPanel;
    private Container c;
    
    private void initComponents()
    {
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT-60));
        
        nyBrukerPanel = new NyBrukerPanel();
        nyForsikringPanel = new NyForsikringPanel();
        
        nyBruker = new CustomButton("Ny bruker");
        nyBruker.addActionListener((e) -> setPanel("nyBruker"));
        
        nyForsikring = new CustomButton("Ny forskring");
        nyForsikring.addActionListener((e) -> setPanel("nyForsikring"));
       
    }
    
    public MainFrame()
    {
        super("Frame title");
        initComponents();
        
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO: Replace defaultCloseOperation when implementing save to file.
        setVisible(true);
        setLayout(new FlowLayout());
        
        c = getContentPane();
        c.add(nyBruker);
        c.add(nyForsikring);
        
    }
    
    private void setPanel(String t)
    {
        if(t.equals("nyBruker"))
        {
            panel.removeAll();
            
            panel.add(nyBrukerPanel);
        }
        
        else if(t.equals("nyForsikring"))
        {
            panel.removeAll();
            panel.add(new JLabel("Registrer ny forsikring"));
            panel.add(nyForsikringPanel);
        }
        
        c.add(panel);
        panel.repaint();
        panel.revalidate();
        
        
        
        
        
    }
    

}
