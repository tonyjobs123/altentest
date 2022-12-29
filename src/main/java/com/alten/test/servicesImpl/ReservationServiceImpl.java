/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.servicesImpl;

import com.alten.test.entities.Reservation;
import com.alten.test.repositories.ReservationRepository;
import com.alten.test.services.ReservationService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class ReservationServiceImpl implements ReservationService{
    
    @Autowired
    private ReservationRepository reservationrepository;

    @Override
    public List<Reservation> getAll() {
        return this.reservationrepository.findAll();
    }

    @Override
    public Reservation getOne(Integer id) {
       return this.reservationrepository.findById(id).get();
    }

    @Override
    public Reservation insert( Reservation c) {
        return this.reservationrepository.save(c);
    }

    @Override
    public void delete(Integer id) {
        this.reservationrepository.deleteById(id);
    }

    @Override
    public List<Reservation> getreservationencour() {
        return this.reservationrepository.findAllByClose();
    }

    @Override
    public Reservation update(Integer id, Reservation r) {
        Optional <Reservation> old= this.reservationrepository.findById(id);
        if (old.isPresent()) {
            Reservation oldreserv=old.get();
            oldreserv.setAdresse(r.getAdresse());
            oldreserv.setDateEntree(r.getDateEntree());
            oldreserv.setEmail(r.getEmail());
            oldreserv.setNomComplet(r.getNomComplet());
            oldreserv.setNombrejour(r.getNombrejour());
            oldreserv.setTelephone(r.getTelephone());
            
       return reservationrepository.save(oldreserv);
    }   
        return null;
    }
    
}
