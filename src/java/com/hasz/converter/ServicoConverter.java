/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.converter;

import com.hasz.dao.ServicoDAO;
import com.hasz.model.Servico;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ricardo
 */
@FacesConverter(value = "servicoConverter")
public class ServicoConverter implements Converter{
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null&&!value.equals("")){
            int id = new Integer(value);
            Servico servico = ServicoDAO.buscaServicoById(id);
            return servico;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Servico){
            Servico servico = (Servico)value;
            String retorno = String.valueOf(servico.getIdServico());
            return retorno;
        }
        return "";
    }
}