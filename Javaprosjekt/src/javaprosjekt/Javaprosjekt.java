/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package javaprosjekt;

import controllers.MainController;
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
    }
    
}
