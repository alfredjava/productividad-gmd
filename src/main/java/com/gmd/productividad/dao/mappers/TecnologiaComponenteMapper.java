package com.gmd.productividad.dao.mappers;

import com.gmd.productividad.domain.TecnologiaComponente;

import java.util.List;
import java.util.Map;

public interface TecnologiaComponenteMapper extends GenericMapper<TecnologiaComponente> {

	List<TecnologiaComponente> findByColaborador(Long idColaborador);
	public List<TecnologiaComponente> find(Map filters);
	
}
