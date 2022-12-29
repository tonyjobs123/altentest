/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alten.test.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author admin
 */
@Entity
@Table
public class Reservation implements Serializable {
    
    @Id
    @Column(name = "id_reservation")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Integer idReservation;
    
    @Column(name = "date_reservation")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateReservation;
    @Column(name = "date_entree")
    @Temporal(javax.persistence.TemporalType.DATE)
private Date dateEntree;
    @Column(name = "date_sortie")
   
    @Temporal(javax.persistence.TemporalType.DATE)
private Date dateSortie;
    
    @JoinColumn(name = "id_chambre",referencedColumnName = "id_chambre")
    @ManyToOne(optional = false)
    private Chambre idChambre;
     @Column(name = "nombrejour")
     private int nombrejour;
     @Column(name = "close")
     private boolean close;
     @Column(name = "nom_complet")
    private String nomComplet; 
    @Column
    private String email;
    @Column
    private String adresse;
    @Column
    private String telephone;
    public Reservation() {
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public Date getDateSortie() {
        return dateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.dateSortie = dateSortie;
    }

    public Chambre getIdChambre() {
        return idChambre;
    }

    public void setIdChambre(Chambre idChambre) {
        this.idChambre = idChambre;
    }

  

    public int getNombrejour() {
        return nombrejour;
    }

    public void setNombrejour(int nombrejour) {
        this.nombrejour = nombrejour;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
}
