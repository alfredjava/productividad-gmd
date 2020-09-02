package com.gmd.productividad.domain;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 09/01/13
 * Time: 06:27 PM
 * To change this template use File | Settings | File Templates.
 */
public class Colaborador implements Identifiable {
    private Long id;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String nombres;
    private Character rol;
    private Character tipoDocumento;
    private String numeroDocumento;
    private String usuario;
    private String password;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
    	System.out.println("setId: " + id);
        this.id = id;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Character getRol() {
        return rol;
    }

    public void setRol(Character rol) {
        this.rol = rol;
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto(){
        StringBuilder nombreCompleto = new StringBuilder();
        if(nombres!=null)
            nombreCompleto.append(nombres).append(" ");
        if(apellidoPaterno!=null)
            nombreCompleto.append(apellidoPaterno).append(" ");
        if(apellidoMaterno!=null)
            nombreCompleto.append(apellidoMaterno).append(" ");
        return nombreCompleto.toString().toUpperCase();
    }
}
