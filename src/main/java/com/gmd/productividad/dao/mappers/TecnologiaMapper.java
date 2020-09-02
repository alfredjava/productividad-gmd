package com.gmd.productividad.dao.mappers;

import com.gmd.productividad.domain.Tecnologia;

import java.util.List;

public interface TecnologiaMapper extends GenericMapper<Tecnologia> {
    List<Tecnologia> findByLenguaje(Long idLenguaje);
}
