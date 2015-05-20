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
 * This class deals with editing and creating insurances.
 * 
 * @author Rudi
 */
public class InsuranceController implements CustomListener {
    
    private MainController mc;
    private InsuranceModel imodel;
    private CustomerModel cModel;
    
    private NewBoatInsurance boatInsurance;
    private NewCarInsurance carInsurance;
    private NewHouseInsurance houseInsurance;
    private NewLeisureHouseInsurance leisureHouseInsurance;
    private NewTravelInsurance travelInsurance;
    
    
    
    private int id, insuranceId;
    
    /**
     * Creates a new InsuranceController
     * @param r
     * @param c
     */
    public InsuranceController(Registries r, MainController c)
    {
        this.mc = c;
        imodel = new InsuranceModel(r);
        cModel = new CustomerModel(r);
    }
    
    /**
     * Opens a newCarInsuranceClass
     * @param id CustomerId
     */
    public void newCarInsurance(int id)
    {
        this.id = id;
        
        carInsurance = new NewCarInsurance();
        carInsurance.addCustomListener(this);
        carInsurance.setAmount(Constants.STANDARD_CAR_AMOUNT);
        carInsurance.setPremium(Constants.STANDARD_CAR_PREMIUM);
        carInsurance.setPricePerKm(Constants.STANDARD_CAR_PRICE_PER_KM);
        String s = this.cModel.findById(id).getName();
        carInsurance.setCarOwner(s);
        mc.popUp(carInsurance);
    }

    /**
     *
     * @param id CustomerId
     */
    public void newHouseInsurance(int id)
    {
        this.id = id;
        houseInsurance = new NewHouseInsurance();
        houseInsurance.addCustomListener(this);
        houseInsurance.setAmountBuilding(Constants.STANDARD_HOUSE_BUILDING_AMOUNT);
        houseInsurance.setPremium(Constants.STANDARD_HOUSE_PREMIUM);
        mc.popUp(houseInsurance);
    }

    /**
     *
     * @param id CustomerId
     */
    public void newBoatInsurance(int id)
    {
        this.id = id;
        boatInsurance = new NewBoatInsurance();
        boatInsurance.addCustomListener(this);
        boatInsurance.setAmount(Constants.STANDARD_BOAT_AMOUNT);
        boatInsurance.setPremium(Constants.STANDARD_BOAT_PREMIUM);
        String s = this.cModel.findById(id).getName();
        boatInsurance.setBoatOwner(s);
        mc.popUp(boatInsurance);
    }

    /**
     *
     * @param id CustomerId
     */
    public void newTravelInsurance(int id)
    {
        this.id = id;
        
        travelInsurance = new NewTravelInsurance();
        travelInsurance.setAmount(Constants.STANDARD_TRAVEL_AMOUNT);
        travelInsurance.setPremium(Constants.STANDARD_TRAVEL_PREMIUM);
        String s = this.cModel.findById(id).getName();
        travelInsurance.setInsTaker(s);
        travelInsurance.addCustomListener(this);
        mc.popUp(travelInsurance);
    }

    /**
     *
     * @param id CustomerId
     */
    public void newLeisureHouseInsurance(int id)
    {
        this.id = id;
        leisureHouseInsurance = new NewLeisureHouseInsurance();
        leisureHouseInsurance.addCustomListener(this);
        leisureHouseInsurance.setAmountBuilding(Constants.STANDARD_LEISURE_BUILDING_AMOUNT);
        leisureHouseInsurance.setAmountContents(Constants.STANDARD_LEISURE_CONTENTS_AMOUNT);
        leisureHouseInsurance.setPremium(Constants.STANDARD_LEISURE_PREMIUM);
        mc.popUp(leisureHouseInsurance);
    }
    
    /**
     * registers a start the correct kind of validation depending on if its a new registration or an edit.
     */
    public void registerCar()
    {
        if(!carInsurance.isViewMode())
            registerCar(new CarInsurance());
        else {
            registerCar((CarInsurance)imodel.findById(insuranceId));
        }
    }

