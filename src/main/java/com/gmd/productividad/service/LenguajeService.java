package com.gmd.productividad.service;

import com.gmd.productividad.dao.LenguajeDAO;
import com.gmd.productividad.dao.ParametroDAO;
import com.gmd.productividad.dao.TecnologiaDAO;
import com.gmd.productividad.domain.Lenguaje;
import com.gmd.productividad.domain.Parametro;
import com.gmd.productividad.domain.Tecnologia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LenguajeService {

    @Autowired
    private LenguajeDAO lenguajeDAO;

    public List<Lenguaje> findAll(){
        return lenguajeDAO.readAll();
    }

}
