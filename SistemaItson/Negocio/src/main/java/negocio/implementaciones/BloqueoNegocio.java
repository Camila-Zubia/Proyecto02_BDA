/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import daos.IBloqueoDAO;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IBloqueoNegocio;

/**
 *
 * @author adell
 */
public class BloqueoNegocio implements IBloqueoNegocio {

    private IBloqueoDAO bloqueoDAO;

    public BloqueoNegocio(IBloqueoDAO bloqueoDAO) {
        this.bloqueoDAO = bloqueoDAO;
    }

    @Override
    public BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        try {
            motivoBloqueo(bloqueo);
            validarFechaBloqueo(bloqueo.getFechaBloqueo());
            return bloqueoDAO.registrarBloqueo(bloqueo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al registrar un bloqueo");
        }
    }

    @Override
    public BloqueoDominio buscarPorId(int id) throws NegocioException {
        try {
            idInvalida(id);
            validarBloqueo(id);
            return bloqueoDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar buscar un bloqeuo por id");
        }
    }

    @Override
    public void liberarBloqueo(int id) throws NegocioException {
        try {

            idInvalida(id);
            validarBloqueo(id);
            bloqueoDAO.liberarBloqueo(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar liberar un bloqeuo por id");
        }
    }

    @Override
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException {
        try {
            return bloqueoDAO.obtenerBloqueosActivos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar obtener los bloqueos activos");
        }
    }

    @Override
    public List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            return bloqueoDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar buscar la tabla de bloqueos");
        }
    }

    /**
     * VALIDACIONES
     */
    private void validarFechaBloqueo(Date fechaBloqueo) throws NegocioException {
        if (fechaBloqueo == null) {
            throw new NegocioException("Error al registrar la fecha de bloqueo");
        }
    }

    private void validarFechaLiberacion(Date fechaLiberacion) throws NegocioException {
        if (fechaLiberacion == null) {
            throw new NegocioException("Error al registrar la fecha de liberacion");
        }
    }

    private void validarBloqueo(int id) throws NegocioException, PersistenciaException {

        BloqueoDominio bloqueo = bloqueoDAO.buscarPorId(id);
        if (bloqueo == null) {
            throw new NegocioException("No se encontro un bloqueo con el id: " + id);

        }

        if (!bloqueo.isEstatus()) {
            throw new NegocioException("El bloqueo se encuentra liberado");
        }

    }

    private void motivoBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        if (bloqueo.getMotivo().isEmpty()) {
            throw new NegocioException("El motivo del bloqueo no puede estar vacio");
        }

        if (bloqueo.getMotivo().length() > 50) {
            throw new NegocioException("El motivo del bloqueo no puede ser mayor a 50 caracteres");
        }
    }

    private void idInvalida(int id) throws NegocioException {
        if (id < 0) {
            throw new NegocioException("El id no puede ser menor a 0");
        }
    }

}
