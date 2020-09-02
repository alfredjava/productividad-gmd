package com.gmd.productividad.web;

import com.gmd.productividad.domain.Colaborador;
import com.gmd.productividad.service.ColaboradorService;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import java.util.ArrayList;
import java.util.List;

@Controller("consultaColaboradorActionBean")
@Scope(value = "session")
public class ConsultaColaboradorActionBean {

    Logger log = Logger.getLogger(ConsultaColaboradorActionBean.class);

    @Autowired
    private ColaboradorService colaboradorService;

    private Colaborador colaborador=new Colaborador();
    
    private List<Colaborador> listColaborador = new ArrayList<Colaborador>();
    
    

    public List<Colaborador> getListColaborador() {
		return listColaborador;
	}

	public void setListColaborador(List<Colaborador> listColaborador) {
		this.listColaborador = listColaborador;
	}

	
    
    public void colaboradores(){
    	System.out.println("colaboradores");
    	listColaborador = colaboradorService.readAll();
    	if(listColaborador.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"", "No se encontraron elementos!"));
        }
    	
    }
    
    public void buscarColaboradores(){
    	System.out.println("colaboradores: " + colaborador.getNumeroDocumento());
    	
    	listColaborador = colaboradorService.findByDocAndName(colaborador);
    	if(listColaborador.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"", "No se encontraron elementos!"));
        }
    	
    }
    
    public boolean isDocSelected(){
        return colaborador.getTipoDocumento()==null?false:colaborador.getTipoDocumento().charValue()=='0'?false:true;
    }

    public void clean() {
        log.debug("Limpiar registro colaborador");
        colaborador = new Colaborador();
    }


   
    

    public ColaboradorService getColaboradorService() {
        return colaboradorService;
    }

    public void setColaboradorService(ColaboradorService colaboradorService) {
        this.colaboradorService = colaboradorService;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}
