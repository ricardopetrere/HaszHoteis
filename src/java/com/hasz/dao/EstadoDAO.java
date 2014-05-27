/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.dao;

import util.HibernateUtil;
import com.hasz.model.Estado;
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
    }

    public static boolean editarEstado(Estado estado) {
    }

    public static boolean deletarEstado(Estado estado) {
    }

    public static List<Estado> listarEstado() {
        try {
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Estado buscarEstadoByID(int idEstado) {
        try {
            Session sessao = HibernateUtil.getSession();
            Transaction t = sessao.beginTransaction();
            Query select = sessao.createQuery("from Estado where idEstado = :idEstado");
            select.setInteger("idEstado", idEstado);
            select.setFirstResult(0);//indica o primeiro registro a ser retornado (0 é o primeiro)
            select.setMaxResults(1);//sem esse campo, busca todos os registros
            List<Estado> estados = select.list();
            t.commit();
            sessao.close();
            if(estados.size()==1){
                return estados.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
