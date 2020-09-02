package com.gmd.productividad.service;

import com.gmd.productividad.dao.HerramientaDAO;
import com.gmd.productividad.dao.TecnologiaDAO;
import com.gmd.productividad.domain.Herramienta;
import com.gmd.productividad.domain.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HerramientaService {


	@Autowired
	private HerramientaDAO herramientaDAO;

    public List<Herramienta> findAll(){
        return herramientaDAO.readAll();
    }

}
