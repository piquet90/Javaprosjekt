/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Font;
import javax.swing.JCheckBox;

/**
 *
 * @author Audun
 */
public class CustomCheckBox extends JCheckBox {
    
    /**
     * Constructor passes the checkbox text to super
     * @param s checkbox text
     */
    public CustomCheckBox(String s) {
        super(s);
        setFont(new Font("Arial", Font.PLAIN, 15));
    }
}
