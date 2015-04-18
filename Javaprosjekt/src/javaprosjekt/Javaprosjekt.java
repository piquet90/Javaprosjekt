/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package javaprosjekt;

import controllers.MainController;
import javax.swing.JFrame;
import models.MainModel;
import views.MainFrame;


public class Javaprosjekt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        MainFrame view = new MainFrame();
        MainModel model = new MainModel();
        MainController controller = new MainController(view, model);
        view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO: Replace defaultCloseOperation when implementing save to file.
    }
    
}
