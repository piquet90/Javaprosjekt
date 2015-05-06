/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package Test;

import DAO.Constants;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author rudiwyu
 */
public class RegExTest {
    
    public static void main(String[]args)
    {
        String pattern = Constants.ONLY_ALPHABETIC;
        Pattern p = Pattern.compile(Constants.AREA_CODE);
        Matcher matcher = p.matcher("1231");
        if(matcher.matches())
            System.out.println("test");

       
    }
    
}
