/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.converter;

import com.hasz.dao.CidadeDAO;
import com.hasz.model.Cidade;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Ricardo
 */
@FacesConverter(value = "cidadeConverter")
public class CidadeConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value!=null&&!value.equals("")){
            int id= new Integer(value);
//            Cidade cidade=new Cidade();
//            cidade.setIdCidade(id);
            Cidade cidade = CidadeDAO.buscaCidadeById(id);
            return cidade;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value instanceof Cidade){
            Cidade cidade=(Cidade)value;
            String retorno = String.valueOf(cidade.getIdCidade());
            return retorno;
        }
        return "";
    }
    
}
