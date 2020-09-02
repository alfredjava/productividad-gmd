package com.gmd.productividad.dao;

import com.gmd.productividad.domain.TecnologiaComponente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiaComponenteDAO extends GenericDAO<TecnologiaComponente, Long> {
	public List<TecnologiaComponente> findByColaborador(Long id);
	public List<TecnologiaComponente> find(Character tipoDocumento, String numeroDocumento, String colaborador, Long idLenguaje, Long idTecnologia, Long idHerramienta);
}
