package com.gmd.productividad.dao.impl;

import com.gmd.productividad.dao.TecnologiaDAO;
import com.gmd.productividad.dao.mappers.TecnologiaMapper;
import com.gmd.productividad.domain.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TecnologiaDAOImpl extends GenericDAOImpl<Tecnologia, TecnologiaMapper> implements TecnologiaDAO {

	@Autowired
    private TecnologiaMapper mapper;

    public List<Tecnologia> findByLenguaje(Long idLenguaje){
        return mapper.findByLenguaje(idLenguaje);
    }

    @Override
    protected TecnologiaMapper getMapper() {
        return mapper;
    }

}
