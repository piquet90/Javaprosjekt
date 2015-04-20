/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Tests;

import javax.swing.JFrame;
import views.NewInsurancePanel;

/**
 *
 * @author rudiwyu
 */
public class NyForsikringPanelTest {
    
    
    public static void main(String[]args)
    {
        JFrame frame = new JFrame();
        NewInsurancePanel panel = new NewInsurancePanel();
        frame.add(panel);
        frame.setVisible(true);
        frame.pack();
    }
}
