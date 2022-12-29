/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.utils;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;

/**
 *
 * @author admin
 */
public class Datemanipulation {
    
    public static int calculjour(Date date1,Date date2)
    {
       long difference=(date2.getTime() - date1.getTime());
       return (int)(difference / (1000*60*60*24));
    }
    public static Date calculdateSortie(Date date1,int nbJour)
    {
       long somme=(date1.getTime() +(1000*60*60*24)* nbJour);
       return new Date(somme);
    }
    
    public static Date datelocal()
    {
          LocalDate todaysDate = LocalDate.now();
            Date date = Date.from(todaysDate.atStartOfDay().toInstant(ZoneOffset.UTC));
        return date;
    }
}
