/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.servicesImpl;

import com.alten.test.entities.Chambre;
import com.alten.test.repositories.ChambreRepository;
import com.alten.test.services.ChambreService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */

@Service
public class ChambreServiceImpl implements ChambreService{

    @Autowired
    private ChambreRepository chambrerepository;
    @Override
    public List<Chambre> getAll() {
   return this.chambrerepository.findAll();
    }

    @Override
    public Chambre getOne(Integer id) {
        Optional <Chambre> c= this.chambrerepository.findById(id);
        if(c.isPresent()){
        return c.get();
        }
        return null;
    }

    @Override
    public Chambre insert( Chambre c) {
        return this.chambrerepository.save(c);
    }

    @Override
    public void delete(Integer id) {
       this.chambrerepository.deleteById(id);
    }

    @Override
    public Chambre update(Integer id, Chambre c) 
    {
        Optional <Chambre> old= this.chambrerepository.findById(id);
        if (old.isPresent()) {
            Chambre oldchamb=old.get();
            oldchamb.setNumero(c.getNumero());
            oldchamb.setPrixChambre(c.getPrixChambre());
            oldchamb.setActive(c.isActive());
       return chambrerepository.save(oldchamb);
    }   
        return null;
}
}
