/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.converter;

import com.hasz.dao.ReservaDAO;
import com.hasz.model.Reserva;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ricardo
 */
@FacesConverter(value = "reservaConverter")
public class ReservaConverter implements Converter{
        @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null&&!value.equals("")){
            int id = new Integer(value);
            Reserva reserva = ReservaDAO.buscaServicoById(id);
            return reserva;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Reserva){
            Reserva reserva = (Reserva)value;
            String retorno = String.valueOf(reserva.getIdReserva());
            return retorno;
        }
        return "";
    }
}
