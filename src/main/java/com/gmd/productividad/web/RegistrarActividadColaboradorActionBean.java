package com.gmd.productividad.web;

import com.gmd.productividad.domain.ActividadColaborador;
import com.gmd.productividad.domain.Colaborador;
import com.gmd.productividad.domain.Proyecto;
import com.gmd.productividad.service.ActividadColaboradorService;
import com.gmd.productividad.util.Constantes;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeComparator;
import org.joda.time.Days;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Date;

@Controller("registrarActividadColaboradorActionBean")
@Scope(value = "session")
public class RegistrarActividadColaboradorActionBean {

    Logger log = Logger.getLogger(RegistrarActividadColaboradorActionBean.class);

    @Autowired
    private ActividadColaboradorService actividadColaboradorService;

    private ActividadColaborador actividadColaborador;

    public void cargarActividadColaborador(Long idColaborador) {
        if(idColaborador==null) return;
        actividadColaborador = actividadColaboradorService.findByColaborador(idColaborador);
        if (actividadColaborador == null) {
            actividadColaborador = new ActividadColaborador();
            actividadColaborador.setFechaFin(new Date());
            actividadColaborador.setFechaInicio(new Date());
            actividadColaborador.setProyecto(new Proyecto());
            actividadColaborador.setColaborador(new Colaborador());
            actividadColaborador.getColaborador().setId(idColaborador);
        }
    }

    public boolean validar() {
        boolean error = false;
        try {
            String msg = "";
            if (actividadColaborador.getFechaInicio() == null || actividadColaborador.getFechaFin() == null) {
                msg = "Ingrese ambas fechas";
                error = true;
            } else if (DateTimeComparator.getDateOnlyInstance().compare(new DateTime(actividadColaborador.getFechaInicio()), new DateTime(actividadColaborador.getFechaFin())) == 1) {
                msg = "La fecha fin debe ser mayor o igual a la fecha inicio";
                error = true;
            } else if (actividadColaborador.getProyecto().getId().equals("")) {
                msg = "Seleccione un Proyecto";
                error = true;
            } else if (actividadColaborador.getTipoActividad().equals("")) {
                msg = "Seleccione una Actividad";
                error = true;
            }
            if (error) {
                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, "");
                FacesContext.getCurrentInstance().addMessage(msg, fm);
            }
        } catch (Exception e) {
            log.error("Error en :" + e.getMessage(), e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", Constantes.MENSAJE_ERROR_DEFAULT));
        }
        return !error;
    }

    public void guardarActColaborador() {
        log.info("Metodo guardarActColaborador ejecutado");
        try {
            if (validar()) {
                actividadColaborador.setTiempoTotal(Days.daysBetween(new DateTime(actividadColaborador.getFechaInicio()), new DateTime(actividadColaborador.getFechaFin())).getDays());
                if(actividadColaborador.getId()==null){
                    actividadColaboradorService.insert(actividadColaborador);
                }else{
                    actividadColaboradorService.update(actividadColaborador);
                }
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Informacion: ", "Se guardo exitosamente!"));
            }
        }catch(DuplicateKeyException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ", "Ya hay un colaborador con ese usuario!"));
        } catch (Exception e) {
            log.error("Error en agregar:" + e.getMessage(), e);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: ", Constantes.MENSAJE_ERROR_DEFAULT));
        }
    }


    public ActividadColaborador getActividadColaborador() {
        return actividadColaborador;
    }

    public void setActividadColaborador(ActividadColaborador actividadColaborador) {
        this.actividadColaborador = actividadColaborador;
    }
}
