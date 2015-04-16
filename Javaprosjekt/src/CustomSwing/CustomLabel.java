/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Font;
import javax.swing.JLabel;


public class CustomLabel extends JLabel{
    
    public CustomLabel(String tekst)
    {
        super(tekst);
        setFont(new Font("DejaVu Sans", Font.BOLD, 15));
    }
}
