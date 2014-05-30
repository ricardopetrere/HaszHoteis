/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
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
@Table(name = "Servico")
public class Servico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServico")
    private int idServico;
    
    @Column(length = 100)
    private String descricao;
    
    @OneToMany(mappedBy = "servico",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<AlteracaoPrecoServico> alteracaoPrecoServico = new HashSet<AlteracaoPrecoServico>();
    
    /**
     * @return the idServico
     */
    public int getIdServico() {
        return idServico;
    }

    /**
     * @param idServico the idServico to set
     */
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    /**
     * @return the TipoServico
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the TipoServico to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the alteracaoPrecoServico
     */
    public Set<AlteracaoPrecoServico> getAlteracaoPrecoServico() {
        return alteracaoPrecoServico;
    }

    /**
     * @param alteracaoPrecoServico the alteracaoPrecoServico to set
     */
    public void setAlteracaoPrecoServico(Set<AlteracaoPrecoServico> alteracaoPrecoServico) {
        this.alteracaoPrecoServico = alteracaoPrecoServico;
    }
}


//    /**
//     * @return the reservaservico
//     */
//    public Set<ReservaServico> getReservaservico() {
//        return reservaservico;
//    }
//
//    /**
//     * @param reservaservico the reservaservico to set
//     */
//    public void setReservaservico(Set<ReservaServico> reservaservico) {
//        this.reservaservico = reservaservico;
//    }