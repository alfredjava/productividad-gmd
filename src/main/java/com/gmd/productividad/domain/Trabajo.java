package com.gmd.productividad.domain;

import java.util.Date;

public class Trabajo {
	private String idTrabajo;
	private String colaborador;
	private String lenguaje;
	private String herramienta;
	private String tecnologia;
	private String componente;
	private String complejidad;
	private String tipoProceso;
	private String tipoTarea;
	private String estado;
	private Date fechInicio;
	private Date fechFinEstimado;
	private Date fechReal;
	public String getIdTrabajo() {
		return idTrabajo;
	}
	public void setIdTrabajo(String idTrabajo) {
		this.idTrabajo = idTrabajo;
	}
	public String getColaborador() {
		return colaborador;
	}
	public void setColaborador(String colaborador) {
		this.colaborador = colaborador;
	}
	public String getLenguaje() {
		return lenguaje;
	}
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	public String getHerramienta() {
		return herramienta;
	}
	public void setHerramienta(String herramienta) {
		this.herramienta = herramienta;
	}
	public String getTecnologia() {
		return tecnologia;
	}
	public void setTecnologia(String tecnologia) {
		this.tecnologia = tecnologia;
	}
	public String getComponente() {
		return componente;
	}
	public void setComponente(String componente) {
		this.componente = componente;
	}
	public String getComplejidad() {
		return complejidad;
	}
	public void setComplejidad(String complejidad) {
		this.complejidad = complejidad;
	}
	public String getTipoProceso() {
		return tipoProceso;
	}
	public void setTipoProceso(String tipoProceso) {
		this.tipoProceso = tipoProceso;
	}
	public String getTipoTarea() {
		return tipoTarea;
	}
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Date getFechInicio() {
		return fechInicio;
	}
	public void setFechInicio(Date fechInicio) {
		this.fechInicio = fechInicio;
	}
	public Date getFechFinEstimado() {
		return fechFinEstimado;
	}
	public void setFechFinEstimado(Date fechFinEstimado) {
		this.fechFinEstimado = fechFinEstimado;
	}
	public Date getFechReal() {
		return fechReal;
	}
	public void setFechReal(Date fechReal) {
		this.fechReal = fechReal;
	}
	
	
}
