package com.gmd.productividad.dao.mappers;

import com.gmd.productividad.domain.Colaborador;

import java.util.List;


public interface ColaboradorMapper extends GenericMapper<Colaborador> {
	List<Colaborador> find(Colaborador colaborador);
    Colaborador findByUsername(String username);
    List<Colaborador>selectAll();
    List<Colaborador>findByDocAndName(Colaborador colaborador);
}
