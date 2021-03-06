/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ClienteJuridico")
@PrimaryKeyJoinColumn(name = "idCliente")
public class ClienteJuridico extends Cliente{

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "idCliente")
//    private int idCliente;

    @Size(min = 1, max = 100)
    @Column(length = 100)
    private String razaosocial;

    @Column(length = 18)
    private String cnpj;

    /**
     * @return the razaosocial
     */
    public String getRazaosocial() {
        return razaosocial;
    }

    /**
     * @param razaosocial the razaosocial to set
     */
    public void setRazaosocial(String razaosocial) {
        this.razaosocial = razaosocial;
    }

    /**
     * @return the cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}