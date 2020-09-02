package com.gmd.productividad.service;

import com.gmd.productividad.dao.ColaboradorDAO;
import com.gmd.productividad.domain.Colaborador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColaboradorService {
	@Autowired
	private ColaboradorDAO colaboradorDAO;

	public void save(Colaborador colaborador){
        colaborador.setPassword(new ShaPasswordEncoder().encodePassword(colaborador.getPassword(),""));
		colaboradorDAO.create(colaborador);
	}
	public List<Colaborador> find(Colaborador colaborador){
		return colaboradorDAO.find(colaborador);
	}
    public Colaborador findByUsername(String username){
        return colaboradorDAO.findByUsername(username);
    }
    
    public List<Colaborador> readAll(){
		return colaboradorDAO.readAll();
	}
    
    public List<Colaborador>findByDocAndName(Colaborador colaborador){
    	return colaboradorDAO.findByDocAndName(colaborador);
    }
}
