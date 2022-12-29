/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.services;

import com.alten.test.entities.Chambre;
import java.util.List;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author admin
 */
public interface ChambreService {
    public List<Chambre> getAll();
    public Chambre getOne(Integer id);
    public Chambre insert(Chambre c);
    public Chambre update(Integer id,Chambre c);
    public void delete(Integer id);
    
}
