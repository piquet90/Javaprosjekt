/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package controllers;

import DAO.Constants;
import DAO.Registries;
import javax.swing.JOptionPane;
import models.CustomerModel;
import models.InsuranceModel;
import models.objects.insurances.CarInsurance;
import views.CustomEvent;
import views.CustomListener;
import views.registrations.*;

/**
 *
 * @author Rudi
 */
public class InsuranceController implements CustomListener{
    
    private MainController mc;
    private Registries registries;
    private InsuranceModel imodel;
    
    private NewBoatInsurance boatInsurance;
    private NewCarInsurance carInsurance;
    private NewHouseInsurance houseInsurance;
    private NewLeisureHouseInsurance leisureHouseInsurance;
    private NewTravelInsurance travelInsurance;
    
    private int id;
    
    
    public InsuranceController(Registries r, MainController c)
    {
        this.mc = c;
        this.registries = r;
        
        imodel = new InsuranceModel(r);
    }
    
    public void newCarInsurance(int id)
    {
        this.id = id;
        
        carInsurance = new NewCarInsurance();
        carInsurance.addCustomListener(this);
        mc.popUp(carInsurance);
    }
    public void newHouseInsurance(int id)
    {
        this.id = id;
        houseInsurance = new NewHouseInsurance();
        houseInsurance.addCustomListener(this);
        mc.popUp(houseInsurance);
    }
    public void newBoatInsurance(int id)
    {
        this.id = id;
        boatInsurance = new NewBoatInsurance();
        boatInsurance.addCustomListener(this);
        mc.popUp(boatInsurance);
    }
    public void newTravelInsurance(int id)
    {
        this.id = id;
        travelInsurance = new NewTravelInsurance();
        travelInsurance.addCustomListener(this);
        mc.popUp(travelInsurance);
    }
    public void newLeisureHouseInsurance(int id)
    {
        this.id = id;
        leisureHouseInsurance = new NewLeisureHouseInsurance();
        leisureHouseInsurance.addCustomListener(this);
        mc.popUp(leisureHouseInsurance);
    }
    
    public void registerCar()
    {
        CarInsurance insurance = new CarInsurance();
        
        String s = "";
        
        if(!carInsurance.getCarOwner().matches(Constants.ONLY_ALPHABETIC)||carInsurance.getCarOwner().equals(""))
            s+="Bileier\n";
        if(carInsurance.getRegNr().equals(""))
            s+="Registreringsnummer\n";
        if(carInsurance.getCarType().equals("")||carInsurance.getCarType().contains("Velg type..."))
            s+="Biltype\n";
        if(carInsurance.getModel().equals(""))
            s+="Modell\n";
        if(!carInsurance.getRegYear().matches(Constants.ONLY_NUMBERS))
            s+="Registreringsår\n";
        if(!carInsurance.getKmPerYear().matches(Constants.ONLY_NUMBERS))
            s+="Km. per år\n";
        if(!carInsurance.getPricePerKm().matches(Constants.ONLY_NUMBERS))
            s+="Pris pr. Km\n";
        if(!carInsurance.getBonus().matches(Constants.ONLY_NUMBERS))
            s+="Bonus";
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else
        {
            insurance.setOwnerId(id);
            insurance.setViechleOwner(carInsurance.getCarOwner());//done
            insurance.setRegistrationNumber(carInsurance.getRegNr());//done
            insurance.setType(carInsurance.getCarType());//done
            insurance.setModel(carInsurance.getModel());
            insurance.setRegistrationYear(Integer.parseInt(carInsurance.getRegYear()));//done
            insurance.setKmDriven(Integer.parseInt(carInsurance.getKmPerYear()));//done
            insurance.setPrice(Integer.parseInt(carInsurance.getPricePerKm()));//done
            insurance.setBonus(Integer.parseInt(carInsurance.getBonus())); // done

            imodel.addInsurance(insurance);
            JOptionPane.showMessageDialog(null, "CarInsurance Registered.");
        }
    }
    
    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction()==Constants.CAR_INSURANCE_INT)
            registerCar();
    }
    
}
