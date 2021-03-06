/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.ClienteFisico;
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
public class ClienteFisicoDAO extends DAO{

    public static void cadastrarClienteFisico(ClienteFisico cf) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        try{
            cf.setDataCadastro(new Date());
            sessao.saveOrUpdate(cf);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            t.commit();
            sessao.close();
        }
    }
    
    public static ClienteFisico buscarClienteFisicoById(int idCliente){
        Session sessao = HibernateUtil.getSession();
        ClienteFisico retorno = null;
        try{
            Query select = sessao.createQuery("from ClienteFisico where idCliente = :idCliente");
            select.setInteger("idCliente", idCliente);
            List<ClienteFisico> clientes = select.list();
            if(clientes.size()==1)
                retorno = clientes.get(0);
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