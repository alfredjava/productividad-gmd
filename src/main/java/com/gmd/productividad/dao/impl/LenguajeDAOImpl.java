package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.HerramientaDAO;
import com.gmd.productividad.dao.LenguajeDAO;
import com.gmd.productividad.dao.mappers.HerramientaMapper;
import com.gmd.productividad.dao.mappers.LenguajeMapper;
import com.gmd.productividad.domain.Herramienta;
import com.gmd.productividad.domain.Lenguaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LenguajeDAOImpl extends GenericDAOImpl<Lenguaje, LenguajeMapper> implements LenguajeDAO {

	@Autowired
    private LenguajeMapper mapper;

	@Override
	protected LenguajeMapper getMapper() {
		return mapper;
	}

}
