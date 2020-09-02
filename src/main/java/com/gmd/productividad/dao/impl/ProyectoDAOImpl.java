package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.ProyectoDAO;
import com.gmd.productividad.dao.mappers.ProyectoMapper;
import com.gmd.productividad.domain.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProyectoDAOImpl extends GenericDAOImpl<Proyecto, ProyectoMapper> implements ProyectoDAO {

	@Autowired
    private ProyectoMapper mapper;

	@Override
	protected ProyectoMapper getMapper() {
		return mapper;
	}

}
