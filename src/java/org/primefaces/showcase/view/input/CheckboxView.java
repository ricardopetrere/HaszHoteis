package org.primefaces.showcase.view.input;
 
import javax.faces.bean.ManagedBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class CheckboxView {
         
    private String[] selectedServicos;   
    private List<String> cities;
     
    @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        cities.add("San Francisco");
        cities.add("London");
        cities.add("Paris");
        cities.add("Istanbul");
        cities.add("Berlin");
        cities.add("Barcelona");
        cities.add("Rome");
        cities.add("Sao Paulo");
        cities.add("Amsterdam");
    }
 
    public String[] getSelectedServicos() {
        return selectedServicos;
    }
 
    public void setSelectedServicos(String[] selectedServicos) {
        this.selectedServicos = selectedServicos;
    }
 
    public List<String> getCities() {
        return cities;
    }
}