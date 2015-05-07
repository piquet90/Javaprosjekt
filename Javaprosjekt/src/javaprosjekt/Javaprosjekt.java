/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package javaprosjekt;

// Imports

import java.awt.event.*;
import javax.swing.SwingUtilities;

import controllers.MainController;
import javax.swing.UIManager;
import models.MainModel;
import views.MainView;


public class Javaprosjekt {
    public static void main(String[] args) {
        
        
        
        
        SwingUtilities.invokeLater(new Runnable() {
            

            @Override
            public void run() {
                try{
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                }catch(Exception e)
                {
                    
                }
                MainView view = new MainView();
                MainController controller = new MainController(view);
                view.addWindowListener(
                new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        controller.save();
                        System.exit(0);   
                   }
                });
            }
        });
    }
    
}
