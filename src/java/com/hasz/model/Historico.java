/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.model;

import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;
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
@Table(name = "Historico")
public class Historico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHistorico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idReserva",insertable = true,updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Reserva reserva;
    
    @Temporal(TemporalType.DATE)
    private Date data;
    
    private int diasCorridos;

    /**
     * @return the id
     */
    public int getIdHistorico() {
        return idHistorico;
    }

    /**
     * @param idHistorico the id to set
     */
    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    /**
     * @return the data
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the diasCorridos
     */
    public int getDiasCorridos() {
        return diasCorridos;
    }

    /**
     * @param diasCorridos the diasCorridos to set
     */
    public void setDiasCorridos(int diasCorridos) {
        this.diasCorridos = diasCorridos;
    }

    /**
     * @return the reserva
     */
    public Reserva getReserva() {
        return reserva;
    }

    /**
     * @param reserva the reserva to set
     */
    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
