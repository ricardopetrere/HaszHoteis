/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.ClienteFisico;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class ClienteDAO {
    public static ClienteFisico buscarClienteFisicoByLoginSenha(String login, String senha){
        Session sessao = HibernateUtil.getSession();
        ClienteFisico retorno = null;
        try{
            Query select = sessao.createQuery("from ClienteFisico where cpf = :login and senha = :senha");
            select.setString("login", login);
            select.setString("senha", senha);
            List<ClienteFisico> c = select.list();
            if(c.size()==1)
                retorno = c.get(0);
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
