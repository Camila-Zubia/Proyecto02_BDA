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

    /**
     * Registra un nuevo bloqueo luego de validar motivo y fecha.
     *
     * @param bloqueo Entidad BloqueoDominio con la información del bloqueo a
     * registrar.
     * @return El bloqueo registrado.
     * @throws NegocioException Si ocurre un error de validación o persistencia.
     */
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

    /**
     * Busca un bloqueo por su ID tras validar que el ID sea válido y que el
     * bloqueo exista y esté activo.
     *
     * @param id Identificador del bloqueo a buscar.
     * @return El bloqueo correspondiente al ID.
     * @throws NegocioException Si el ID es inválido, el bloqueo no existe o
     * está liberado.
     */
    @Override
    public BloqueoDominio buscarPorId(int id) throws NegocioException {
        try {
            idInvalida(id);
            validarBloqueo(id);
            return bloqueoDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar buscar un bloqueo por id");
        }
    }

    /**
     * Libera (desactiva) un bloqueo tras validar el ID y la existencia del
     * bloqueo.
     *
     * @param id Identificador del bloqueo a liberar.
     * @throws NegocioException Si el ID es inválido, el bloqueo no existe o
     * ocurre un error al liberar.
     */
    @Override
    public void liberarBloqueo(int id) throws NegocioException {
        try {
            idInvalida(id);
            validarBloqueo(id);
            bloqueoDAO.liberarBloqueo(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar liberar un bloqueo por id");
        }
    }

    /**
     * Obtiene la lista de todos los bloqueos que están activos.
     *
     * @return Lista de bloqueos activos.
     * @throws NegocioException Si ocurre un error al obtener los bloqueos.
     */
    @Override
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException {
        try {
            return bloqueoDAO.obtenerBloqueosActivos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar obtener los bloqueos activos");
        }
    }

    /**
     * Busca bloqueos en formato tabla según los filtros proporcionados.
     *
     * @param filtro DTO con los criterios para filtrar bloqueos.
     * @return Lista de bloqueos en formato TablaBloqueosDTO.
     * @throws NegocioException Si ocurre un error al buscar los bloqueos.
     */
    @Override
    public List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            return bloqueoDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar buscar la tabla de bloqueos");
        }
    }

    /* ====================
   VALIDACIONES PRIVADAS
   ==================== */
    /**
     * Valida que la fecha de bloqueo no sea nula.
     *
     * @param fechaBloqueo Fecha del bloqueo.
     * @throws NegocioException Si la fecha es nula.
     */
    private void validarFechaBloqueo(Date fechaBloqueo) throws NegocioException {
        if (fechaBloqueo == null) {
            throw new NegocioException("Error al registrar la fecha de bloqueo");
        }
    }

    /**
     * Valida que la fecha de liberación no sea nula.
     *
     * @param fechaLiberacion Fecha de liberación.
     * @throws NegocioException Si la fecha es nula.
     */
    private void validarFechaLiberacion(Date fechaLiberacion) throws NegocioException {
        if (fechaLiberacion == null) {
            throw new NegocioException("Error al registrar la fecha de liberacion");
        }
    }

    /**
     * Valida que el bloqueo exista, esté activo y que su ID sea válido.
     *
     * @param id Identificador del bloqueo.
     * @throws NegocioException Si el bloqueo no existe o está liberado.
     * @throws PersistenciaException Si hay un error de persistencia.
     */
    private void validarBloqueo(int id) throws NegocioException, PersistenciaException {
        BloqueoDominio bloqueo = bloqueoDAO.buscarPorId(id);
        if (bloqueo == null) {
            throw new NegocioException("No se encontró un bloqueo con el id: " + id);
        }
        if (!bloqueo.isEstatus()) {
            throw new NegocioException("El bloqueo se encuentra liberado");
        }
    }

    /**
     * Valida que el motivo del bloqueo no esté vacío ni exceda 50 caracteres.
     *
     * @param bloqueo BloqueoDominio con el motivo a validar.
     * @throws NegocioException Si el motivo no es válido.
     */
    private void motivoBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        if (bloqueo.getMotivo().isEmpty()) {
            throw new NegocioException("El motivo del bloqueo no puede estar vacío");
        }
        if (bloqueo.getMotivo().length() > 50) {
            throw new NegocioException("El motivo del bloqueo no puede ser mayor a 50 caracteres");
        }
    }

    /**
     * Valida que el ID no sea negativo.
     *
     * @param id Identificador a validar.
     * @throws NegocioException Si el ID es menor a 0.
     */
    private void idInvalida(int id) throws NegocioException {
        if (id < 0) {
            throw new NegocioException("El id no puede ser menor a 0");
        }
    }

}
