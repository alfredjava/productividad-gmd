package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.TecnologiaComponenteDAO;
import com.gmd.productividad.dao.mappers.TecnologiaComponenteMapper;
import com.gmd.productividad.domain.TecnologiaComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class TecnologiaComponenteDAOImpl extends GenericDAOImpl<TecnologiaComponente, TecnologiaComponenteMapper> implements TecnologiaComponenteDAO {

	@Autowired
    private TecnologiaComponenteMapper mapper;



	public List<TecnologiaComponente> findByColaborador(Long idColaborador) {
		return getMapper().findByColaborador(idColaborador);
	}

    @Override
    public List<TecnologiaComponente> find(Character tipoDocumento, String numeroDocumento, String colaborador,Long idLenguaje, Long idTecnologia, Long idHerramienta) {
        HashMap filters = new HashMap();
        filters.put("tipoDocumento", tipoDocumento);
        filters.put("numeroDocumento", numeroDocumento);
        filters.put("colaborador", colaborador);
        filters.put("idTecnologia", idTecnologia);
        filters.put("idLenguaje", idLenguaje);
        filters.put("idHerramienta", idHerramienta);
        return getMapper().find(filters);
    }


    @Override
    protected TecnologiaComponenteMapper getMapper() {
        return mapper;
    }
}
