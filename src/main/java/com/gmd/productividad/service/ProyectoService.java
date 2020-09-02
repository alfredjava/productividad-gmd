package com.gmd.productividad.service;

import com.gmd.productividad.dao.ProyectoDAO;
import com.gmd.productividad.dao.TecnologiaDAO;
import com.gmd.productividad.domain.Proyecto;
import com.gmd.productividad.domain.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyectoService {


	@Autowired
	private ProyectoDAO proyectoDAO;

    public List<Proyecto> findAll(){
        return proyectoDAO.readAll();
    }

}
