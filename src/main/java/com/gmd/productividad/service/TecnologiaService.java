package com.gmd.productividad.service;

import com.gmd.productividad.dao.TecnologiaDAO;
import com.gmd.productividad.domain.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaService {


	@Autowired
	private TecnologiaDAO tecnologiaDAO;

    public List<Tecnologia> findAll(){
        return tecnologiaDAO.readAll();
    }
    public List<Tecnologia> findByLenguaje(Long idLenguaje){
        return tecnologiaDAO.findByLenguaje(idLenguaje);
    }
}
