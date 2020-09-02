package com.gmd.productividad.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 09/01/13
 * Time: 06:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class AsignacionTrabajo implements Identifiable {
	
	public AsignacionTrabajo(){
		this.componente = new Componente();
	}
    private Long id;
    private Colaborador colaborador;
    
    private Componente componente;
    private Tecnologia tecnologia;
    private Herramienta herramienta;

    private String up;
    private String indicadorComplejidad;
    private String tipoProceso;
    private String tipoTarea;
    private String ultimoMovimiento;

    private Double cantidadComponente;
    private Double cantidadComponenteUnitario;

    private Date fechaInicio;
    private Date fechaFinEstimada;
    private Date fechaFinReal;

    private Double horasDesarrolloReal;
    private Double horasModeloEstadistico;
    private Double horasEstimadas;
    private Double horasBrechaProductividad;
    private Double horasEficiencia;
    private String observacion;
    private Character estado;

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Componente getComponente() {
        return componente;
    }

    public void setComponente(Componente componente) {
        this.componente = componente;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public String getUp() {
        return up;
    }

    public void setUp(String up) {
        this.up = up;
    }

    public String getIndicadorComplejidad() {
        return indicadorComplejidad;
    }

    public void setIndicadorComplejidad(String indicadorComplejidad) {
        this.indicadorComplejidad = indicadorComplejidad;
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

    public Double getHorasDesarrolloReal() {
        return horasDesarrolloReal;
    }

    public void setHorasDesarrolloReal(Double horasDesarrolloReal) {
        this.horasDesarrolloReal = horasDesarrolloReal;
    }

    public Double getCantidadComponente() {
        return cantidadComponente;
    }

    public void setCantidadComponente(Double cantidadComponente) {
        this.cantidadComponente = cantidadComponente;
    }

    public Double getCantidadComponenteUnitario() {
        return cantidadComponenteUnitario;
    }

    public void setCantidadComponenteUnitario(Double cantidadComponenteUnitario) {
        this.cantidadComponenteUnitario = cantidadComponenteUnitario;
    }

    public Double getHorasModeloEstadistico() {
        return horasModeloEstadistico;
    }

    public void setHorasModeloEstadistico(Double horasModeloEstadistico) {
        this.horasModeloEstadistico = horasModeloEstadistico;
    }

    public Double getHorasEstimadas() {
        return horasEstimadas;
    }

    public void setHorasEstimadas(Double horasEstimadas) {
        this.horasEstimadas = horasEstimadas;
    }

    public Double getHorasBrechaProductividad() {
        return horasBrechaProductividad;
    }

    public void setHorasBrechaProductividad(Double horasBrechaProductividad) {
        this.horasBrechaProductividad = horasBrechaProductividad;
    }

    public Double getHorasEficiencia() {
        return horasEficiencia;
    }

    public void setHorasEficiencia(Double horasEficiencia) {
        this.horasEficiencia = horasEficiencia;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinReal() {
        return fechaFinReal;
    }

    public void setFechaFinReal(Date fechaFinReal) {
        this.fechaFinReal = fechaFinReal;
    }

    public Date getFechaFinEstimada() {
        return fechaFinEstimada;
    }

    public void setFechaFinEstimada(Date fechaFinEstimada) {
        this.fechaFinEstimada = fechaFinEstimada;
    }

    public String getUltimoMovimiento() {
        return ultimoMovimiento;
    }

    public void setUltimoMovimiento(String ultimoMovimiento) {
        this.ultimoMovimiento = ultimoMovimiento;
    }
}
