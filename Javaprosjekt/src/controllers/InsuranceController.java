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
import models.objects.insurances.BoatInsurance;
import models.objects.insurances.CarInsurance;
import models.objects.insurances.HouseInsurance;
import models.objects.insurances.Insurance;
import models.objects.insurances.LeisureHouseInsurance;
import models.objects.insurances.TravelInsurance;
import views.CustomEvent;
import views.CustomListener;
import views.registrations.*;

/**
 *
 * @author Rudi
 */
public class InsuranceController implements CustomListener{
    
    private MainController mc;
    private InsuranceModel imodel;
    private CustomerModel cModel;
    
    private NewBoatInsurance boatInsurance;
    private NewCarInsurance carInsurance;
    private NewHouseInsurance houseInsurance;
    private NewLeisureHouseInsurance leisureHouseInsurance;
    private NewTravelInsurance travelInsurance;
    
    
    
    private int id, insuranceId;
    
    
    public InsuranceController(Registries r, MainController c)
    {
        this.mc = c;
        imodel = new InsuranceModel(r);
        cModel = new CustomerModel(r);
    }
    
    public void newCarInsurance(int id)
    {
        this.id = id;
        
        carInsurance = new NewCarInsurance();
        carInsurance.addCustomListener(this);
        String s = this.cModel.findById(id).getName();
        carInsurance.setCarOwner(s);
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
        String s = this.cModel.findById(id).getName();
        boatInsurance.setBoatOwner(s);
        mc.popUp(boatInsurance);
    }
    public void newTravelInsurance(int id)
    {
        this.id = id;
        
        travelInsurance = new NewTravelInsurance();
        String s = this.cModel.findById(id).getName();
        travelInsurance.setInsTaker(s);
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
        
        String s = "";
        
        if(carInsurance.getCarOwner().equals(""))
            s+="Bileier\n";
        if(carInsurance.getRegNr().equals(""))
            s+="Registreringsnummer\n";
        if(carInsurance.getCarType().equals("")||carInsurance.getCarType().contains("Velg type..."))
            s+="Biltype\n";
        if(carInsurance.getModel().equals(""))
            s+="Modell\n";
        s += validateInt(carInsurance.getHorsepower(), "Effekt(i hk)");
        s += validateInt(carInsurance.getRegYear(), "Registreringsår\n");
        s += validateDouble(carInsurance.getKmPerYear(), "Km. per år\n");
        s += validateDouble(carInsurance.getPricePerKm(), "Pris pr. Km\n");
        s += validateInt(carInsurance.getBonus(), "Bonus");
                
        if(!s.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
            return;
        }
            
        else
        {
            CarInsurance insurance = new CarInsurance();
            insurance.setOwnerId(id);
            insurance.setViechleOwner(carInsurance.getCarOwner());//done
            insurance.setRegistrationNumber(carInsurance.getRegNr());//done
            insurance.setCarType(carInsurance.getCarType());//done
            insurance.setModel(carInsurance.getModel());
            insurance.setPower(Integer.parseInt(carInsurance.getHorsepower()));
            insurance.setRegistrationYear(Integer.parseInt(carInsurance.getRegYear()));//done
            insurance.setKmPerYear(Integer.parseInt(carInsurance.getKmPerYear()));//done
            insurance.setPricePrKm(Double.parseDouble(carInsurance.getPricePerKm()));//done
            insurance.setPrice(Double.parseDouble(carInsurance.getPremium()));
            insurance.setCoverage(Double.parseDouble(carInsurance.getAmount()));
            insurance.setBonus(Integer.parseInt(carInsurance.getBonus())); // done
            insurance.setConditions(carInsurance.getConditions());
            
            if(carInsurance.isViewMode())
            {
                insurance.setId(id);
                int next = Insurance.getNext() - 1;
                Insurance.setNext(next);
            }
            else {
                carInsurance.clearFields();
            }
                
            imodel.addInsurance(insurance);
            
            mc.ncController.refresh();
            success();
        }
    }
    
