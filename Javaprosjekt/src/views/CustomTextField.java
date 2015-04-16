/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import java.awt.Font;
import javax.swing.JTextField;


public class CustomTextField extends JTextField{
    
    public CustomTextField(int lengde)
    {
        super(lengde);
        setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
    }
}
