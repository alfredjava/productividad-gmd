package com.gmd.productividad.service;

import com.gmd.productividad.dao.ComponenteDAO;
import com.gmd.productividad.dao.ProyectoDAO;
import com.gmd.productividad.domain.Componente;
import com.gmd.productividad.domain.Proyecto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponenteService {


	@Autowired
	private ComponenteDAO componenteDAO;

    public List<Componente> findAll(){
        return componenteDAO.readAll();
    }

}
