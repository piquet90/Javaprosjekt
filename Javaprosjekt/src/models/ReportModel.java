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
    
    HashSet<Report> reports;
    
    // todo: write comments
    public ReportModel(Registries r)
    {
        this.reports = r.getReports();
    }
    
    public void addReport(Report r)
    {
        reports.add(r);
    }
    
    public Report findById(int id)
    {
        Iterator<Report> it = reports.iterator();
        while(it.hasNext())
        {
            Report r = it.next();
            if(r.getId()==id)
                return r;
        }
        return null;
    }
    public HashSet<Report> getReportsByCustomerId(int id)
    {
        HashSet<Report> result = new HashSet<>();
        Iterator<Report> it = reports.iterator();
        
        while(it.hasNext())
        {
            Report r = it.next();
            if(r.getOwnerId()==id)
                result.add(r);
        }
        
        return result;
        
    }
    
    
}

