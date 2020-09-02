package com.gmd.productividad.dao.mappers;

import com.gmd.productividad.domain.ActividadColaborador;

public interface ActividadColaboradorMapper extends GenericMapper<ActividadColaborador> {
	public ActividadColaborador findByColaborador(Long idColaborador);
}
