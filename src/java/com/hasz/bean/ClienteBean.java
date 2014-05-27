/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;

import com.hasz.dao.EstadoDAO;
import com.hasz.model.Cidade;
import com.hasz.model.ClienteFisico;
import com.hasz.model.ClienteJuridico;
import com.hasz.model.Endereco;
import com.hasz.model.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Ricardo
 */
@ManagedBean
@ApplicationScoped
public class ClienteBean {
    private ClienteFisico clientefisico;
    private ClienteJuridico clientejuridico;
    private List<ClienteFisico> clientesfisicos;
    private List<ClienteJuridico> clientesjuridicos;
    private String senha2;
    
    private Estado estado=new Estado();
    private List<Estado> estados=new ArrayList<Estado>();
    
    private Cidade cidade=new Cidade();
    private List<Cidade> cidades=new ArrayList<Cidade>();
    
    private Endereco endereco=new Endereco();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
    public ClienteBean(){
        clientefisico = new ClienteFisico();
        clientesfisicos = new ArrayList<ClienteFisico>();
        getClientefisico().setSexo('M');
        clientejuridico = new ClienteJuridico();
        clientesjuridicos = new ArrayList<ClienteJuridico>();
        
        Estado e1 = new Estado();
        e1.setIdEstado(1);
        e1.setNome("Acre");
        e1.setSigla("AC");
        
        Estado e2 = new Estado();
        e2.setIdEstado(2);
        e2.setNome("Bahia");
        e2.setSigla("BA");
        
        Estado e3 = new Estado();
        e3.setIdEstado(3);
        e3.setNome("Exterior");
        e3.setSigla("EX");
        
        Cidade c1 = new Cidade();
        c1.setIdCidade(1);
        c1.setEstado(e1);
        e1.getCidade().add(c1);
        c1.setDescricao("Cidade 1_1");
        
        Cidade c2 = new Cidade();
        c2.setIdCidade(2);
        c2.setEstado(e2);
        e2.getCidade().add(c2);
        c2.setDescricao("Cidade 2_1");
        
        Cidade c3 = new Cidade();
        c3.setIdCidade(3);
        c3.setEstado(e2);
        e2.getCidade().add(c3);
        c3.setDescricao("Cidade 2_2");
        
        Cidade c4 = new Cidade();
        c4.setIdCidade(4);
        c4.setEstado(e2);
        e2.getCidade().add(c4);
        c4.setDescricao("Cidade 2_3");
        
        Cidade c5 = new Cidade();
        c5.setIdCidade(5);
        c5.setEstado(e3);
        e3.getCidade().add(c5);
        c5.setDescricao("Cidade 3_1");
        
        Cidade c6 = new Cidade();
        c6.setIdCidade(6);
        c6.setEstado(e3);
        e3.getCidade().add(c6);
        c6.setDescricao("Cidade 3_2");
        
        estados.add(e1);
        estados.add(e2);
        estados.add(e3);
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
    
    /**
     * @return the estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    /**
     * @return the estados
     */
    public List<Estado> getEstados() {
        return estados;
    }

    /**
     * @param estados the estados to set
     */
    public void setEstados(List<Estado> estados) {
        this.estados = estados;
    }
    
    public void updateCidades(AjaxBehaviorEvent event){
        Estado estadoAux=null;
        if(this.estado!=null){
            estadoAux=EstadoDAO.buscarEstadoByID(this.estado.getIdEstado());
            cidades= new ArrayList<Cidade>(estadoAux.getCidade());
        }
    }

    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    /**
     * @return the cidades
     */
    public List<Cidade> getCidades() {
        return cidades;
    }

    /**
     * @param cidades the cidades to set
     */
    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }
}