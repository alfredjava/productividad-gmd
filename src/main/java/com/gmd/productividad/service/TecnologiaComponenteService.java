package com.gmd.productividad.service;

import com.gmd.productividad.dao.TecnologiaComponenteDAO;
import com.gmd.productividad.domain.TecnologiaComponente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnologiaComponenteService {
    @Autowired
    private TecnologiaComponenteDAO tecnologiaComponenteDAO;

    public void save(TecnologiaComponente tecnologiaComponente){
        tecnologiaComponenteDAO.create(tecnologiaComponente);
    }
    public void delete(Long idTecnologiaComponente){
        tecnologiaComponenteDAO.delete(idTecnologiaComponente);
    }
    public List<TecnologiaComponente> findByColaborador(Long idColaborador){
        return tecnologiaComponenteDAO.findByColaborador(idColaborador);
    }
    public List<TecnologiaComponente> find(Character tipoDocumento, String numeroDocumento, String colaborador, Long idLenguaje, Long idTecnologia, Long idHerramienta){
        return tecnologiaComponenteDAO.find(tipoDocumento,numeroDocumento,colaborador,idLenguaje,idTecnologia,idHerramienta);
    }
}
