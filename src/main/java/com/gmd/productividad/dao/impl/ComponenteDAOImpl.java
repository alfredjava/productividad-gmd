package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.ComponenteDAO;
import com.gmd.productividad.dao.mappers.ComponenteMapper;
import com.gmd.productividad.domain.Componente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ComponenteDAOImpl extends GenericDAOImpl<Componente, ComponenteMapper> implements ComponenteDAO {

	@Autowired
    private ComponenteMapper mapper;

	@Override
	protected ComponenteMapper getMapper() {
		return mapper;
	}

}
