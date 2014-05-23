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
@Table(name = "AlteracaoPrecoServico")
public class AlteracaoPrecoServico implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAlteracaoPrecoServico;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "idServico",insertable = true,updatable = true)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Servico servico;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data;
    
    private float preco;

    /**
     * @return the id
     */
    public int getIdAlteracaoPrecoServico() {
        return idAlteracaoPrecoServico;
    }

    /**
     * @param idAlteracaoPrecoServico the idAlteracao to set
     */
    public void setIdAlteracaoPrecoServico(int idAlteracaoPrecoServico) {
        this.idAlteracaoPrecoServico = idAlteracaoPrecoServico;
    }

    /**
     * @return the idServico
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * @param servico the idServico to set
     */
    public void setServico(Servico servico) {
        this.servico = servico;
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
     * @return the preco
     */
    public float getPreco() {
        return preco;
    }

    /**
     * @param preco the preco to set
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
