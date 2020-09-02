package com.gmd.productividad.dao;

import com.gmd.productividad.domain.Tecnologia;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TecnologiaDAO extends GenericDAO<Tecnologia, Long> {
    List<Tecnologia> findByLenguaje(Long idLenguaje);

}
