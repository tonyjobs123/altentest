/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 *
 * @author admin
 */

@Entity
@Table
public class Chambre implements Serializable {
    
    @Id
    @Column(name = "id_chambre")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer idChambre;
    @Column
    private String numero;
     @Column(name = "prix_chambre")
    private double prixChambre;
      @Column
      private boolean active;
    @OneToMany(mappedBy = "idChambre")
    private List<Reservation> reservationlist;
    public Chambre() {
    }

    
    
    public Integer getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Integer idChambre) {
        this.idChambre = idChambre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getPrixChambre() {
        return prixChambre;
    }

    public void setPrixChambre(double prixChambre) {
        this.prixChambre = prixChambre;
    }

    public List<Reservation> getReservationlist() {
        return reservationlist;
    }

    public void setReservationlist(List<Reservation> reservationlist) {
        this.reservationlist = reservationlist;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    
     
}
