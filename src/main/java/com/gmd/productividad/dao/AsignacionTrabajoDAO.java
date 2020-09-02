package com.gmd.productividad.dao;

import com.gmd.productividad.domain.AsignacionTrabajo;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AsignacionTrabajoDAO extends GenericDAO<AsignacionTrabajo, Long> {
    public List<AsignacionTrabajo> find(String colaborador, String up, String tipoProceso, Date fechaInicio, Date fechaFin, Date fechaFinReal, List estados);
    public List<AsignacionTrabajo> findByColaborador(Long idColaborador);
}
