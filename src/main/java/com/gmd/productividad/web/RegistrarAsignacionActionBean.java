package com.gmd.productividad.web;

import com.gmd.productividad.domain.*;
import com.gmd.productividad.service.AsignacionTrabajoService;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("registrarAsignacionActionBean")
@Scope("session")
public class RegistrarAsignacionActionBean {
    Logger log = Logger.getLogger(RegistrarAsignacionActionBean.class);
    @Autowired
    private AsignacionTrabajoService asignacionTrabajoService;
    private AsignacionTrabajo asignacionTrabajo = initAsignacion();
    private List<AsignacionTrabajo> listaAsignacionTrabajo;
    private Long selectedId;
    private Long idLenguaje;
    private Long idColaborador;

    public void cargarAsignaciones(Long idColaborador){
        this.idColaborador = idColaborador;
        listaAsignacionTrabajo = asignacionTrabajoService.findByColaborador(idColaborador);
    }
    public List<AsignacionTrabajo> getAsignaciones(){
        return listaAsignacionTrabajo;
    }

	public void asignar(Long idColaborador){
        asignacionTrabajo.getColaborador().setId(idColaborador);
        asignacionTrabajoService.save(asignacionTrabajo);
        cargarAsignaciones(idColaborador);
        clean();
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion", "Se guardo exitosamente!"));
    }
    private AsignacionTrabajo initAsignacion(){
        AsignacionTrabajo asignacionTrabajo = new AsignacionTrabajo();
        asignacionTrabajo.setComponente(new Componente());
        asignacionTrabajo.setHerramienta(new Herramienta());
        asignacionTrabajo.setTecnologia(new Tecnologia());
        asignacionTrabajo.setColaborador(new Colaborador());
        return asignacionTrabajo;
    }
    public void clean(){
        this.asignacionTrabajo = initAsignacion();
    }

    public void delete(){
        try{
            asignacionTrabajoService.delete(selectedId);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se elimino la asignacion correctamente!"));
            cargarAsignaciones(idColaborador);
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Hubo un error al intentar eliminar!"));
        }
    }


    public void updateHorasEstimadas(){
        if(asignacionTrabajo.getFechaInicio()!=null && asignacionTrabajo.getFechaFinEstimada()!=null){
            asignacionTrabajo.setHorasEstimadas((double)(Days.daysBetween(new DateTime(asignacionTrabajo.getFechaInicio()), new DateTime(asignacionTrabajo.getFechaFinEstimada())).getDays()+1)*8);
        }
    }

    public AsignacionTrabajo getAsignacionTrabajo() {
        return asignacionTrabajo;
    }

    public void setAsignacionTrabajo(AsignacionTrabajo asignacionTrabajo) {
        this.asignacionTrabajo = asignacionTrabajo;
    }

    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public Long getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(Long idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }
}

