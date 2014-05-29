/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.Quarto;
import com.hasz.model.Reserva;
import com.hasz.dao.ReservaDAO;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class QuartoDAO extends DAO{
    
    public static List<Quarto> listaQuartos(){
        Session sessao = HibernateUtil.getSession();
        List<Quarto> retorno = null;
        try{
            Query select = sessao.createQuery("from Quarto");
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
    
    public static List<Quarto> listaQuartosByIdHotel(int idHotel){
        Session sessao = HibernateUtil.getSession();
        List<Quarto> retorno = null;
        try{
            Query select = sessao.createQuery("from Quarto where idHotel = :idHotel");
            select.setInteger("idHotel", idHotel);
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
    
    public static List<Quarto> listaQuartosDisponiveisByIdHotel(int idHotel){
        Session sessao = HibernateUtil.getSession();
        List<Quarto> retorno = null;
        try{
            Query select = sessao.createQuery("from Quarto where idHotel = :idHotel");
            select.setInteger("idHotel", idHotel);
            List<Quarto> quartos = select.list();
            List<Reserva> reservasEmAberto = ReservaDAO.listarReservasEmAberto();
            retorno = quartos;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sessao.close();
            return retorno;
        }
    }

    public static Quarto buscaQuartoById(int idQuarto) {
        Session sessao = HibernateUtil.getSession();
        Quarto retorno = null;
        try{
            Query select = sessao.createQuery("from Quarto where idQuarto = :idQuarto");
            select.setInteger("idQuarto", idQuarto);
            List<Quarto> quartos = select.list();
            if(quartos.size()==1)
                retorno = quartos.get(0);
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