/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import DAO.Constants;
import java.awt.Component;

/**
 *
 * @author Rudi
 */
public class CustomEvent {
    
    private int action;
    private int value;
    private Component source;
    
    public CustomEvent(int a)
    {
        this.action = a;
    }
    
    public CustomEvent(int a, int v)
    {
        this.action = a;
        this.value = v;
    }
    
    public void setValue(int i)
    {
        this.value = i;
    }
    public int getAction()
    {
        return action;
    }
    
    public Component getSource()
    {
        return source;
    }
    
    public int getValue()
    {
        return value;
    }
}
