package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.ColaboradorDAO;
import com.gmd.productividad.dao.mappers.ColaboradorMapper;
import com.gmd.productividad.domain.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ColaboradorDAOImpl extends GenericDAOImpl<Colaborador, ColaboradorMapper> implements ColaboradorDAO {

	@Autowired
	private ColaboradorMapper mapper;

	@Override
	protected ColaboradorMapper getMapper() {
		return mapper;
	}

	
	public List<Colaborador> find(Colaborador colaborador) {
		return getMapper().find(colaborador);
	}

    @Override
    public Colaborador findByUsername(String username) {
        return getMapper().findByUsername(username);
    }

    @Override
    public List<Colaborador> selectAll() {
    	// TODO Auto-generated method stub
    	return getMapper().selectAll();
    }


	@Override
	public List<Colaborador> findByDocAndName(Colaborador colaborador) {
		// TODO Auto-generated method stub
		return getMapper().findByDocAndName(colaborador);
	}

}
