/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;

import com.hasz.dao.ClienteFisicoDAO;
import com.hasz.dao.HotelDAO;
import com.hasz.dao.QuartoDAO;
import com.hasz.dao.ServicoDAO;
import com.hasz.model.Cliente;
import com.hasz.model.Hotel;
import com.hasz.model.Quarto;
import com.hasz.model.Reserva;
import com.hasz.model.Servico;
import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@ApplicationScoped
public class HotelBean {

    private Hotel hotel = new Hotel();
    private List<Hotel> hoteis = new ArrayList<Hotel>();
    private List<Servico> servicosselecionados = new ArrayList<Servico>();
    private List<Servico> servicos = new ArrayList<Servico>();
    private List<Quarto> quartos = new ArrayList<Quarto>();
    private Quarto quarto = new Quarto();
    private Reserva reserva;
    private Cliente cliente;

    public HotelBean() {
        hoteis=HotelDAO.listaHoteis();
        servicos=ServicoDAO.listarServicos();
        cliente = ClienteFisicoDAO.buscarClienteFisicoById(42);
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public List<Hotel> getHoteis() {
        return hoteis;
    }

    public void setHoteis(List<Hotel> hoteis) {
        this.hoteis = hoteis;
    }

    /**
     *
     * @return
     */
    public List<Hotel> listaHoteis() {
        return getHoteis();
    }

    public void updateQuartosDisponiveis(AjaxBehaviorEvent event) {
        if (getHotel() != null) {
            setQuartos(QuartoDAO.listaQuartosByIdHotel(getHotel().getIdHotel()));
        } else {
            setQuartos(new ArrayList<Quarto>());
        }
    }
    
    public void criarReserva(){
        
    }

    /**
     * @return the servicosselecionados
     */
    public List<Servico> getServicosselecionados() {
        return servicosselecionados;
    }

    /**
     * @param servicosselecionados the servicosselecionados to set
     */
    public void setServicosselecionados(List<Servico> servicosselecionados) {
        this.servicosselecionados = servicosselecionados;
    }

    /**
     * @return the servicos
     */
    public List<Servico> getServicos() {
        return servicos;
    }

    /**
     * @param servicos the servicos to set
     */
    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    /**
     * @return the quartos
     */
    public List<Quarto> getQuartos() {
        return quartos;
    }

    /**
     * @param quartos the quartos to set
     */
    public void setQuartos(List<Quarto> quartos) {
        this.quartos = quartos;
    }

    /**
     * @return the quarto
     */
    public Quarto getQuarto() {
        return quarto;
    }

    /**
     * @param quarto the quarto to set
     */
    public void setQuarto(Quarto quarto) {
        this.quarto = quarto;
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

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
