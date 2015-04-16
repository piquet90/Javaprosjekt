
/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;


import javax.swing.*;
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
