package com.gmd.productividad.dao;

import com.gmd.productividad.domain.ActividadColaborador;
import org.springframework.stereotype.Repository;

@Repository
public interface ActividadColaboradorDAO extends GenericDAO<ActividadColaborador, Long> {
	public ActividadColaborador findByColaborador(Long idColaborador);
	
}
