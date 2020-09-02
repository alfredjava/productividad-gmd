package com.gmd.productividad.dao;

import com.gmd.productividad.domain.Movimiento;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoDAO extends GenericDAO<Movimiento, Long> {
    public void deleteUltimoMovimiento(Long idAsignacion);
}
