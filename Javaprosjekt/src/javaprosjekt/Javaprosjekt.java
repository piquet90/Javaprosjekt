/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package javaprosjekt;

import controllers.MainController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import models.MainModel;
import views.MainView;


public class Javaprosjekt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainView view = new MainView();
        MainModel model = new MainModel();
        MainController controller = new MainController(view, model);
        view.addWindowListener(
            new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    controller.save();
                    System.exit(0);
                            
                }
            }
        );
        // TODO: Replace defaultCloseOperation when implementing save to file.
    }
    
}
