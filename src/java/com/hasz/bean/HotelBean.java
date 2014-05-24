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
    }
    
}
