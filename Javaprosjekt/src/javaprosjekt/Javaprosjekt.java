/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaprosjekt;

import controllers.MainController;
import models.MainModel;
import views.MainFrame;

/**
 *
 * @author rudiwyu
 */
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
