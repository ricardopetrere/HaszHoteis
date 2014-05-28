/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.ClienteFisico;
import java.util.Date;
import java.util.Calendar;
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
            //sessao.saveOrUpdate(cf.getEndereco());
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
}