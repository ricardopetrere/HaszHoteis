/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.bean.dao;
import com.hasz.model.Cliente;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Ricardo
 */
@ManagedBean
public class ClienteDAO {
    /**
     * 
     * @param login
     * @param senha
     * @return 
     */
    public boolean validaLogin(String login,String senha){
       //if((login.compareTo(login)==0)&&(senha.compareToIgnoreCase(senha)==0))
               return false;
    }
}
