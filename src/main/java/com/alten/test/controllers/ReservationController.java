/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.controllers;

import com.alten.test.entities.Chambre;
import com.alten.test.entities.Reservation;
import com.alten.test.servicesImpl.ChambreServiceImpl;
import com.alten.test.servicesImpl.ReservationServiceImpl;
import com.alten.test.utils.Check;
import com.alten.test.utils.Datemanipulation;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */
@ComponentScan
@RestController

public class ReservationController {
    
    @Autowired
    private ChambreServiceImpl chambreserviceimpl;
    @Autowired
    private ReservationServiceImpl reservationserviceimpl;
     
    //faire une reservation
    @RequestMapping(value = "/api/front/reserve",method = RequestMethod.POST)
    public ResponseEntity<Reservation> reserve(@RequestBody Reservation r)
    {
         System.out.println("r "+r.getEmail());
         Integer id=r.getIdChambre().getIdChambre();
         System.out.println("r.getIdChambre().getIdChambre() "+r.getIdChambre().getIdChambre());
         System.out.println("r.getDateEntree() "+r.getDateEntree().getTime());
         System.out.println("r.r.getDateReservation()() "+r.getDateReservation().getTime());
         int i=0;
         int j=0;
         if(r.getNombrejour()<=3)
         {
            if(Datemanipulation.calculjour(r.getDateReservation(), r.getDateEntree())<=30)
            {
                List <Reservation> listreservation=reservationserviceimpl.getreservationencour();
                for (Reservation object : listreservation) {
                    j++;
                    if(object.getDateEntree().compareTo(r.getDateEntree())<0 && object.getDateSortie().compareTo(r.getDateEntree())<0)
                    {
                        i++;
                    }
                    else if(object.getDateEntree().compareTo(r.getDateEntree())>0 && object.getDateEntree().compareTo(r.getDateSortie())>0)
                    {
                         i++;
                    }
                }
                if(i==j)
                {
                    r.setClose(false);
                 r.setDateSortie(Datemanipulation.calculdateSortie(r.getDateEntree(), r.getNombrejour()+1));
                Reservation rer=this.reservationserviceimpl.insert(r);
                return new ResponseEntity<>(rer, HttpStatus.CREATED);
                }
            }
         }
         
        return new ResponseEntity<>( HttpStatus.NOT_ACCEPTABLE);         
        
    }
    //check 
     @RequestMapping(value = "/api/front/check",method = RequestMethod.GET)
    public ResponseEntity<List<Check>> check()
    {
        Check c=new Check();
        List<Check>listcheck=new ArrayList();
        List <Reservation> listereserve=this.reservationserviceimpl.getreservationencour();
         for (Reservation object : listereserve) {
             c.setDateentree(object.getDateEntree());
              c.setDatesortie(object.getDateSortie());
              listcheck.add(c);
         }
         if (listcheck.size()>0) {
            return new ResponseEntity <> (listcheck,HttpStatus.OK);  
        }
         return new ResponseEntity <> (HttpStatus.NO_CONTENT);
    }
    //modification de la reservation
      @RequestMapping(value = "/api/front/modifreserve/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Reservation> modifyreservation(@PathVariable Integer id,@RequestBody Reservation r)
    {
        Reservation rold= this.reservationserviceimpl.getOne(id);
       if(rold!=null)
       {
           if (rold.getDateEntree().compareTo(Datemanipulation.datelocal())>0 && rold.isClose()==false)
           {
               int i=0;
         int j=0;
         if(r.getNombrejour()<=3)
         {
            if(Datemanipulation.calculjour(r.getDateReservation(), r.getDateEntree())<=30)
            {
                List <Reservation> listreservation=reservationserviceimpl.getreservationencour();
                for (Reservation object : listreservation) {
                    if(rold.getIdReservation()!= object.getIdReservation()){
                    j++;
                    if(object.getDateEntree().compareTo(r.getDateEntree())<0 && object.getDateSortie().compareTo(r.getDateEntree())<0)
                    {
                        i++;
                    }
                    else if(object.getDateEntree().compareTo(r.getDateEntree())>0 && object.getDateEntree().compareTo(r.getDateSortie())>0)
                    {
                         i++;
                    }
                }
                    System.out.println("i "+i+"  j"+j);
                if(i==j)
                {
                    r.setClose(false);
                 r.setDateSortie(Datemanipulation.calculdateSortie(r.getDateEntree(), r.getNombrejour()+1));
              this.reservationserviceimpl.update(id, r);
               return  new ResponseEntity<>(HttpStatus.OK);
                }
            }
         }
              
           }
           }
       }
      return  new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
    
      @RequestMapping(value = "/api/front/deletereserve/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Reservation>cancelreservation(@PathVariable Integer id)
    {
       Reservation r= this.reservationserviceimpl.getOne(id);
       if(r!=null)
       {
           if (r.getDateEntree().compareTo(Datemanipulation.datelocal())>0 && r.isClose()==false)
           {
               this.reservationserviceimpl.delete(id);
               return new ResponseEntity<>(HttpStatus.NO_CONTENT);
           }
       }
         return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }    
}