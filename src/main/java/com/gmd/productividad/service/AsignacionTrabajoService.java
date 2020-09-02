package com.gmd.productividad.service;

import com.gmd.productividad.dao.AsignacionTrabajoDAO;
import com.gmd.productividad.domain.AsignacionTrabajo;
import com.gmd.productividad.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: GMD
 * Date: 11/01/13
 * Time: 05:45 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class AsignacionTrabajoService {
    @Autowired
    private AsignacionTrabajoDAO asignacionTrabajoDAO;


    public List<AsignacionTrabajo> findByColaborador(Long idColaborador){
        return asignacionTrabajoDAO.findByColaborador(idColaborador);
    }
    public List<AsignacionTrabajo> find(String colaborador, String up, String tipoProceso, Date fechaInicio, Date fechaFin, Date fechaFinReal, List estados){
        return asignacionTrabajoDAO.find(colaborador, up, tipoProceso, fechaInicio, fechaFin, fechaFinReal, estados);
    }

    public void save(AsignacionTrabajo asignacionTrabajo) {
        asignacionTrabajo.setEstado(Constantes.ST_ACTIVO);
        asignacionTrabajoDAO.create(asignacionTrabajo);
    }

    public void delete(Long idAsignacion) {
        asignacionTrabajoDAO.delete(idAsignacion);
    }

}
