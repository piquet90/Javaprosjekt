/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import views.SimpleSearchView;

/**
 *
 * @author Audun
 */
public class ViewTest {
    

    public static void main(String[] args) {
        //JOptionPane.showMessageDialog(null, new SimpleSearchView());
        
        
        
        new hei();
        
        
                
    }


}

class hei {
    public hei()
    {
        JButton btn = new JButton("Opprett ny forsikring");
        JPanel panel = new JPanel();
        JPopupMenu popUp = new JPopupMenu();
        
        ActionListener menuListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switch (e.getActionCommand()) {
                    case "Båtforsikring":
                        System.out.println("Du valgte båtforsikring");
                        break;
                    case "Bilforsikring":
                        System.out.println("Du valgte bilforsikring");
                        break;
                    case "Hus- /innboforsikring":
                        System.out.println("Du valgte hus- / innboforsikring");
                        break;
                    case "Fritidsboligforsikring":
                        System.out.println("Du valgte fritidsboligforsikring");
                        break;
                    case "Reiseforsikring":
                        System.out.println("Du valgte reiseforsikring");
                        break;
                }
            }
        };
        
        String[] t = {"Bilforsikring", "Båtforsikring", "Hus- /innboforsikring", "Fritidsboligforsikring", "Reiseforsikring"};
        
        for(int i = 0; i < t.length; i++)
        {
            String a = t[i];
            JMenuItem b = new JMenuItem(a);
            b.addActionListener(menuListener);
            b.setName(a);
            popUp.add(b);
        }
        
        btn.addActionListener((ActionEvent ev) -> {
            popUp.show(btn, 0, 0 + btn.getHeight());
        });
        
        
        panel.add(new JLabel("EN KNAPP FOR Å OPPRETTE NY FORSIKRING"));
        panel.add(btn);
        
        JOptionPane.showMessageDialog(null, panel);
    }
    
}
