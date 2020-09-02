package com.gmd.productividad.domain;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 09/01/13
 * Time: 06:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Componente implements Identifiable {
    private Long id;
    private Character indicadorCategoria;
    private String nombre;
    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Character getIndicadorCategoria() {
        return indicadorCategoria;
    }

    public void setIndicadorCategoria(Character indicadorCategoria) {
        this.indicadorCategoria = indicadorCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
