/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

/**
 *
 * @author rudiwyu
 */
public class Constants {
    
    public static final int TOTALCUSTOMER_REQUIRMENT = 3;
    
    public static final String STANDARD_CAR_AMOUNT = "500000.00";
    public static final String STANDARD_CAR_PREMIUM = "20000.00";
    public static final String STANDARD_CAR_PRICE_PER_KM = "0.50";
    
    public static final String STANDARD_BOAT_AMOUNT = "1000000.00";
    public static final String STANDARD_BOAT_PREMIUM = "40000.00";
    
    public static final String STANDARD_HOUSE_BUILDING_AMOUNT = "7000000.00";
    public static final String STANDARD_HOUSE_CONTENTS_AMOUNT = "1000000.00";
    public static final String STANDARD_HOUSE_PREMIUM = "10000.00";
    
    public static final String STANDARD_LEISURE_BUILDING_AMOUNT = "3000000.00";
    public static final String STANDARD_LEISURE_CONTENTS_AMOUNT = "900000.00";
    public static final String STANDARD_LEISURE_PREMIUM = "3500.00";
    
    public static final String STANDARD_TRAVEL_AMOUNT = "1000000.00";
    public static final String STANDARD_TRAVEL_PREMIUM = "1000";
    
    
    
    
    
    
    
    
    /**
     *
     */
    
    public static final String APP_NAME = "Evil Insurance Co.";
    public static final String NEW_CUSTOMER_TEXT = "Ny Kunde";
    public static final String NEW_INSURANCE_TEXT = "Ny Forsikring";
    
    public static final String GENERAL_ERROR_MESSAGE = "Oops, looks like something went wrong. Please try again. If the problem persists, please contact your system administrator";
    public static final String FILE_SAVE_PATH = "src/liste.data";
    
    public static final int INSURANCE_NEXT_START_NUMBER = 1;
    public static final int CUSTOMER_NEXT_START_NUMBER = 1;
    public static final int REPORT_NEXT_START_NUMBER = 1;
    public static final int FRAME_WIDTH = 1100;
    public static final int FRAME_HEIGHT = 720;
    public static final int SCROLL_SPEED = 18;
    public static final int NULL = 0;
    
    
    // Action Commands
    public static final int DOUBLECLICK = 22222223;
    public static final int DOUBLECLICK_REPORT = 22222222;
    public static final int DOUBLECLICK_INSURANCE = 22222221;
    public static final int REGISTER_BUTTON_PRESSED = 11111111;
    
    // Action preset values
    public static final int NEW_CUSTOMER = 12345678;
    public static final int NEW_INSURANCE = 87654321;
    public static final int NEW_REPORT = 11223344;
    public static final int SIMPLE_SEARCH = 1231231231;
    
    public static final int SEARCH_CUSTOMER = 129128192;
    public static final int SHOW_ALL_CUSTOMERS = 9901;
    public static final int ADVANCED_SEARCH = 129219381;
    
    
    public static final int DELETE_INSURANCE = 43892738;
    
    
    public static final String BOAT_INSURANCE = "BÂtforsikring";
    public static final String CAR_INSURANCE = "Bilforsikring";
    public static final String HOUSE_INSURANCE = "Hus og innboforsikring";
    public static final String LEISUREHOUSE_INSURANCE = "Fritidsboligforsikring";
    public static final String TRAVEL_INSURANCE = "Reiseforsikring";
    
    public static final int BOAT_INSURANCE_INT = 22;
    public static final int CAR_INSURANCE_INT = 23;
    public static final int HOUSE_INSURANCE_INT = 24;
    public static final int LEISUREHOUSE_INSURANCE_INT = 25;
    public static final int TRAVEL_INSURANCE_INT = 26;
    
            
    
    // regexs
    
    public static final String ONLY_ALPHABETIC = "^[Ê¯Â∆ÿ≈a-zA-Z]+$";

    public static final String ONLY_NUMBERS = "^(0\\.[1-9]|[1-9][0-9]{0,2}(\\.[1-9])?)$";
    public static final String AREA_CODE = "^[0-9]{4}$";

    
}
