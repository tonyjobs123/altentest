/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.controllers;

import com.alten.test.entities.Chambre;
import com.alten.test.servicesImpl.ChambreServiceImpl;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
public class ChambreController {
    @Autowired
    private ChambreServiceImpl chambreserviceImpl;
    @RequestMapping(value = "api/backend/savechambre",method = RequestMethod.POST)
    public Chambre savechambre(@RequestBody Chambre c)
    {
        return this.chambreserviceImpl.insert(c);
    }
 
    @RequestMapping(value = "api/backend/updatechambre/{id}",method = RequestMethod.PUT)
    public Chambre updatechambre(@PathVariable Integer id,@RequestBody Chambre c)
    {
        return this.chambreserviceImpl.update(id, c);
    }
   
    
}
