/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

/**
 *
 * @author rudiwyu
 */
import javax.swing.*;
import models.*;
import views.*;

public class MainController {
    
    
    private MainFrame view;
    private MainModel model;
    
    public MainController(MainFrame f, MainModel m)
    {
        view = f;
        model = m;
    }
}
