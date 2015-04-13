
package controllers;

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
