/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package CustomSwing;

import java.awt.Font;

/**
 * Custom label for headers
 * @author Audun
 */
public class CustomLabelHeader extends CustomLabel {

    /**
     * Constructor passes the label text to super
     * @param text label text
     */
    public CustomLabelHeader(String text) {
        super(text);
        setFont(new Font("Arial", Font.BOLD, 21));
    }
    
}
