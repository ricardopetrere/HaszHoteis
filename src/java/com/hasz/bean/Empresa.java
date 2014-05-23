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
@Table(name = "Empresa")
public class Empresa implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmpresa")
    private int idEmpresa;
    
    @Column(length = 80)
    private String nome;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEndereco",insertable = true,updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Endereco endereco;
    
    @OneToMany(mappedBy = "empresa",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Hotel> hotel = new HashSet<Hotel>();

    /**
     * @return the idEmpresa
     */
    public int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * @param idEmpresa the idEmpresa to set
     */
    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * @return the EmpresaNome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the EmpresaNome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the UF
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the UF to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
