/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hasz.bean;

import com.hasz.model.Cidade;
import com.hasz.model.Estado;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author Ricardo
 */
@ManagedBean
public class EstadoBean {

    public static Estado estado=new Estado();
    public static List<Estado> estados=new ArrayList<Estado>();
    
    public static Cidade cidade=new Cidade();
    public static List<Cidade> cidades=new ArrayList<Cidade>();
    
//    @PostConstruct
//    public void init() {
//        
//    }
    public EstadoBean(){
        Estado e1 = new Estado();
        e1.setIdEstado(1);
        e1.setNome("Acre");
        e1.setSigla("AC");
        Estado e2 = new Estado();
        e1.setIdEstado(2);
        e2.setNome("Bahia");
        e2.setSigla("BA");
        Estado e3 = new Estado();
        e1.setIdEstado(3);
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
        FacesContext context = FacesContext.getCurrentInstance();  
        Object value = context.getExternalContext().getRequestMap().get("estado");
        cidades=(List<Cidade>)((Estado)value).getCidade();
        if(estado!=null&&estado.getNome()!=null)
            cidades=(List<Cidade>) estado.getCidade();
        else
            cidades=new ArrayList<Cidade>();
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