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
@Table(name="Cidade")
public class Cidade implements Serializable{

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.idCidade;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cidade other = (Cidade) obj;
        if (this.idCidade != other.idCidade) {
            return false;
        }
        return true;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCidade")
    private int idCidade;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEstado",insertable = true,updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Estado estado;
    
    @Column(length = 150)
    private String descricao;
    
    @OneToMany(mappedBy = "cidade",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Endereco> endereco = new HashSet<Endereco>();

    /**
     * @return the idCidade
     */
    public int getIdCidade() {
        return idCidade;
    }

    /**
     * @param idCidade the idCidade to set
     */
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    /**
     * @return the municipio
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the municipio to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }   

    /**
     * @return the endereco
     */
    public Set<Endereco> getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(Set<Endereco> endereco) {
        this.endereco = endereco;
    }
}