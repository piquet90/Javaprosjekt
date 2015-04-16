/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Tests;

import javax.swing.JFrame;
import views.NyForsikringPanel;

/**
 *
 * @author rudiwyu
 */
public class NyForsikringPanelTest {
    
    
    public static void main(String[]args)
    {
        JFrame frame = new JFrame();
        NyForsikringPanel panel = new NyForsikringPanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
