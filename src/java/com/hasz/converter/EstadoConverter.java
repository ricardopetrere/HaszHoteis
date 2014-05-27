/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.converter;

import com.hasz.model.Estado;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ricardo
 */
@FacesConverter(value = "estadoConverter")
public class EstadoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null&&!value.equals("")){
            int id= new Integer(value);
            Estado estado=new Estado();
            estado.setIdEstado(id);
            return estado;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Estado){
            Estado estado=(Estado)value;
            String retorno = String.valueOf(estado.getIdEstado());
            return retorno;
        }
        return "";
    }
    
}
