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
@Table(name = "Endereco")
public class Endereco implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEndereco;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCidade",insertable = true,updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Cidade cidade;
    
    @Column(length = 80)
    private String rua;
    
    private int numero;
    
    @Column(length = 80)
    private String bairro;
    
    @Column(length = 120)
    private String complemento;
    
    @Column(length = 9)
    private String cep;
    
    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Empresa> empresa = new HashSet<Empresa>();
    
    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Hotel> hotel = new HashSet<Hotel>();
    
    @OneToMany(mappedBy = "endereco",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Cliente> cliente = new HashSet<Cliente>();

    /**
     * @return the id
     */
    public int getIdEndereco() {
        return idEndereco;
    }

    /**
     * @param idEndereco the idEndereco to set
     */
    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the rua
     */
    public String getRua() {
        return rua;
    }

    /**
     * @param rua the rua to set
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the empresa
     */
    public Set<Empresa> getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Set<Empresa> empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the hotel
     */
    public Set<Hotel> getHotel() {
        return hotel;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Set<Hotel> hotel) {
        this.hotel = hotel;
    }

    /**
     * @return the cliente
     */
    public Set<Cliente> getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Set<Cliente> cliente) {
        this.cliente = cliente;
    }
}
