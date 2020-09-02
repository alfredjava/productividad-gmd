package com.gmd.productividad.service;

import com.gmd.productividad.dao.ActividadColaboradorDAO;
import com.gmd.productividad.domain.ActividadColaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadColaboradorService {
	@Autowired
	private ActividadColaboradorDAO actividadColaboradorDAO;
	
	public void insert(ActividadColaborador actividadColaborador){
		actividadColaboradorDAO.create(actividadColaborador);
	}
	public ActividadColaborador findByColaborador(Long idColaborador){
		return actividadColaboradorDAO.findByColaborador(idColaborador);
	}
	public void update(ActividadColaborador actividadColaborador){
		actividadColaboradorDAO.update(actividadColaborador);
	}
}
