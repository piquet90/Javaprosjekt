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
     * Constructor passes button text to super
     * @param text button text
     */
    public CustomButton(String text) {
        super(text);
        Font f = new Font("Arial", Font.BOLD, 18);
        setFont(f);
        setLayout(null);
        setPreferredSize(new Dimension(getStringWidth(f, text), 45));
    }
    
    /**
     * Calculates the button width from the text to be displayed
     * @param f button font 
     * @param s button text to be measure
     * @return button width calculated from font and text in pixels
     */
    public int getStringWidth(Font f, String s)
    {
        Font font = f;
        FontMetrics m = getFontMetrics(font);
        return m.stringWidth(s) + 55;
    }
}
