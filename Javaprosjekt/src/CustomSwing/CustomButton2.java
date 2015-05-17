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

import java.awt.Dimension;
import java.awt.Font;

/**
 *
 * @author Audun
 */
public class CustomButton2 extends CustomButton {
    
    /**
     * Konstrukt�r som kaller opp og sender med knapp-teksten til konstrukt�ren til JButton
     * @param tekst Teksten som vises p� knappen
     */
    public CustomButton2(String tekst)
    {
        super(tekst);
        Font f = new Font("Arial", Font.PLAIN, 12);
        setPreferredSize(new Dimension(super.getStringWidth(f, tekst), 22));
        
        setFont(f);
    }
}
