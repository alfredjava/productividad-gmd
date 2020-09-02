package com.gmd.productividad.service;

import com.gmd.productividad.dao.AsignacionTrabajoDAO;
import com.gmd.productividad.dao.MovimientoDAO;
import com.gmd.productividad.domain.AsignacionTrabajo;
import com.gmd.productividad.domain.Movimiento;
import com.gmd.productividad.util.Constantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MovimientoService {
	@Autowired
	private MovimientoDAO movimientoDAO;
    @Autowired
    private AsignacionTrabajoDAO asignacionTrabajoDAO;

    public void deleteUltimoMovimiento(Long idAsignacion){
        movimientoDAO.deleteUltimoMovimiento(idAsignacion);
    }

    private void registrarMovimiento(Long idAsignacion, String accion){
        Movimiento movimiento = new Movimiento();
        AsignacionTrabajo asignacionTrabajo = new AsignacionTrabajo();
        asignacionTrabajo.setId(idAsignacion);
        movimiento.setAccion(accion);
        movimiento.setEstado(Constantes.ST_ACTIVO);
        movimiento.setFecha(new Date());
        movimiento.setAsignacion(asignacionTrabajo);
        movimientoDAO.create(movimiento);
    }
	public void tomarAsignacion(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.ASIGNACION_TOMADA);
        /*AsignacionTrabajo asignacionTrabajo = asignacionTrabajoDAO.read(idAsignacion);
        asignacionTrabajo.setFechaInicio(new Date());*/
        /*asignacionTrabajoDAO.update(asignacionTrabajo);*/
	}
    public void finalizarDesarrollo(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.DESARROLLO_FINALIZADO);
    }
    public void finalizarUP(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.FINALIZADO);
    }
    public void retrabajo(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.RETRABAJO);
    }
    public void ajuste(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.AJUSTE);
    }
    public void tomarRetrabajo(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.RETRABAJO_TOMADO);
    }
    public void tomarAjuste(Long idAsignacion){
        registrarMovimiento(idAsignacion, Constantes.AJUSTE_TOMADO);
    }



}
