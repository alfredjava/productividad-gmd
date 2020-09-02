package com.gmd.productividad.web;


import com.gmd.productividad.domain.TecnologiaComponente;
import com.gmd.productividad.service.TecnologiaComponenteService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

@Controller("consultaExperienciaActionBean")
@Scope("session")
public class ConsultaExperienciaActionBean {
	Logger log = Logger.getLogger(ConsultaExperienciaActionBean.class);
	@Autowired
    private TecnologiaComponenteService experienciaService;
    private List<TecnologiaComponente> experienciaList;


    private Character tipoDocumento;
    private String numeroDocumento;
    private String nombreColaborador;
    private Long idLenguaje;
    private Long idTecnologia;
    private Long idHerramienta;

    public void buscar(){
        if(tipoDocumento.charValue()==0){
            tipoDocumento = null;
        }

        experienciaList = experienciaService.find(tipoDocumento,numeroDocumento,nombreColaborador,idLenguaje,idTecnologia,idHerramienta);
        if(experienciaList.isEmpty()){
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"", "No se encontraron elementos!"));
        }

	}
	public void clean(){
		experienciaList=new ArrayList<TecnologiaComponente>();
        nombreColaborador = "";

	}
    public boolean isDocSelected(){
    	System.out.println("isDocSelected");
        return tipoDocumento!=null && tipoDocumento.charValue() != 0;
    }

    public List<TecnologiaComponente> getExperienciaList() {
        return experienciaList;
    }

    public void setExperienciaList(List<TecnologiaComponente> experienciaList) {
        this.experienciaList = experienciaList;
    }

    public Character getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Character tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombreColaborador() {
        return nombreColaborador;
    }

    public void setNombreColaborador(String nombreColaborador) {
        this.nombreColaborador = nombreColaborador;
    }

    public Long getIdLenguaje() {
        return idLenguaje;
    }

    public void setIdLenguaje(Long idLenguaje) {
        this.idLenguaje = idLenguaje;
    }

    public Long getIdTecnologia() {
        return idTecnologia;
    }

    public void setIdTecnologia(Long idTecnologia) {
        this.idTecnologia = idTecnologia;
    }

    public Long getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(Long idHerramienta) {
        this.idHerramienta = idHerramienta;
    }
}
