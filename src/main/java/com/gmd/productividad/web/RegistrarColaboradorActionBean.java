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

@Controller("registrarColaboradorActionBean")
@Scope(value = "session")
public class RegistrarColaboradorActionBean {

    Logger log = Logger.getLogger(RegistrarColaboradorActionBean.class);

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private RegistrarActividadColaboradorActionBean registrarActividadColaboradorActionBean;

    private Colaborador colaborador=new Colaborador();
    
    private List<Colaborador> listColaborador = new ArrayList<Colaborador>();
    
    

    private boolean notFound=false;
    
    

    public List<Colaborador> getListColaborador() {
		return listColaborador;
	}

	public void setListColaborador(List<Colaborador> listColaborador) {
		this.listColaborador = listColaborador;
	}

	public void agregarColaborador() {
        log.info("Metodo agregarColaborador ejecutado");
        try {
                colaborador.setRol('1');
                colaboradorService.save(colaborador);
                registrarActividadColaboradorActionBean.cargarActividadColaborador(colaborador.getId());
                notFound = false;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se agrego al colaborador exitosamente"));
        } catch (Exception e) {
            log.error("Error en agregarColaborador:" + e.getMessage(), e);
        }


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

    public void buscar() {
        log.info("Metodo buscar ejecutado");
        try {
        	RequestContext context = RequestContext.getCurrentInstance();
            List<Colaborador> colaboradorList = colaboradorService.find(colaborador);
            if (colaboradorList != null && colaboradorList.size() > 0) {
                colaborador = colaboradorList.get(0);
                registrarActividadColaboradorActionBean.cargarActividadColaborador(colaborador.getId());
                
                notFound = false;
            }else {
                notFound = true;
                context.execute("dlg.show()");
            }
            System.out.println("notFound: " + notFound);
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }

    public void clean() {
        log.debug("Limpiar registro colaborador");
        colaborador = new Colaborador();
        notFound=false;
    }


    public boolean isModoLectura(){
        return colaborador!=null && colaborador.getId()!=null;
    }
    public boolean isNotFound(){
        return notFound;
    }
    
    public void setNotFound(boolean notFound){
    	System.out.println("setNotFound");
        this.notFound = notFound;
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
