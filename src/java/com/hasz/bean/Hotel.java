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
@Table(name = "Hotel")
public class Hotel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idHotel")
    private int idHotel;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEmpresa", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Empresa empresa;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEndereco", insertable = true, updatable = true)
    @Fetch(FetchMode.JOIN)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Endereco endereco;
    
    @Column(length = 75)
    private String nomeFilial;
    
    @Column(name = "estrelas")
    private int estrelas;
    
    @Column(name = "quantidadeQuartos")
    private int quantidadeQuartos;
    
    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Quarto> quarto = new HashSet<Quarto>();
    
    @OneToMany(mappedBy = "hotel",fetch = FetchType.LAZY)
    @Cascade(CascadeType.SAVE_UPDATE)
    private Set<Reserva> reserva = new HashSet<Reserva>();

    /**
     * @return the idHotel
     */
    public int getIdHotel() {
        return idHotel;
    }

    /**
     * @param idHotel the idHotel to set
     */
    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    /**
     * @return the empresa
     */
    public Empresa getEmpresa() {
        return empresa;
    }

    /**
     * @param empresa the empresa to set
     */
    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    /**
     * @return the HotelNomeOficial
     */
    public String getNomeFilial() {
        return nomeFilial;
    }

    /**
     * @param nomeFilial the HotelNomeOficial to set
     */
    public void setNomeFilial(String nomeFilial) {
        this.nomeFilial = nomeFilial;
    }

    /**
     * @return the HotelEstrelas
     */
    public int getEstrelas() {
        return estrelas;
    }

    /**
     * @param estrelas the HotelEstrelas to set
     */
    public void setEstrelas(int estrelas) {
        this.estrelas = estrelas;
    }

    /**
     * @return the HotelQtdQuartos
     */
    public int getQuantidadeQuartos() {
        return quantidadeQuartos;
    }

    /**
     * @param quantidadeQuartos the HotelQtdQuartos to set
     */
    public void setQuantidadeQuartos(int quantidadeQuartos) {
        this.quantidadeQuartos = quantidadeQuartos;
    }

    /**
     * @return the HotelEndereco
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the HotelEndereco to set
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the quarto
     */
    public Set<Quarto> getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Set<Quarto> quarto) {
        this.quarto = quarto;
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