/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.Servico;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class ServicoDAO extends DAO{

    public static Servico buscaServicoById(int idServico) {
        Session sessao = HibernateUtil.getSession();
        Servico retorno = new Servico();
        try{
            Query select = sessao.createQuery("from Servico where idServico = :idServico");
            select.setInteger("idServico", idServico);
            List<Servico> servicos = select.list();
            if(servicos.size()==1)
                retorno = servicos.get(0);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            sessao.close();
            return retorno;
        }
    }
    
    public static List<Servico> listarServicos(){
        Session sessao = HibernateUtil.getSession();
        List<Servico> retorno = null;
        try{
            Query select = sessao.createQuery("from Servico");
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
}