package com.gmd.productividad.web;

import com.gmd.productividad.service.MovimientoService;
import com.gmd.productividad.util.Constantes;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

@Controller("movimientosAsignacionesActionBean")
@Scope("session")
public class MovimientosAsignacionesActionBean {
    Logger log = Logger.getLogger(MovimientosAsignacionesActionBean.class);

    @Autowired
    private MovimientoService movimientoService;

    private Long selectedId;

    private String accion;
    
    

    public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}


    public Long getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(Long selectedId) {
        this.selectedId = selectedId;
    }

    public void setAccion(long id, String accion){
        setSelectedId(id);
        setAccion(accion);
        System.out.println("accion: " + accion);
    }

    public void cambiarEstado(){
    	if("tomar".equals(accion)){
    		tomarAsignacion();
    	}else if("tomarAjuste".equals(accion)){
    		tomarAjuste();
    	}else if("tomarRetrabajo".equals(accion)){
    		tomarRetrabajo();
    	}else if("finalizarDesarrollo".equals(accion)){
    		finalizarDesarrollo();
    	}else if("finalizarUP".equals(accion)){
    		finalizarUP();
    	}else if("retrabajo".equals(accion)){
    		retrabajo();
    	}else if("ajuste".equals(accion)){
    		ajuste();
    	}else if("delete".equals(accion)){
    		deleteUltimoMovimiento();
    	}
    }


    public void tomarAsignacion(){
        movimientoService.tomarAsignacion(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }
    
    public void tomarRetrabajo(){
        movimientoService.tomarRetrabajo(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }
    public void tomarAjuste(){
        movimientoService.tomarAjuste(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }    
    public void finalizarDesarrollo(){
        movimientoService.finalizarDesarrollo(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }
    public void finalizarUP(){
        movimientoService.finalizarUP(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }
    public void retrabajo(){
        movimientoService.retrabajo(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }
    public void ajuste(){
        movimientoService.ajuste(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha actualizado el estado de la asignacion!"));
    }
    
    public void deleteUltimoMovimiento(){
        movimientoService.deleteUltimoMovimiento(getSelectedId());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Eliminado el último movimiento!"));
    }

    public boolean isAsignacionPorTomar(String tipoAccion){
        return Constantes.ASIGNACION.equals(tipoAccion);
    }
    public boolean isAjustePorTomar(String tipoAccion){
        return Constantes.AJUSTE.equals(tipoAccion);
    }
    public boolean isRetrabajoPorTomar(String tipoAccion){
        return Constantes.RETRABAJO.equals(tipoAccion);
    }
    public boolean isPorFinalizarDesarrollo(String tipoAccion){
        return Constantes.AJUSTE_TOMADO.equals(tipoAccion) || Constantes.RETRABAJO_TOMADO.equals(tipoAccion) || Constantes.ASIGNACION_TOMADA.equals(tipoAccion);
    }
    public boolean isPorRevisar(String tipoAccion){
        return Constantes.DESARROLLO_FINALIZADO.equals(tipoAccion);
    }
    public boolean permiteDeshacer(String tipoAccion){
        return !Constantes.ASIGNACION.equals(tipoAccion) && !Constantes.FINALIZADO.equals(tipoAccion) ;
    }

}

