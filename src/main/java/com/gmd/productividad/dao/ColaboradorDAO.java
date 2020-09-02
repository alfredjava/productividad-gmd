package com.gmd.productividad.dao;

import com.gmd.productividad.domain.Colaborador;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColaboradorDAO extends GenericDAO<Colaborador, Long> {
	List<Colaborador> find(Colaborador colaborador);
	Colaborador findByUsername(String username);
	List<Colaborador>selectAll();
	List<Colaborador>findByDocAndName(Colaborador colaborador);
}
