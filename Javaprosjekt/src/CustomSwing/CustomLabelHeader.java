/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Font;

/**
 *
 * @author Audun
 */
public class CustomLabelHeader extends CustomLabel {

    public CustomLabelHeader(String tekst) {
        super(tekst);
        setFont(new Font("Arial", Font.BOLD, 21));
    }
    
}
