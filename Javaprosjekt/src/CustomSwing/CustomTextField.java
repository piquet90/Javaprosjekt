/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextField;

/**
 * 
 * @author Audun
 */

public class CustomTextField extends JTextField {
    
    /**
     * Constructor passes the text field length to super
     * @param length text field length
     */
    public CustomTextField(int length)
    {
        super(length);
        setFont(new Font("Arial", Font.PLAIN, 15));
        setBorder(BorderFactory.createEtchedBorder(new Color(222, 222, 222), new Color(150, 150, 150)));
    }
}
