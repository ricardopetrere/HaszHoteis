/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.StatusReserva;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class StatusReservaDAO extends DAO{
    public static StatusReserva buscaStatusReservaById(int idStatusReserva){
        Session sessao = HibernateUtil.getSession();
        StatusReserva retorno = null;
        try{
            Query select = sessao.createQuery("from StatusReserva where idStatusReserva = :idStatusReserva");
            select.setInteger("idStatusReserva", idStatusReserva);
            List<StatusReserva> status = select.list();
            if (status.size()==1)
                retorno = status.get(0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sessao.close();
            return retorno;
        }
    }
}
