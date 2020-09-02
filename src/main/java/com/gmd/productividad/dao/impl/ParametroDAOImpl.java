package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.ParametroDAO;
import com.gmd.productividad.dao.mappers.ParametroMapper;
import com.gmd.productividad.domain.Parametro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParametroDAOImpl extends GenericDAOImpl<Parametro, ParametroMapper> implements ParametroDAO {

	@Autowired
	private ParametroMapper mapper;

	public List<Parametro> findByTipo(String tipo){
        return mapper.findByTipo(tipo);
    }



    public Parametro findByTipoValor(String tipo, String valor){
        return mapper.findByTipoValor(tipo, valor);
    }
    @Override
    protected ParametroMapper getMapper() {
        return mapper;
    }
}
