/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;
import com.hasz.model.Hotel;
import java.util.ArrayList;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class HotelBean {
    /**
     * 
     * @return 
     */
    public List<Hotel> listaHoteis()
    {
        return hoteis;
    }
    
    private Hotel hotel;

    private List<Hotel> hoteis;

    @PostConstruct
    public void init() {
        hotel = new Hotel();

        hoteis = new ArrayList<Hotel>();
        Hotel h1=new Hotel();
        h1.setIdHotel(1);
        h1.setNomeFilial("Hasz 1");
        h1.setQuantidadeQuartos(3);
        h1.setEstrelas(4);
        Hotel h2=new Hotel();
        h2.setIdHotel(2);
        h2.setNomeFilial("Hasz 2");
        h2.setQuantidadeQuartos(3);
        h2.setEstrelas(4);
        Hotel h3=new Hotel();
        h3.setIdHotel(3);
        h3.setNomeFilial("Hasz 3");
        h3.setQuantidadeQuartos(3);
        h3.setEstrelas(4);
        hoteis.add(h1);
        hoteis.add(h2);
        hoteis.add(h3);
    }
    
}
