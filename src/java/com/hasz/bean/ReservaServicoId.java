/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.bean;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Admin
 */
@Embeddable
class ReservaServicoId implements Serializable {
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idReserva", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Reserva reserva;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="idServico", nullable=false)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Servico servico;

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

    /**
     * @return the servico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the servico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }
}
