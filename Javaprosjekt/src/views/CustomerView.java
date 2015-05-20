/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package views;

import CustomSwing.CustomButton2;
import CustomSwing.CustomTextField;
import CustomSwing.CustomLabel;
import CustomSwing.CustomPanel;
import DAO.Constants;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

public class CustomerView extends JTabbedPane implements ActionListener {
    
    private CustomTextField fName, lName, adress, city, zip;
    private CustomPanel cusTab, repTab;
    private GridBagConstraints gbc;
    private CustomButton2 endre, newIns, newRep;
    private JPopupMenu insPopup, repPopup;
    private boolean edit = false;
    private CustomListener listener;
    
    
    /**
     * CustomerViews constructor
     */
    public CustomerView()
    {
        fName = new CustomTextField(12);
        fName.setEditable(false);
        lName = new CustomTextField(12);
        lName.setEditable(false);
        adress = new CustomTextField(15);
        adress.setEditable(false);
        city = new CustomTextField(12);
        city.setEditable(false);
        zip = new CustomTextField(5);
        zip.setEditable(false);
        
        endre = new CustomButton2("Endre");
        newIns = new CustomButton2("Opprett ny forsikring");       
        newRep = new CustomButton2("Opprett ny skademelding");
        
        endre.addActionListener(this);
        newIns.addActionListener(this);
        newRep.addActionListener(this);
        
        String[] insType = {"Bilforsikring", "Båtforsikring", "Hus- /innboforsikring", "Fritidsboligforsikring", "Reiseforsikring"};
        insPopup = new JPopupMenu();
        
        for(int i = 0; i < insType.length; i++)
        {
            String a = insType[i];
            JMenuItem b = new JMenuItem(a);
            b.addActionListener(this);
            b.setName(a);
            insPopup.add(b);
        }
        
        newIns.addActionListener((ActionEvent ev) -> {
            insPopup.show(newIns, 0, 0 + newIns.getHeight());
        });
        
        String[] repType = {"Bilskade", "Båtskade", "Hus- /innboskade", "Fritidsboligskade", "Reiseskade"};
        repPopup = new JPopupMenu();
        
        for(int i = 0; i < repType.length; i++)
        {
            String a = repType[i];
            JMenuItem b = new JMenuItem(a);
            b.addActionListener(this);
            b.setName(a);
            repPopup.add(b);
        }
        
        newRep.addActionListener((ActionEvent ev) -> {
            repPopup.show(newRep, 0, 0 + newRep.getHeight());
        });
        
        setFont(new Font("Arial", Font.BOLD, 18));
        
        cusTab = new CustomPanel();
        repTab = new CustomPanel();
        
        //cusTab Layout initalizing
        cusTab.setLayout(new GridBagLayout());
 
        gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 0, 5);
        gbc.ipadx = 2;
        gbc.ipady = 5;
        
        gbc.anchor = GridBagConstraints.LINE_END;
        
        //Adding the components to cusTab panel
        gbc.gridx = 0;
        gbc.gridy = 1;
        cusTab.add(new CustomLabel("Fornavn: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Etternavn: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Adresse: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Postnummer: "), gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel("Poststed: "), gbc);
  
        gbc.anchor = GridBagConstraints.LINE_START;    

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.insets = new Insets(15, 0, 0, 10);
        gbc.gridwidth = 2;
        cusTab.add(fName, gbc);
        
        gbc.gridy++;
        cusTab.add(lName, gbc);
        
        gbc.gridy++;
        cusTab.add(adress, gbc);
        
        gbc.gridy++;
        cusTab.add(zip, gbc);
        
        gbc.gridy++;
        cusTab.add(city, gbc);
        
        gbc.gridy++;
        cusTab.add(new CustomLabel(""), gbc);
        
        gbc.gridy++;
        gbc.gridwidth = 1;
        cusTab.add(endre, gbc);
        

        CustomPanel p = new CustomPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        g.anchor = GridBagConstraints.LINE_START;
        g.insets = new Insets(15, 0, 0, 0);
        g.gridx = 0;
        g.gridy = 0;
        p.add(newIns, g);
        g.gridy++;
        p.add(newRep, g);
        g.gridy++;
        g.insets = new Insets(15, 0, 5, 0);
        
