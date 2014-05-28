/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.dao;


import util.HibernateUtil;
import com.hasz.model.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author Ricardo
 */
public class EstadoDAO extends DAO {

    public static boolean cadastrarEstado(Estado estado) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        boolean retorno;
        try{
            List<Cidade> cidades = new ArrayList<Cidade>(estado.getCidade());
            Iterator it = cidades.iterator();
            while(it.hasNext()){
                sessao.saveOrUpdate((Cidade) it.next());
            }
            sessao.saveOrUpdate(estado);
            retorno = true;
        }
        catch(Exception e){
            e.printStackTrace();
            retorno=false;
        }
        finally{
            t.commit();
            sessao.close();
        }
        return retorno;
    }

    public static boolean editarEstado(Estado estado) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        boolean retorno;
        try{
            List<Cidade> cidades = new ArrayList<Cidade>(estado.getCidade());
            Iterator it = cidades.iterator();
            while(it.hasNext()){
                sessao.saveOrUpdate((Cidade) it.next());
            }
            sessao.saveOrUpdate(estado);
            retorno = true;
        }
        catch(Exception e){
            e.printStackTrace();
            retorno=false;
        }
        finally{
            t.commit();
            sessao.close();
        }
        return retorno;
    }

    public static boolean deletarEstado(Estado estado) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        boolean retorno;
        try{
            List<Cidade> cidades = new ArrayList<Cidade>(estado.getCidade());
            Iterator it = cidades.iterator();
            while(it.hasNext()){
                sessao.saveOrUpdate((Cidade) it.next());
            }
            sessao.saveOrUpdate(estado);
            retorno = true;
        }
        catch(Exception e){
            e.printStackTrace();
            retorno=false;
        }
        finally{
            t.commit();
            sessao.close();
        }
        return retorno;
    }

    public static List<Estado> listarEstados() {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        List<Estado> retorno=new ArrayList<Estado>();
        try {
            Query select = sessao.createQuery("from Estado");
            retorno = select.list();

        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        }
        finally{
            t.commit();
            sessao.close();
        }
        return retorno;
    }

    public static Estado buscarEstadoById(int idEstado) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        Estado retorno=new Estado();
        try {
            Query select = sessao.createQuery("from Estado where idEstado = :idEstado");
            select.setInteger("idEstado", idEstado);
            select.setFirstResult(0);//indica o primeiro registro a ser retornado (0 é o primeiro)
            select.setMaxResults(1);//sem esse campo, busca todos os registros
            List<Estado> estados = select.list();

            if (estados.size() == 1) {
                retorno = estados.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            retorno = null;
        } finally {
            t.commit();
            sessao.close();
        }
        return retorno;
    }
}
