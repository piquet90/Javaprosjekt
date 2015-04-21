/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Font;
import javax.swing.JComboBox;

/**
 *
 * @author Audun
 */
public class CustomComboBox extends JComboBox {
    public CustomComboBox(String[] c) {
        super(c);
        setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
    }
}
