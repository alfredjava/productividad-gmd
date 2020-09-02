package com.gmd.productividad.dao.impl;

import java.util.List;

import com.gmd.productividad.dao.ActividadColaboradorDAO;
import com.gmd.productividad.dao.mappers.ActividadColaboradorMapper;
import com.gmd.productividad.domain.ActividadColaborador;
import com.gmd.productividad.domain.Colaborador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ActividadColaboradorDAOImpl extends GenericDAOImpl<ActividadColaborador, ActividadColaboradorMapper> implements ActividadColaboradorDAO {

	@Autowired
	private ActividadColaboradorMapper mapper;



	@Override
	public ActividadColaborador findByColaborador(Long idColaborador) {
		return getMapper().findByColaborador(idColaborador);
	}
    @Override
    protected ActividadColaboradorMapper getMapper() {
        return mapper;
    }
}
