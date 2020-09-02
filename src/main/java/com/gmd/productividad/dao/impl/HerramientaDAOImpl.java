package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.HerramientaDAO;
import com.gmd.productividad.dao.mappers.HerramientaMapper;
import com.gmd.productividad.domain.Herramienta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HerramientaDAOImpl extends GenericDAOImpl<Herramienta, HerramientaMapper> implements HerramientaDAO {

	@Autowired
    private HerramientaMapper mapper;

	@Override
	protected HerramientaMapper getMapper() {
		return mapper;
	}

}