    /**
     * Validates fields and updates the provided object.
     * @param in Object provided
     */
    public void registerCar(CarInsurance in)
    {
        CarInsurance insurance = in;
        
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
            insurance.setVehicleOwner(carInsurance.getCarOwner());//done
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
            
            if(!carInsurance.isViewMode())
            {
                carInsurance.clearFields();
                insurance.setOwnerId(id);
                imodel.addInsurance(insurance);
                
            }
                         
            mc.ncController.refresh();
            success();
        }
    }
    
    /**
     *
     */
    public void registerBoat()
    {
        if(!boatInsurance.isViewMode())
            registerBoat(new BoatInsurance());
        else {
            registerBoat((BoatInsurance)imodel.findById(insuranceId));
        }
    }
    
    /**
     * Validates fields and updates the provided object.
     * @param in Object provided
     */
    public void registerBoat(BoatInsurance in)
    {
        BoatInsurance insurance = in;
        
        
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
                
            insurance.setVehicleOwner(boatInsurance.getBoatOwner());
            insurance.setRegistrationNumber(boatInsurance.getRegNr());
            insurance.setModel(boatInsurance.getModel());
            insurance.setVehicleType(boatInsurance.getType());
            insurance.setEngineType(boatInsurance.getEngineType());
            insurance.setPower(Integer.parseInt(boatInsurance.getHorsepower()));
            insurance.setLength(Integer.parseInt(boatInsurance.getLength()));
            insurance.setModelYear(Integer.parseInt(boatInsurance.getModelYear()));
            insurance.setCoverage(Double.parseDouble(boatInsurance.getAmount()));
            insurance.setPrice(Double.parseDouble(boatInsurance.getPremium()));
            insurance.setConditions(boatInsurance.getConditions());
            
            if(!boatInsurance.isViewMode())
            {
                insurance.setOwnerId(id);
                boatInsurance.clearFields();
                imodel.addInsurance(insurance);
            }
            
            mc.ncController.refresh();
            success();
        }
    }// end of newBoat()
    
    /**
     *
     */
    public void registerTravel()
    {
        if(!travelInsurance.isViewMode())
            registerTravel(new TravelInsurance());
        else {
            registerTravel((TravelInsurance)imodel.findById(insuranceId));
        }
    }

    /**
     * Validates fields and updates the provided object.
     * @param in Object provided
     */
    public void registerTravel(TravelInsurance in)
    {
        
        TravelInsurance insurance = in;
        
        
        String s = "";
        if(travelInsurance.getInsTaker().equals(""))
            s+="Forsikringstaker\n";
        s+= validateDouble(travelInsurance.getAmount(), "Forsikringsbeløp\n" );
        s+= validateDouble(travelInsurance.getPremium(), "Forsikringspremie\n" );
       
        if(travelInsurance.getArea().equals(""))
            s+="Gyldige områder\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
            insurance.setPersonInsured(travelInsurance.getInsTaker());
            insurance.setCoverage(Double.parseDouble(travelInsurance.getPremium()));
            insurance.setPrice(Double.parseDouble(travelInsurance.getAmount()));
            insurance.setConditions(travelInsurance.getConditions());
            insurance.setArea(travelInsurance.getArea());
            travelInsurance.setValid(travelInsurance.getArea());
            
            if(!travelInsurance.isViewMode())
            {
                insurance.setOwnerId(id);
                travelInsurance.clearFields();
                imodel.addInsurance(insurance);
            }
            
            mc.ncController.refresh();
            success();
        }
    }// end of registerTravel()
    
    /**
     *
     */
    public void registerHouse()
    {
        if(!houseInsurance.isViewMode())
            registerHouse(new HouseInsurance());
        else {
            registerHouse((HouseInsurance)imodel.findById(insuranceId));
        }
    }

    /**
     * Validates fields and updates the provided object.
     * @param in Object provided
     */
    public void registerHouse(HouseInsurance in)
    {
        HouseInsurance insurance = in;
          // Validation
        String s = "";
        
        if(houseInsurance.getAdress().equals(""))
            s+="Adresse\n";
        s += validateInt(houseInsurance.getYearBuilt(), "Byggeår\n");
        if(houseInsurance.getType().equals(""))
            s+="Hustype\n";
        if(houseInsurance.getMaterial().equals(""))
            s+="Materiale\n";
        if(houseInsurance.getStandard().equals(""))
            s+="Standard\n";
        s += validateInt(houseInsurance.getHouseSize(), "Størrelse\n");
        s += validateDouble(houseInsurance.getAmountBuilding(), "Forsikringsbeløp, bygg\n");
        s += validateDouble(houseInsurance.getAmountContents(), "Forsikringsbeløp, innbo\n");
        s += validateDouble(houseInsurance.getPremium(), "Forsikringspremie\n");
        
        if(houseInsurance.getConditions().equals(""))
            s+="Betingelser\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
            
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
            
            if(!houseInsurance.isViewMode())
            {
                insurance.setOwnerId(id);
                houseInsurance.clearFields();
                imodel.addInsurance(insurance);
            }
            mc.ncController.refresh();
            success();
        }
    }
    
    /**
     *
     */
    public void registerLeisure()
    {
        if(!leisureHouseInsurance.isViewMode())
            registerLeisure(new LeisureHouseInsurance());
        else {
            registerLeisure((LeisureHouseInsurance)imodel.findById(insuranceId));
        }
    }

    /**
     * Validates fields and updates the provided object.
     * @param in Object provided
     */
    public void registerLeisure(LeisureHouseInsurance in)
    {   
              
        LeisureHouseInsurance insurance = in;
        // Validation
        String s = "";
        
        if(leisureHouseInsurance.getAdress().equals(""))
            s+="Adresse\n";
        s += validateInt(leisureHouseInsurance.getYearBuilt(), "Byggeår\n");
        if(leisureHouseInsurance.getType().equals(""))
            s+="Hustype\n";
        if(leisureHouseInsurance.getMaterial().equals(""))
            s+="Materiale\n";
        if(leisureHouseInsurance.getStandard().equals(""))
            s+="Standard\n";
        s += validateInt(leisureHouseInsurance.getHouseSize(), "Størrelse\n");
        s += validateDouble(leisureHouseInsurance.getAmountBuilding(), "Forsikringsbeløp, bygg\n");
        s += validateDouble(leisureHouseInsurance.getAmountContents(), "Forsikringsbeløp, innbo\n");
        s += validateDouble(leisureHouseInsurance.getPremium(), "Forsikringspremie\n");
        if(leisureHouseInsurance.getConditions().equals(""))
            s+="Betingelser\n";
        
        if(!s.equals(""))
            JOptionPane.showMessageDialog(null, "Vennligst korriger følgende felter:\n\n"+s);
        else {
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
            insurance.setIsForRent(leisureHouseInsurance.getIsForRent());
            
            if(!leisureHouseInsurance.isViewMode())
            {
                insurance.setOwnerId(id);
                leisureHouseInsurance.clearFields();
                imodel.addInsurance(insurance);
            }
            mc.ncController.refresh();
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
        
        carInsurance.setCarOwner(ins.getVehicleOwner());
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
        
        boatInsurance.setBoatOwner(ins.getVehicleOwner());
        boatInsurance.setRegNr(ins.getRegistrationNumber());
        boatInsurance.setType(ins.getVehicleType());
        boatInsurance.setModel(ins.getModel());
        boatInsurance.setEngineType(ins.getEngineType());
        boatInsurance.setHorsePower(Integer.toString(ins.getPower()));
        boatInsurance.setLength(Integer.toString(ins.getLength()));
        boatInsurance.setModelYear(Integer.toString(ins.getModelYear()));
        boatInsurance.setAmount(Double.toString(ins.getCoverage()));
        boatInsurance.setPremium(Double.toString(ins.getPrice()));
        boatInsurance.setConditions(ins.getConditions());
        
        
        
        
        mc.popUp("Båtforsikring", boatInsurance);
        
        
    }
    
    private void viewLeisureHouseInsurance(LeisureHouseInsurance ins)
    {
        leisureHouseInsurance = new NewLeisureHouseInsurance();
        leisureHouseInsurance.addCustomListener(this);
        
        leisureHouseInsurance.setViewMode();
        
        leisureHouseInsurance.setAdress(ins.getAddress());
        leisureHouseInsurance.setYearBuilt(Integer.toString(ins.getYearofconstruction()));
        leisureHouseInsurance.setType(ins.getBuildingType());
        leisureHouseInsurance.setMaterial(ins.getConstrutionmaterial());
        leisureHouseInsurance.setStandard(ins.getStandard());
        leisureHouseInsurance.setHouseSize(Integer.toString(ins.getSquaremeter()));
        leisureHouseInsurance.setAmountBuilding(Double.toString(ins.getBuildingcoverage()));
        leisureHouseInsurance.setAmountContents(Double.toString(ins.getContentscoverage()));
        leisureHouseInsurance.setPremium(Double.toString(ins.getPrice()));
        leisureHouseInsurance.setConditions(ins.getConditions());
        leisureHouseInsurance.setIsForRent(ins.getIsForRent());
        
        mc.popUp("Hus & Innboforsikring", leisureHouseInsurance);
    }
    private void viewHouseInsurance(HouseInsurance ins)
    {
        System.out.println("test");
        houseInsurance = new NewHouseInsurance();
        houseInsurance.addCustomListener(this);
        
        houseInsurance.setViewMode();
        
        houseInsurance.setAdress(ins.getAddress());
        houseInsurance.setYearBuilt(Integer.toString(ins.getYearofconstruction()));
        houseInsurance.setType(ins.getBuildingType());
        houseInsurance.setMaterial(ins.getConstrutionmaterial());
        houseInsurance.setStandard(ins.getStandard());
        houseInsurance.setHouseSize(Integer.toString(ins.getSquaremeter()));
        houseInsurance.setAmountBuilding(Double.toString(ins.getBuildingcoverage()));
        houseInsurance.setAmountContents(Double.toString(ins.getContentscoverage()));
        houseInsurance.setPremium(Double.toString(ins.getPrice()));
        houseInsurance.setConditions(ins.getConditions());
        
        mc.popUp("Hus & Innboforsikring", houseInsurance);
        
    }
    private void viewTravelInsurance(TravelInsurance ins)
    {
        travelInsurance = new NewTravelInsurance();
        travelInsurance.addCustomListener(this);
        
        travelInsurance.setViewMode();
        
        travelInsurance.setInsTaker(ins.getPersonInsured());
        travelInsurance.setValid(ins.getArea());
        travelInsurance.setAmount(Double.toString(ins.getCoverage()));
        travelInsurance.setConditions(ins.getConditions());
        travelInsurance.setPremium(Double.toString(ins.getPrice()));
        
        mc.popUp("Reiseforsikring", travelInsurance);
        
    }
    
    /**
     * find out what kind of insurance is provided and initiates the correct method according to insurance-type.
     * @param id InsuranceId
     */
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
    
    /**
     *
     */
    public void deleteInsurance()
    {
        if(this.insuranceId!=0)
        {
            Insurance ins = imodel.findById(insuranceId);
            int result = JOptionPane.showConfirmDialog(mc.view, "Er du sikker på at du vil avslutte denne forsikringen?", "Slette forsikring", JOptionPane.YES_NO_OPTION);
            if(result==JOptionPane.YES_OPTION)
                ins.delete();
            
        }
    }

    /**
     * CustomActionListener
     * @param i actionevent provided by events thrown by objects with this customlistener
     */
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
        if(i.getAction()==Constants.NEW_REPORT)        
            mc.rController.newReport(this.insuranceId);
        
        
    }// end of customAc
    
}// end of class
