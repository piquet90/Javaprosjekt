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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Audun
 */
public class CustomButton3 extends CustomButton {
    
    /**
     * Konstruktør som kaller opp og sender med knapp-teksten til konstruktøren til JButton
     * @param tekst Teksten som vises på knappen
     */
    public CustomButton3(String tekst)
    {
        super(tekst);
        Font f = new Font("Arial", Font.PLAIN, 12);
        setPreferredSize(new Dimension(super.getStringWidth(f, tekst), 22));
        
        setFont(f);
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
            setBackground(new Color(159, 196, 232));
        }
        else
        {
          setBackground(new Color(159, 196, 232));
          setForeground(Color.BLACK);
        }
        if(getModel().isPressed())
        {
          setForeground(new Color(50, 90, 100));
        }
    }

}
