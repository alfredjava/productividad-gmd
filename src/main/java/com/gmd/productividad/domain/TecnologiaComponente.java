package com.gmd.productividad.domain;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 09/01/13
 * Time: 06:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TecnologiaComponente implements Identifiable {
    private Long id;
    private Tecnologia tecnologia;
    private Colaborador colaborador;
    private Herramienta herramienta;
    private Integer tiempoTotal;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Tecnologia getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(Tecnologia tecnologia) {
        this.tecnologia = tecnologia;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }

    public Herramienta getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(Herramienta herramienta) {
        this.herramienta = herramienta;
    }

    public Integer getTiempoTotal() {
        return tiempoTotal;
    }

    public void setTiempoTotal(Integer tiempoTotal) {
        this.tiempoTotal = tiempoTotal;
    }
    
}