        p.setBorder(BorderFactory.createTitledBorder("Handlinger"));
        
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.gridheight = 4;
        gbc.insets = new Insets(0, 50, 0, 15);
        cusTab.add(p, gbc);
        
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>Kundeinformasjon</body></html>", cusTab);
 
    }
    
    /**
     * Method makes textfields editable and passes the changed information to registry
     */
    public void change()
    {
        if(!edit) {
            fName.setEditable(true);
            lName.setEditable(true);
            adress.setEditable(true);
            city.setEditable(true);
            zip.setEditable(true);
            
            endre.setText("Lagre");
            
            edit = true;  
        }
        else {
            String f = fName.getText();
            String e = lName.getText();
            String a = adress.getText();
            String ps = city.getText();
            String pn = zip.getText();
            
            //controller.endre(f, e, a, ps, pn);

            fName.setEditable(false);
            lName.setEditable(false);
            adress.setEditable(false);
            city.setEditable(false);
            zip.setEditable(false);
            
            endre.setText("Endre");
            
            edit = false;
        } 
    }

    /**
     * Sets first name in the first name-field
     * @param fn customers first name
     */
    public void setFName(String fn) {
        fName.setText(fn);
    }
    
    /**
     * Returns the text in the first name-field
     * @return customers first name
     */
    public String getFName() {
        return fName.getText();
    }

    /**
     * Sets last name in the last name-field
     * @param ln customers last name
     */
    public void setLName(String ln) {
        lName.setText(ln);
    }
    
    /**
     * Returns the text in the last name-field
     * @return customers last name
     */
    public String getLName() {
        return lName.getText();
    }

    /**
     * Sets adress in the adress-field
     * @param a customers adress
     */
    public void setAdress(String a) {
        adress.setText(a);
    }
    
    /**
     * Returns the text in the adress-field
     * @return customers adress
     */
    public String getAdress() {
        return adress.getText();
    }

    /**
     * Sets city in the city-field
     * @param c customers city
     */
    public void setCity(String c) {
        city.setText(c);
    }
    
    /**
     * Returns the text in the city-field
     * @return customers city
     */
    public String getCity() {
        return city.getText();
    }

    /**
     * Sets zip number in the zip number-field
     * @param z customers zip number
     */
    public void setZip(String z) {
        zip.setText(z);
    }
    
    /**
     * Returns the text in the zip-field
     * @return customers zip number
     */
    public String getZip() {
        return zip.getText();
    }
 
    /**
     * Recieves error message from controller and displays it to user
     * @param error error message
     */
    public void showError(String error)
    {
        JOptionPane.showMessageDialog(this, error);
    }
    
    /**
     * Method that adds a tab with a table to the window
     * @param s Tab title
     * @param v table
     */
    public void addTable(String s, ViewTable v)
    {
        JTable table = v;
        JTableHeader tableHeader = v.getTableHeader();
        tableHeader.setReorderingAllowed(false);
        table.setAutoCreateRowSorter(true);
        
        this.addTab("<html><body leftmargin=5 topmargin=8 marginwidth=5 marginheight=5>"+s+"</body></html>", new JScrollPane(table));
    }
    
    public void addCustomListener(CustomListener e)
    {
        this.listener = e;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==endre)// tillate endring av felt
            if(!edit)
                change();
            else
                listener.customActionPerformed(new CustomEvent(Constants.NEW_CUSTOMER));

            switch (e.getActionCommand()) {
                case "Båtforsikring":
                    listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE, Constants.BOAT_INSURANCE_INT));
                    break;
                case "Bilforsikring":
                    listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE, Constants.CAR_INSURANCE_INT));
                    break;
                case "Hus- /innboforsikring":
                    listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE, Constants.HOUSE_INSURANCE_INT));
                    break;
                case "Fritidsboligforsikring":
                    listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE, Constants.LEISUREHOUSE_INSURANCE_INT));
                    break;
                case "Reiseforsikring":
                    listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE, Constants.TRAVEL_INSURANCE_INT));
                    break;
            }
        
        
        
        
        
        /*if(e.getSource()==newIns)// ny forsikring
            listener.customActionPerformed(new CustomEvent(Constants.NEW_INSURANCE));
        if(e.getSource()==newRep)
            listener.customActionPerformed(new CustomEvent(Constants.NEW_REPORT));*/
    }

}