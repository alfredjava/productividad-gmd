package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.MovimientoDAO;
import com.gmd.productividad.dao.mappers.MovimientoMapper;
import com.gmd.productividad.domain.Movimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MovimientoDAOImpl extends GenericDAOImpl<Movimiento, MovimientoMapper> implements MovimientoDAO {

	@Autowired
	private MovimientoMapper mapper;

	@Override
	protected MovimientoMapper getMapper() {
		return mapper;
	}

    @Override
    public void deleteUltimoMovimiento(Long idAsignacion) {
        mapper.deleteUltimoMovimiento(idAsignacion);
    }
}
