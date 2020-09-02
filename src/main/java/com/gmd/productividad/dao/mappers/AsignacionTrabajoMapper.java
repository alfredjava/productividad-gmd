package com.gmd.productividad.dao.mappers;

import com.gmd.productividad.domain.AsignacionTrabajo;

import java.util.List;
import java.util.Map;

public interface AsignacionTrabajoMapper extends GenericMapper<AsignacionTrabajo> {
    public List<AsignacionTrabajo> find(Map hashMap);
    public List<AsignacionTrabajo> findByColaborador(Long idColaborador);
}
