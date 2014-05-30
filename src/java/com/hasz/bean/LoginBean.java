/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hasz.bean;

import com.hasz.dao.ClienteDAO;
import com.hasz.model.ClienteFisico;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class LoginBean {
    private String cpf;
    private String senha;
    
    public String validaLogin(){
        ClienteFisico c = ClienteDAO.buscarClienteFisicoByLoginSenha(cpf, senha);
        if(c!=null){
            return "/index";
        }
        else
            return "login?erro_login=true";
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
}
