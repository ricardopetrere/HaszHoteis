/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.ClienteJuridico;
import java.util.Date;
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
            sessao.saveOrUpdate(cj.getEndereco());
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
    
}
