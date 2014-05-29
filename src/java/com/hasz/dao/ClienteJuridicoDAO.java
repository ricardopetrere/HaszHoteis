/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.ClienteJuridico;
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
public class ClienteJuridicoDAO {

    public static void cadastrarClienteJuridico(ClienteJuridico cj) {
        Session sessao = HibernateUtil.getSession();
        Transaction t = sessao.beginTransaction();
        try{
            cj.setDataCadastro(new Date());
            sessao.saveOrUpdate(cj);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            t.commit();
            sessao.close();
        }
    }
    
    public static ClienteJuridico buscarClienteJuridicoById(int idCliente){
        Session sessao = HibernateUtil.getSession();
        ClienteJuridico retorno = null;
        try{
            Query select = sessao.createQuery("from ClienteJuridico where idCliente = :idCliente");
            select.setInteger("idCliente", idCliente);
            List<ClienteJuridico> clientes = select.list();
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