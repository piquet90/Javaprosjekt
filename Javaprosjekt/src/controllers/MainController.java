
package controllers;

import models.*;
import views.*;

/**
 *
 * @author Rudi
 */
public class MainController {
    
    
    private MainFrame view;
    private MainModel model;
    
    /**
     *
     * @param f
     * @param m
     */
    public MainController(MainFrame f, MainModel m)
    {
        view = f;
        model = m;
    }
}
