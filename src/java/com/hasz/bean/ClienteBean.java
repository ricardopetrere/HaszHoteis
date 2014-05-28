/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;

import com.hasz.dao.CidadeDAO;
import com.hasz.dao.EstadoDAO;
import com.hasz.dao.ClienteFisicoDAO;
import com.hasz.dao.ClienteJuridicoDAO;
import com.hasz.dao.EnderecoDAO;
import com.hasz.model.Cidade;
import com.hasz.model.Cliente;
import com.hasz.model.ClienteFisico;
import com.hasz.model.ClienteJuridico;
import com.hasz.model.Endereco;
import com.hasz.model.Estado;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
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
    private ClienteFisico clientefisico = new ClienteFisico();
    private ClienteJuridico clientejuridico = new ClienteJuridico();
    private List<ClienteFisico> clientesfisicos = new ArrayList<ClienteFisico>();
    private List<ClienteJuridico> clientesjuridicos = new ArrayList<ClienteJuridico>();
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
        getClientefisico().setSexo('M');
        
        estados=EstadoDAO.listarEstados();
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
    
    public void insertClienteFisico(AjaxBehaviorEvent event){
        ClienteFisico cf = new ClienteFisico();
        cf=clientefisico;
        if(!confirmaSenha(cf.getSenha(), senha2))
            return;
        cidade.setEndereco(new HashSet<Endereco>(EnderecoDAO.listarEnderecoByIdCidade(cidade.getIdCidade())));
        endereco.setCidade(cidade);
        cidade.getEndereco().add(endereco);
        
        endereco.setCliente(new HashSet<Cliente>(EnderecoDAO.listarClienteByIdEndereco(endereco.getIdEndereco())));
        cf.setEndereco(endereco);
        endereco.getCliente().add(cf);
        ClienteFisicoDAO.cadastrarClienteFisico(cf);
        clientefisico=new ClienteFisico();
        cidade = new Cidade();
        endereco= new Endereco();
    }
    
    public void insertClienteJuridico(){
        ClienteJuridico cj = new ClienteJuridico();
        if(!confirmaSenha(cj.getSenha(), senha2))
            return;
        endereco.setCidade(cidade);
        cidade.getEndereco().add(endereco);
        cj.setEndereco(endereco);
        endereco.getCliente().add(cj);
        ClienteJuridicoDAO.cadastrarClienteJuridico(cj);
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
        if(this.estado!=null){
            cidades= CidadeDAO.listaCidadesByIdEstado(estado.getIdEstado());
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