package com.gmd.productividad.dao;

import com.gmd.productividad.domain.Parametro;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParametroDAO extends GenericDAO<Parametro, Long> {
    public List<Parametro> findByTipo(String tipo);
    public Parametro findByTipoValor(String tipo, String valor);
}
