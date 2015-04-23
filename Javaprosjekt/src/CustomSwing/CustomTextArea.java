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
        setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
        //setBorder(BorderFactory.createEtchedBorder(new Color(222, 222, 222), new Color(150, 150, 150)));
        setLineWrap(true);
        setWrapStyleWord(true);
    }
}
