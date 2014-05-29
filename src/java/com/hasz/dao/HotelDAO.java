/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.Hotel;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class HotelDAO extends DAO{
    
    public static List<Hotel> listaHoteis(){
        Session sessao = HibernateUtil.getSession();
        List<Hotel> retorno = new ArrayList<Hotel>();
        try{
            Query select = sessao.createQuery("from Hotel");
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
    
    public static Hotel buscaHotelById(int idHotel){
        Session sessao = HibernateUtil.getSession();
        Hotel retorno = null;
        try{
            Query select = sessao.createQuery("from Hotel where idHotel = :idHotel");
            select.setInteger("idHotel", idHotel);
            List<Hotel> hoteis = select.list();
            if(hoteis.size()==1){
                retorno = hoteis.get(0);
            }
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