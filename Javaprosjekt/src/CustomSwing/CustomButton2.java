/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

/**
 *
 * @author Audun
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Audun
 */
public class CustomButton2 extends CustomButton {
    
    /**
     * Konstruktør som kaller opp og sender med knapp-teksten til konstruktøren til JButton
     * @param tekst Teksten som vises på knappen
     */
    public CustomButton2(String tekst)
    {
        super(tekst);
        setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
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
            setBackground(Color.LIGHT_GRAY);
        }
        else
        {
          setBackground(Color.LIGHT_GRAY);
          setForeground(Color.BLACK);
        }
        if(getModel().isPressed())
        {
          setBackground(new Color(000, 000, 000)); //funker ikke?
          setForeground(new Color(50, 90, 100));
        }
    }

}
