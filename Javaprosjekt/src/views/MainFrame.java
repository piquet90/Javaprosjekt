/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;



import javax.swing.*;
import helpers.*;

public class MainFrame extends JFrame{
    
    
    public MainFrame()
    {
        setSize(Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        // TODO: Replace defaultCloseOperation when implementing save to file.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
