/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "Quarto")
public class Quarto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idQuarto;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idHotel",insertable = true,updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Hotel hotel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="idTipoQuarto",insertable = true,updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private TipoQuarto tipoQuarto;
    
    @Column(name = "numero")
    private int numero;
    
    @OneToMany(mappedBy = "quarto",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Reserva> reserva = new HashSet<Reserva>();

    /**
     * @return the idQuarto
     */
    public int getIdQuarto() {
        return idQuarto;
    }

    /**
     * @param idQuarto the idQuarto to set
     */
    public void setIdQuarto(int idQuarto) {
        this.idQuarto = idQuarto;
    }

    /**
     * @return the hotel
     */
    public Hotel getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    /**
     * @return the QuartoNro
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the QuartoNro to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the TipoQuarto
     */
    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    /**
     * @param TipoQuarto the TipoQuarto to set
     */
    public void setTipoQuarto(TipoQuarto TipoQuarto) {
        this.tipoQuarto = TipoQuarto;
    }

    /**
     * @return the reserva
     */
    public Set<Reserva> getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Set<Reserva> reserva) {
        this.reserva = reserva;
    }
}
