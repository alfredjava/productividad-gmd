package com.gmd.productividad.web;

import com.gmd.productividad.domain.*;
import com.gmd.productividad.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Todos los elementos estan precargados en esta clase, si no existen, se cargan de la base de datos, solo una vez
 */
@Controller("comboModelActionBean")
@Scope("session")
public class ComboModelActionBean {

    @Autowired
    private ParametroService parametroService;
    @Autowired
    private TecnologiaService tecnologiaService;
    @Autowired
    private HerramientaService herramientaService;
    @Autowired
    private LenguajeService lenguajeService;
    @Autowired
    private ProyectoService proyectoService;
    @Autowired
    private ComponenteService componenteService;

    private List<Parametro> listaTipoProceso;
    private List<Parametro> listaTipoActividad;
    private List<Parametro> listaComplejidad;
    private List<Parametro> listaTipoTarea;
    private List<Parametro> listaEstadoAsignacion;
    private List<Parametro> listaTipoDocumento;
    private Map<Long, List<Tecnologia>> listaTecnologia=new HashMap<Long, List<Tecnologia>>();//<Lenguaje Id, List tecnologias>
    private List<Herramienta> listaHerramienta;
    private List<Lenguaje> listaLenguaje;
    private List<Proyecto> listaProyecto;
    private List<Componente> listaComponente;


    public List<Parametro> getListaTipoProceso() {
        if(listaTipoProceso ==null)
            listaTipoProceso = parametroService.listarTiposProceso();
        return listaTipoProceso;
    }
    public List<Parametro> getListaTipoActividad() {
        if(listaTipoActividad==null)
            listaTipoActividad = parametroService.listarTiposActividad();
        return listaTipoActividad;
    }
    public List<Parametro> getListaComplejidad() {
        if(listaComplejidad == null)
            listaComplejidad = parametroService.listarIndicadoresComplejidad();
        return listaComplejidad;
    }
    public List<Parametro> getListaTipoTarea() {
        if(listaTipoTarea == null)
            listaTipoTarea = parametroService.listarTiposTarea();
        return listaTipoTarea;
    }
    public List<Parametro> getListaEstadoAsignacion() {
        if(listaEstadoAsignacion == null)
            listaEstadoAsignacion = parametroService.listarEstadoSegunMovimiento();
        return listaEstadoAsignacion;

    }
    public List<Parametro> getListaTipoDocumento() {
        if(listaTipoDocumento==null)
            listaTipoDocumento = parametroService.listarTiposDocumento();
        return listaTipoDocumento;

    }

    public List<Tecnologia> getListaTecnologia(Long idLenguaje) {
        if(!listaTecnologia.containsKey(idLenguaje))
            listaTecnologia.put(idLenguaje, tecnologiaService.findByLenguaje(idLenguaje));
        return listaTecnologia.get(idLenguaje);
    }
    public List<Herramienta> getListaHerramienta() {
        if(listaHerramienta==null)
            listaHerramienta = herramientaService.findAll();
        return listaHerramienta;
    }
    public List<Lenguaje> getListaLenguaje() {
        if(listaLenguaje==null)
            listaLenguaje = lenguajeService.findAll();
        return listaLenguaje;
    }
    public List<Proyecto> getListaProyecto() {
        if(listaProyecto == null)
            listaProyecto = proyectoService.findAll();
        return listaProyecto;
    }
    public List<Componente> getListaComponente() {
        if(listaComponente==null)
            listaComponente = componenteService.findAll();
        return listaComponente;
    }


    public Parametro getTipoProceso(Long value){
        return findParametro(getListaTipoProceso().iterator(), value.toString());
    }
    public Parametro getIndicadorComplejidad(Long value){
        return findParametro(getListaComplejidad().iterator(), value.toString());
    }
    public Parametro getTipoTarea(Long value) {
        return findParametro(getListaTipoTarea().iterator(), value.toString());
    }
    public Parametro getEstadoSegunMovimiento(String value) {
        return findParametro(getListaEstadoAsignacion().iterator(), value);
    }

    private Parametro findParametro(Iterator<Parametro> it, String value){
        while(it.hasNext()){
            Parametro parametro = it.next();
            if(parametro.getValor().equals(value))
                return parametro;
        }
        return null;
    }
}
