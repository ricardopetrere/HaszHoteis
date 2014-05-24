/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.bean;
import com.hasz.model.Cliente;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
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
