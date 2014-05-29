/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class ReservaDAO extends DAO{
    public static List<Reserva> listarReservasEmAberto(){
        Session sessao = HibernateUtil.getSession();
        List<Reserva> retorno = new ArrayList<Reserva>();
        try{
            Query select = sessao.createQuery("from Reserva where idStatusReserva in (1,2)");
            retorno = select.list();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sessao.close();
            return retorno;
        }
    }
    
    public static void cadastrarReserva(Reserva r){
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        try{
            r.setData(new Date());
            sessao.saveOrUpdate(r);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            t.commit();
            sessao.close();
        }
    }
}