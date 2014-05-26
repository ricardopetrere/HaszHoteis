/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;

import com.hasz.model.Cliente;
import com.hasz.model.ClienteFisico;
import com.hasz.model.ClienteJuridico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@SessionScoped
public class ClienteBean {
    private ClienteFisico clientefisico;
    private ClienteJuridico clientejuridico;
    private List<ClienteFisico> clientesfisicos;
    private List<ClienteJuridico> clientesjuridicos;
    private String senha2;
    @PostConstruct
    public void init() {
        clientefisico = new ClienteFisico();
        clientesfisicos = new ArrayList<ClienteFisico>();
        getClientefisico().setSexo('M');
        clientejuridico = new ClienteJuridico();
        clientesjuridicos = new ArrayList<ClienteJuridico>();
    }

    /**
     * @return the clientesfisicos
     */
    public List<ClienteFisico> getClientesfisicos() {
        return clientesfisicos;
    }

    /**
     * @param clientesfisicos the clientesfisicos to set
     */
    public void setClientesfisicos(List<ClienteFisico> clientesfisicos) {
        this.clientesfisicos = clientesfisicos;
    }

    /**
     * @return the clientefisico
     */
    public ClienteFisico getClientefisico() {
        return clientefisico;
    }

    /**
     * @param clientefisico the clientefisico to set
     */
    public void setClientefisico(ClienteFisico clientefisico) {
        this.clientefisico = clientefisico;
    }

    /**
     * @return the clientejuridico
     */
    public ClienteJuridico getClientejuridico() {
        return clientejuridico;
    }

    /**
     * @param clientejuridico the clientejuridico to set
     */
    public void setClientejuridico(ClienteJuridico clientejuridico) {
        this.clientejuridico = clientejuridico;
    }

    /**
     * @return the clientesjuridicos
     */
    public List<ClienteJuridico> getClientesjuridicos() {
        return clientesjuridicos;
    }

    /**
     * @param clientesjuridicos the clientesjuridicos to set
     */
    public void setClientesjuridicos(List<ClienteJuridico> clientesjuridicos) {
        this.clientesjuridicos = clientesjuridicos;
    }
    
    /**
     *
     * @param login
     * @param senha
     * @return
     */
    public boolean validaLogin(String login, String senha) {
        //((login.compareTo(login)==0)&&(senha.compareToIgnoreCase(senha)==0))
        return false;
    }
    
    public void insertClienteFisico(){
        ClienteFisico cf = new ClienteFisico();
        cf=clientefisico;
        if(!confirmaSenha(cf.getSenha(), senha2))
            return;
    }
    
    public void insertClienteJuridico(){
        ClienteJuridico cj = new ClienteJuridico();
    }

    /**
     * @return the senha2
     */
    public String getSenha2() {
        return senha2;
    }

    /**
     * @param senha2 the senha2 to set
     */
    public void setSenha2(String senha2) {
        this.senha2 = senha2;
    }

    private boolean confirmaSenha(String senha, String senha2) {
        return senha.compareTo(senha2)==0;
    }
}