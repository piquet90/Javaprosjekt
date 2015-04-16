/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridbaglayout;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Audun
 */
public class MenuPanel extends JPanel{
    
    public MenuPanel()
    {
        Dimension size = getPreferredSize();
        size.width = 120;
        size.height = 120;
        setPreferredSize(size);
        setBorder(BorderFactory.createTitledBorder("title"));
    }
    
}
