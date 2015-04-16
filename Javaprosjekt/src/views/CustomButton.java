/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Audun
 */
public class CustomButton extends JButton {
    
    /**
     * Konstruktør som kaller opp og sender med knapp-teksten til konstruktøren til JButton
     * @param tekst Teksten som vises på knappen
     */
    public CustomButton(String tekst)
    {
        super(tekst);
        setFont(new Font("DejaVu Sans", Font.BOLD, 15));
    }
    
    /**
     * Metode som tegner knappen og endrer bakgrunns-/forgrunnsfarge etter hvilken "state" knappen er
     * @param g Grafikk/farger knappen
     */
    
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if(getModel().isRollover())
        {
            setBackground(new Color(115, 175, 220));
        }
        else
        {
          setBackground(new Color(90, 140, 170));
          setForeground(Color.WHITE);
        }
        if(getModel().isPressed())
        {
          setBackground(new Color(000, 000, 000)); //funker ikke?
          setForeground(new Color(50, 90, 100));
        }
    }

}
