/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.dao;

import com.hasz.model.Cliente;
import com.hasz.model.Endereco;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

/**
 *
 * @author Ricardo
 */
public class EnderecoDAO extends DAO{
    public static List<Endereco> listarEnderecoByIdCidade(int idCidade){
        Session sessao = HibernateUtil.getSession();
        List<Endereco> retorno = null;
        try{
            Query select = sessao.createQuery("from Endereco where idCidade = :idCidade");
            select.setInteger("idCidade", idCidade);
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
    
    public static Endereco buscaEnderecoById(int idEndereco){
        Session sessao = HibernateUtil.getSession();
        Endereco retorno = null;
        try{
            Query select = sessao.createQuery("from Endereco where idEndereco = :idEndereco");
            select.setInteger("idEndereco", idEndereco);
            List<Endereco> enderecos = select.list();
            if(enderecos.size()==1){
                retorno = enderecos.get(0);
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
    
    public static List<Cliente> listarClienteByIdEndereco(int idEndereco){
        Session sessao = HibernateUtil.getSession();
        List<Cliente> retorno = null;
        try{
            Query select = sessao.createQuery("from Cliente where idEndereco = :idEndereco");
            select.setInteger("idEndereco", idEndereco);
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
