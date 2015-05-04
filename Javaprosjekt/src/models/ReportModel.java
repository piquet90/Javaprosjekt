/*
 * Made by
 * Rudi Yu s231776
 * Audun Brustad s236341
 */
package models;

import DAO.*;
import java.util.HashSet;
import java.util.Iterator;
import models.objects.insurances.Insurance;
/**
 *
 * @author rudiwyu
 */
public class ReportModel {
    
    HashSet<Insurance> insurances;
    
    // todo: write comments
    public ReportModel(Registries r)
    {
        this.insurances = r.getInsurances();
    }
    
    
}

