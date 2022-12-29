/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.repositories;

import com.alten.test.entities.Chambre;
import com.alten.test.entities.Reservation;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author admin
 */
public interface ChambreRepository  extends  JpaRepository<Chambre, Integer>{
    
}
