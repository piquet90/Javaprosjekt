/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import javax.swing.JButton;

/**
 *
 * @author Audun
 */
public class CustomButton extends JButton {
    
    /**
     * Konstruktør som kaller opp og sender med knapp-teksten til konstruktøren til JButton
     * @param tekst Teksten som skal vises på knappen
     */
    public CustomButton(String tekst) {
        super(tekst);
        Font f = new Font("Arial", Font.BOLD, 18);
        setFont(f);
        this.setLayout(null);
        setPreferredSize(new Dimension(getStringWidth(f, tekst), 45));
    }
    
    /**
     * 
     * @param f Mottar font den skal finne vidden til
     * @param s Mottar teksten som skal være på knappen og finner bredden av stringen i piksler
     * @return Vidden av stringen pluss ekstra tomrom, som gjør at alle knappene får en vidde tilpasset lengden av teksten på knappen
     */
    public int getStringWidth(Font f, String s)
    {
        Font font = f;
        FontMetrics m = getFontMetrics(font);
        return m.stringWidth(s) + 55;
    }
    
    /**
     * 
     * @param s Mottar teksten som skal være på knappen og finner bredden av stringen i piksler
     * @return Vidden av stringen pluss ekstra tomrom, som gjør at alle knappene får en vidde tilpasset lengden av teksten på knappen
     */
    public int getStringHeight(String s)
    {
        Font font = new Font("Arial", Font.BOLD, 17);
        FontMetrics m = getFontMetrics(font);
        return m.stringWidth(s) + 70;
    }
    
}
