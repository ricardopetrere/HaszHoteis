/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.converter;

import com.hasz.dao.HotelDAO;
import com.hasz.model.Hotel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ricardo
 */
@FacesConverter(value = "hotelConverter")
public class HotelConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null&&!value.equals("")){
            int id = new Integer(value);
            Hotel hotel = HotelDAO.buscaHotelById(id);
            return hotel;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Hotel){
            Hotel hotel = (Hotel)value;
            String retorno = String.valueOf(hotel.getIdHotel());
            return retorno;
        }
        return "";
    }
}