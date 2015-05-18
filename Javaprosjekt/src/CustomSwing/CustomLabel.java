/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Font;
import javax.swing.JLabel;

/**
 * Custom label
 * @author Audun
 */
public class CustomLabel extends JLabel {
    
    /**
     * Constructor passes the label text to super
     * @param text 
     */
    public CustomLabel(String text)
    {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 15));
    }
}
