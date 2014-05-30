/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.dao;

import util.HibernateUtil;
import com.hasz.model.*;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Ricardo
 */
public class CidadeDAO extends DAO {

    public static List<Cidade> listaCidadesByIdEstado(int idEstado) {
        Session sessao = HibernateUtil.getSession();
        List<Cidade> retorno = new ArrayList<Cidade>();
        try{
            Query select = sessao.createQuery("from Cidade where idEstado = :idEstado");
            select.setInteger("idEstado", idEstado);
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
    
    public static List<Cidade> listaCidades(){
        Session sessao = HibernateUtil.getSession();
        List<Cidade> retorno = new ArrayList<Cidade>();
        try{
            Query select = sessao.createQuery("from Cidade");
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
    
    public static Cidade buscaCidadeById(int idCidade){
        Session sessao = HibernateUtil.getSession();
        Cidade retorno = null;
        try{
            Query select = sessao.createQuery("from Cidade where idCidade = :idCidade");
            select.setInteger("idCidade", idCidade);
            List<Cidade> cidades = select.list();
            if(cidades.size()==1){
                retorno = cidades.get(0);
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
