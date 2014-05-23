/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.bean;

import java.io.Serializable;
import java.util.Date;
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
@Table(name = "ReservaServico")
public class ReservaServico implements Serializable{
    @EmbeddedId
    private ReservaServicoId reservaServicoId;
    
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Date data;

    /**
     * @return the DataServico
     */
    public Date getData() {
        return data;
    }

    /**
     * @param data the DataServico to set
     */
    public void setData(Date data) {
        this.data = data;
    }

    /**
     * @return the reservaServicoId
     */
    public ReservaServicoId getReservaServicoId() {
        return reservaServicoId;
    }

    /**
     * @param reservaServicoId the reservaServicoId to set
     */
    public void setReservaServicoId(ReservaServicoId reservaServicoId) {
        this.reservaServicoId = reservaServicoId;
    }
}
