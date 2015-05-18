/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Dimension;
import java.awt.Font;

/**
 *
 * @author Audun
 */
public class CustomButton2 extends CustomButton {
    
    /**
     * Constructor passes button text to super
     * @param text button text
     */
    public CustomButton2(String text)
    {
        super(text);
        Font f = new Font("Arial", Font.PLAIN, 12);
        setPreferredSize(new Dimension(super.getStringWidth(f, text), 22));
        
        setFont(f);
    }
}
