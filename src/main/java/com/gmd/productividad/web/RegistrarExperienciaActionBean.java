package com.gmd.productividad.web;

import com.gmd.productividad.domain.Colaborador;
import com.gmd.productividad.domain.Herramienta;
import com.gmd.productividad.domain.Tecnologia;
import com.gmd.productividad.domain.TecnologiaComponente;
import com.gmd.productividad.service.TecnologiaComponenteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.List;

@Controller("registrarExperienciaColaboradorActionBean")
@Scope(value = "session")
public class RegistrarExperienciaActionBean {
    Logger log = Logger.getLogger(RegistrarExperienciaActionBean.class);
    @Autowired
    private TecnologiaComponenteService tecnologiaComponenteService;

    private Long idColaborador;
    private TecnologiaComponente tecnologiaComponente=initTecnologiaComponente();
    private List<TecnologiaComponente> listaExperiencia;
    private Long selectedIdExperiencia;
    private Long idLenguaje;


    public void cargarExperiencia(Long idColaborador) {
    	this.idColaborador = idColaborador;
        listaExperiencia = tecnologiaComponenteService.findByColaborador(idColaborador);
    }

    public void delete() {
        log.debug("Metodo eliminarExp ejecutado");
        try {
            tecnologiaComponenteService.delete(selectedIdExperiencia);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se elimino la asignacion correctamente!"));
            cargarExperiencia(idColaborador);
        } catch (Exception e) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Hubo un error al intentar eliminar!"));
        }

    }

    public void guadarExperiencia(Long idColaborador) {
        log.info("Metodo guadarExperiencia ejecutado");
        try {
            tecnologiaComponente.getColaborador().setId(idColaborador);
            if(tecnologiaComponente.getTiempoTotal()<1){
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Error", "Tiempo(meses) debe ser mayor a 0"));
            }else{
            	 tecnologiaComponenteService.save(tecnologiaComponente);
                 clean();
                 cargarExperiencia(idColaborador);
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Informacion", "Se ha agregó la experiencia exitosamente."));

            }
           }catch(DuplicateKeyException e){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Ya hay una experiencia con esas caracteristicas!"));
        }
        catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error", "Hubo un error al intentar guardar!"));
            log.error("Error en agregar:" + e.getMessage(), e);
        }
    }

    public void clean(){
        tecnologiaComponente = initTecnologiaComponente();
    }
    public TecnologiaComponente initTecnologiaComponente(){
        TecnologiaComponente tecnologiaComponente = new TecnologiaComponente();
        tecnologiaComponente.setHerramienta(new Herramienta());
        tecnologiaComponente.setTecnologia(new Tecnologia());
        tecnologiaComponente.setColaborador(new Colaborador());
        return tecnologiaComponente;
    }

    public TecnologiaComponenteService getTecnologiaComponenteService() {
        return tecnologiaComponenteService;
    }

    public void setTecnologiaComponenteService(TecnologiaComponenteService tecnologiaComponenteService) {
        this.tecnologiaComponenteService = tecnologiaComponenteService;
    }

    public Long getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(Long idColaborador) {
        this.idColaborador = idColaborador;
    }

    public TecnologiaComponente getTecnologiaComponente() {
        return tecnologiaComponente;
    }

    public void setTecnologiaComponente(TecnologiaComponente tecnologiaComponente) {
        this.tecnologiaComponente = tecnologiaComponente;
    }

    public List<TecnologiaComponente> getListaExperiencia() {
        return listaExperiencia;
    }

    public void setListaExperiencia(List<TecnologiaComponente> listaExperiencia) {
        this.listaExperiencia = listaExperiencia;
    }

    public Long getSelectedIdExperiencia() {
        return selectedIdExperiencia;
    }

    public void setSelectedIdExperiencia(Long selectedIdExperiencia) {
        this.selectedIdExperiencia = selectedIdExperiencia;
    }


    public Long getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(Long idLenguaje) {
        this.idLenguaje = idLenguaje;
    }
}
