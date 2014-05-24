/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;

import com.hasz.model.ClienteFisico;
import com.hasz.model.ClienteJuridico;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
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
    public boolean validaLogin(String login, String senha) {
        //if((login.compareTo(login)==0)&&(senha.compareToIgnoreCase(senha)==0))
        return false;
    }

    private ClienteFisico clientefisico;

    private ClienteJuridico clientejuridico;
    
    
    private List<ClienteFisico> clientesfisicos;
    private List<ClienteJuridico> clientesjuridicos;

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

}
