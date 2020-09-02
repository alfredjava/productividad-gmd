package com.gmd.productividad.domain;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 09/01/13
 * Time: 06:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movimiento implements Identifiable {
    private Long id;
    private AsignacionTrabajo asignacion;
    private String accion;
    private Date fecha;
    private Character estado;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public AsignacionTrabajo getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(AsignacionTrabajo asignacion) {
        this.asignacion = asignacion;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Character getEstado() {
        return estado;
    }

    public void setEstado(Character estado) {
        this.estado = estado;
    }
}
