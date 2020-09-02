package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.AsignacionTrabajoDAO;
import com.gmd.productividad.dao.MovimientoDAO;
import com.gmd.productividad.dao.mappers.AsignacionTrabajoMapper;
import com.gmd.productividad.domain.AsignacionTrabajo;
import com.gmd.productividad.domain.Movimiento;
import com.gmd.productividad.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Repository
public class AsignacionTrabajoDAOImpl extends GenericDAOImpl<AsignacionTrabajo, AsignacionTrabajoMapper> implements AsignacionTrabajoDAO {

    @Autowired
    private AsignacionTrabajoMapper mapper;
    
    @Autowired
    private MovimientoDAO movimientoDAO;

    public List<AsignacionTrabajo> find(String colaborador, String up, String tipoProceso, Date fechaInicio, Date fechaFin, Date fechaFinReal, List estados) {
        HashMap hashMap = new HashMap();
        hashMap.put("up", up);
        hashMap.put("tipoProceso", tipoProceso);
        hashMap.put("fechaInicio", fechaInicio);
        hashMap.put("fechaFin", fechaFin);
        hashMap.put("fechaFinReal", fechaFinReal);
        hashMap.put("colaborador", colaborador);
        hashMap.put("estados", estados);

        return getMapper().find(hashMap);
    }

    @Override
    public List<AsignacionTrabajo> findByColaborador(Long idColaborador) {
        return getMapper().findByColaborador(idColaborador);
    }

	@Override
	@Transactional
	public Long create(AsignacionTrabajo asignacion) {
		Long id = super.create(asignacion);
        Movimiento movimiento = new Movimiento();
        movimiento.setAccion(Constantes.ASIGNACION);
        movimiento.setEstado(Constantes.ST_ACTIVO);
        movimiento.setFecha(new Date());
        movimiento.setAsignacion(asignacion);
        movimientoDAO.create(movimiento);
		return id;
	}


    @Override
    protected AsignacionTrabajoMapper getMapper() {
        return mapper;
    }

}
