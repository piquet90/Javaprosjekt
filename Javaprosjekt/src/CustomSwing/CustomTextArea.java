/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

/**
 *
 * @author Audun
 */
public class CustomTextArea extends JTextArea {
    
    public CustomTextArea(int h, int w) {
        super(h, w);
        setFont(new Font("Arial", Font.PLAIN, 15));
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}