    public void registerBoat()
    {
        String s = "";
        if(boatInsurance.getBoatOwner().equals(""))
            s+="Båteier\n";
        if(boatInsurance.getRegNr().equals(""))
            s+="Registreringsnummer\n";
        if(boatInsurance.getType().equals("Velg type..."))
            s+="Båttype\n";
        if(boatInsurance.getModel().equals(""))
            s+="Modell\n";
        if(boatInsurance.getEngineType().equals(""))
            s+="Motortype\n";
        s += validateInt(boatInsurance.getHorsepower(), "Effekt(HK)\n");
        s += validateInt(boatInsurance.getLength(), "Lengde\n");
        
        s += validateDouble(boatInsurance.getAmount(), "Forsikringsbeløp\n");
        s += validateDouble(boatInsurance.getPremium(), "Pris pr. år\n");
        s += validateInt(boatInsurance.getModelYear(), "Årsmodell\n");

        
        if(boatInsurance.getConditions().equals(""))
            s+="Betingelser\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
            BoatInsurance insurance = new BoatInsurance();
            
            insurance.setOwnerId(id);
            insurance.setViechleOwner(boatInsurance.getBoatOwner());
            insurance.setRegistrationNumber(boatInsurance.getRegNr());
            insurance.setViechleType(boatInsurance.getType());
            insurance.setModel(boatInsurance.getModel());
            insurance.setEngineType(boatInsurance.getEngineType());
            insurance.setPower(Integer.parseInt(boatInsurance.getHorsepower()));
            insurance.setLength(Integer.parseInt(boatInsurance.getLength()));
            insurance.setModelYear(Integer.parseInt(boatInsurance.getModelYear()));
            insurance.setCoverage(Double.parseDouble(boatInsurance.getAmount()));
            insurance.setPrice(Double.parseDouble(boatInsurance.getPremium()));
            insurance.setConditions(boatInsurance.getConditions());
            
            if(boatInsurance.isViewMode())
            {
                insurance.setId(id);
                int next = Insurance.getNext() - 1;
                Insurance.setNext(next);
            }
            else {
                boatInsurance.clearFields();
            }
            imodel.addInsurance(insurance);
            boatInsurance.clearFields();
            mc.ncController.refresh();
            success();
        }
    }// end of newBoat()
    
    public void registerTravel()
    {
        String s = "";
        if(travelInsurance.getInsTaker().equals(""))
            s+="Forsikringstaker\n";
        if(travelInsurance.getAmount().equals("")||!travelInsurance.getAmount().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringsbeløp\n";
        if(travelInsurance.getPremium().equals("")||!travelInsurance.getPremium().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringspremie\n";
        if(travelInsurance.getArea().equals(""))
            s+="Gyldige områder\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
            TravelInsurance insurance = new TravelInsurance();
            insurance.setOwnerId(id);
            insurance.setCoverage(Double.parseDouble(travelInsurance.getPremium()));
            insurance.setPrice(Double.parseDouble(travelInsurance.getAmount()));
            
            imodel.addInsurance(insurance);
            mc.ncController.refresh();
            
            travelInsurance.clearFields();
            success();
        }
    }// end of registerTravel()
    public void registerHouse()
    {
          // Validation
        String s = "";
        
        if(houseInsurance.getAdress().equals(""))
            s+="Adresse\n";
        if(houseInsurance.getYearBuilt().equals("")||!houseInsurance.getYearBuilt().matches(Constants.ONLY_NUMBERS))
            s+="Byggeår\n";
        if(houseInsurance.getType().equals(""))
            s+="Hustype\n";
        if(houseInsurance.getMaterial().equals(""))
            s+="Materiale\n";
        if(houseInsurance.getStandard().equals(""))
            s+="Standard\n";
        if(houseInsurance.getHouseSize().equals("")||!houseInsurance.getHouseSize().matches(Constants.ONLY_NUMBERS))
            s+="Størrelse\n";
        if(houseInsurance.getAmountBuilding().equals("")||!houseInsurance.getAmountBuilding().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringsbeløp, bygg\n";
        if(houseInsurance.getAmountContents().equals("")||!houseInsurance.getAmountContents().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringsbeløp, innbo\n";
        if(houseInsurance.getPremium().equals("")||!houseInsurance.getPremium().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringspremie\n";
        if(houseInsurance.getConditions().equals(""))
            s+="Betingelser\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
            HouseInsurance insurance = new HouseInsurance();
            
            insurance.setOwnerId(id);
            insurance.setAddress(houseInsurance.getAdress());
            insurance.setYearofconstruction(Integer.parseInt(houseInsurance.getYearBuilt()));
            insurance.setBuildingType(houseInsurance.getType());
            insurance.setConstrutionmaterial(houseInsurance.getMaterial());
            insurance.setStandard(houseInsurance.getStandard());
            insurance.setSquaremeter(Integer.parseInt(houseInsurance.getHouseSize()));
            insurance.setBuildingcoverage(Double.parseDouble(houseInsurance.getAmountBuilding()));
            insurance.setContentscoverage(Double.parseDouble(houseInsurance.getAmountContents()));
            insurance.setPrice(Double.parseDouble(houseInsurance.getPremium()));
            insurance.setConditions(houseInsurance.getConditions());
            
            imodel.addInsurance(insurance);
            success();
        }
    }
    public void registerLeisure()
    {   
              
        // Validation
        String s = "";
        
        if(leisureHouseInsurance.getAdress().equals(""))
            s+="Adresse\n";
        if(leisureHouseInsurance.getYearBuilt().equals("")||!leisureHouseInsurance.getYearBuilt().matches(Constants.ONLY_NUMBERS))
            s+="Byggeår\n";
        if(leisureHouseInsurance.getType().equals(""))
            s+="Hustype\n";
        if(leisureHouseInsurance.getMaterial().equals(""))
            s+="Materiale\n";
        if(leisureHouseInsurance.getStandard().equals(""))
            s+="Standard\n";
        if(leisureHouseInsurance.getHouseSize().equals("")||!leisureHouseInsurance.getHouseSize().matches(Constants.ONLY_NUMBERS))
            s+="Størrelse\n";
        if(leisureHouseInsurance.getAmountBuilding().equals("")||!leisureHouseInsurance.getAmountBuilding().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringsbeløp, bygg\n";
        if(leisureHouseInsurance.getAmountContents().equals("")||!leisureHouseInsurance.getAmountContents().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringsbeløp, innbo\n";
        if(leisureHouseInsurance.getPremium().equals("")||!leisureHouseInsurance.getPremium().matches(Constants.ONLY_NUMBERS))
            s+="Forsikringspremie\n";
        if(leisureHouseInsurance.getConditions().equals(""))
            s+="Betingelser\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
            LeisureHouseInsurance insurance = new LeisureHouseInsurance();
            insurance.setOwnerId(id);
            insurance.setAddress(leisureHouseInsurance.getAdress());
            insurance.setYearofconstruction(Integer.parseInt(leisureHouseInsurance.getYearBuilt()));
            insurance.setBuildingType(leisureHouseInsurance.getType());
            insurance.setConstrutionmaterial(leisureHouseInsurance.getMaterial());
            insurance.setStandard(leisureHouseInsurance.getStandard());
            insurance.setSquaremeter(Integer.parseInt(leisureHouseInsurance.getHouseSize()));
            insurance.setBuildingcoverage(Double.parseDouble(leisureHouseInsurance.getAmountBuilding()));
            insurance.setContentscoverage(Double.parseDouble(leisureHouseInsurance.getAmountContents()));
            insurance.setPrice(Double.parseDouble(leisureHouseInsurance.getPremium()));
            insurance.setConditions(leisureHouseInsurance.getConditions());
            insurance.setIsForRent(leisureHouseInsurance.getLease());
            
            imodel.addInsurance(insurance);
            success();
        }
    }
    
    private void success()
    {
        JOptionPane.showMessageDialog(mc.view, "Forsikring registrert!");
    }
    
   
    
    private String validateInt(String s, String err)
    {
        try
        {
            Integer.parseInt(s);
            return "";
        }
        catch(NumberFormatException e)
        {
            return err;
        }
    }
    private String validateDouble(String s, String err)
    {
        try
        {
            Double.parseDouble(s);
            return "";
        }
        catch(NumberFormatException e)
        {
            return err;
        }
    }
    private void viewCarInsurance(CarInsurance ins)
    {
        carInsurance = new NewCarInsurance();
        carInsurance.addCustomListener(this);
        
        carInsurance.setViewMode();
        
        carInsurance.setCarOwner(ins.getViechleOwner());
        carInsurance.setRegNr(ins.getRegistrationNumber());
        carInsurance.setCarType(ins.getCarType());
        carInsurance.setModel(ins.getModel());
        carInsurance.setHorsepower(Integer.toString(ins.getPower()));
        carInsurance.setRegYear(Integer.toString(ins.getRegistrationYear()));
        carInsurance.setKmPerYear(Integer.toString(ins.getKmPerYear()));
        carInsurance.setPricePerKm(Double.toString(ins.getPricePrKm()));
        carInsurance.setPremium(Double.toString(ins.getPrice()));
        carInsurance.setConditions(ins.getConditions());
        carInsurance.setBonus(Integer.toString(ins.getBonus()));
        carInsurance.setAmount(Double.toString(ins.getCoverage()));
        
        
        
        mc.popUp("CarInsurance", carInsurance);
    }
    
    private void viewBoatInsurance(BoatInsurance ins)
    {
        boatInsurance = new NewBoatInsurance();
        boatInsurance.addCustomListener(this);
        
        boatInsurance.setViewMode();
        
        boatInsurance.setBoatOwner(ins.getViechleOwner());
        boatInsurance.setRegNr(ins.getRegistrationNumber());
        boatInsurance.setType(ins.getViechleType());
        boatInsurance.setModel(ins.getModel());
        boatInsurance.setEngineType(ins.getEngineType());
        boatInsurance.setHorsePower(Integer.toString(ins.getPower()));
        boatInsurance.setLength(Integer.toString(ins.getLength()));
        boatInsurance.setModelYear(Integer.toString(ins.getModelYear()));
        boatInsurance.setAmount(Double.toString(ins.getCoverage()));
        boatInsurance.setPremium(Double.toString(ins.getPrice()));
        boatInsurance.setConditions(ins.getConditions());
        
        
        
        
        mc.popUp("BoatInsurance", boatInsurance);
        
        
    }
    
    private void viewLeisureHouseInsurance(LeisureHouseInsurance ins)
    {
        
    }
    private void viewHouseInsurance(HouseInsurance ins)
    {
        
    }
    private void viewTravelInsurance(TravelInsurance ins)
    {
        
    }
    
    
    public void viewInsurance(int id) {
        Insurance ins = imodel.findById(id);
        
        this.insuranceId = ins.getId();
        
        if(ins!=null)
        {
            if(ins instanceof CarInsurance)           
                viewCarInsurance((CarInsurance)ins);
            if(ins instanceof BoatInsurance)
                viewBoatInsurance((BoatInsurance)ins);
            if(ins instanceof LeisureHouseInsurance)
                viewLeisureHouseInsurance((LeisureHouseInsurance)ins);
            if(ins instanceof HouseInsurance)
                viewHouseInsurance((HouseInsurance)ins);
            if(ins instanceof TravelInsurance)
                viewTravelInsurance((TravelInsurance)ins);
            
        }
        else 
        {
            JOptionPane.showMessageDialog(null, Constants.GENERAL_ERROR_MESSAGE);
        }
    }
    
    public void deleteInsurance()
    {
        if(this.insuranceId!=0)
        {
            Insurance ins = imodel.findById(insuranceId);
            JOptionPane.showConfirmDialog(mc.view, "Er du sikker på at du vil avslutte denne forsikringen?");
            ins.delete();
        }
    }
    @Override
    public void customActionPerformed(CustomEvent i) {
        if(i.getAction()==Constants.CAR_INSURANCE_INT)
            registerCar();
        if(i.getAction()==Constants.BOAT_INSURANCE_INT)
            registerBoat();
        if(i.getAction()==Constants.HOUSE_INSURANCE_INT)
            registerHouse();
        if(i.getAction()==Constants.LEISUREHOUSE_INSURANCE_INT)
            registerLeisure();
        if(i.getAction()==Constants.TRAVEL_INSURANCE_INT)
            registerTravel();
        if(i.getAction()==Constants.DELETE_INSURANCE)
            deleteInsurance();
        
    }// end of customAc
    
}// end of class
