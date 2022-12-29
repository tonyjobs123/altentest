/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.services;

import com.alten.test.entities.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author admin
 */
public interface ReservationService {
       public List<Reservation> getAll();
    public Reservation getOne(Integer id);
    public Reservation insert(Reservation c);
      public Reservation update(Integer id,Reservation r);
    public List<Reservation> getreservationencour();
    public void delete(Integer id);
}
