package com.gmd.productividad.domain;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 09/01/13
 * Time: 06:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Tecnologia implements Identifiable {

    private Long id;
    private Lenguaje lenguaje;
    private char indicadorEstandar;
    private String nombre;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Lenguaje getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(Lenguaje lenguaje) {
        this.lenguaje = lenguaje;
    }

    public char getIndicadorEstandar() {
        return indicadorEstandar;
    }

    public void setIndicadorEstandar(char indicadorEstandar) {
        this.indicadorEstandar = indicadorEstandar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
