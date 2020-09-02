package com.gmd.productividad.web;

import com.gmd.productividad.domain.AsignacionTrabajo;
import com.gmd.productividad.service.AsignacionTrabajoService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("consultarAsignacionesActionBean")
@Scope("session")
public class ConsultarAsignacionesActionBean {
    Logger log = Logger.getLogger(ConsultarAsignacionesActionBean.class);

    @Autowired
    private AsignacionTrabajoService asignacionTrabajoService;

    private List<AsignacionTrabajo> asignacionTrabajoList;//Lista de resultados

    private AsignacionTrabajo asignacionTrabajo = new AsignacionTrabajo();
    private String nombre;
    private List<String> estados;

    public void buscar(){
        asignacionTrabajoList = asignacionTrabajoService.find(getNombre(), asignacionTrabajo.getUp(), asignacionTrabajo.getTipoProceso(), asignacionTrabajo.getFechaInicio(), asignacionTrabajo.getFechaFinEstimada(), asignacionTrabajo.getFechaFinReal(), estados);
        if(asignacionTrabajoList.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"", "No se encontraron elementos!"));
        }
    }

    public void clean(){
        asignacionTrabajo=new AsignacionTrabajo();
        estados=null;
        nombre=null;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<AsignacionTrabajo> getAsignaciones(Long idColaborador){
        return asignacionTrabajoService.findByColaborador(idColaborador);
    }


    public List<AsignacionTrabajo> getAsignacionTrabajoList() {
        return asignacionTrabajoList;
    }

    public void setAsignacionTrabajoList(List<AsignacionTrabajo> asignacionTrabajoList) {
        this.asignacionTrabajoList = asignacionTrabajoList;
    }

    public AsignacionTrabajo getAsignacionTrabajo() {
        return asignacionTrabajo;
    }

    public void setAsignacionTrabajo(AsignacionTrabajo asignacionTrabajo) {
        this.asignacionTrabajo = asignacionTrabajo;
    }


    public List<String> getEstados() {
        return estados;
    }

    public void setEstados(List<String> estados) {
        this.estados = estados;
    }
}

