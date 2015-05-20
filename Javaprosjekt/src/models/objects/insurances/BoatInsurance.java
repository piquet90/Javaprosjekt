package models.objects.insurances;

/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */


import DAO.Constants;
import models.objects.insurances.VehicleInsurance;

/**
 *
 * @author rudiwyu
 */
public class BoatInsurance extends VehicleInsurance{

    private String engineType;
    private int modelYear, length;
    
    /**
     * Returns the boat model year
     * @return model year
     */
    public int getModelYear() {
        return modelYear;
    }

    /**
     * Sets the boats model year
     * @param modelYear boats model year
     */
    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    /**
     * Returns the boats length
     * @return boat length in feet
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the boats length
     * @param length in feet
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns the boats engine type
     * @return engine type
     */
    public String getEngineType() {
        return engineType;
    }

    /**
     * Sets the engine type
     * @param engineType the boats engine type
     */
    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
    
    /**
     * Returns the insurance type
     * @return boat insurance
     */
    public String getType()
    {
        return Constants.BOAT_INSURANCE;
    }
    
    


    
}
