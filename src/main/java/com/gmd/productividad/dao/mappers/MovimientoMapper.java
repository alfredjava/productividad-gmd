package com.gmd.productividad.dao.mappers;

import com.gmd.productividad.domain.Movimiento;

public interface MovimientoMapper extends GenericMapper<Movimiento> {
    public void deleteUltimoMovimiento(Long idAsignacion);
}
