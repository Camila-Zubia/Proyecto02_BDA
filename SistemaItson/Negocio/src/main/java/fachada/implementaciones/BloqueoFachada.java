/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import daos.IBloqueoDAO;
import daos.IConexionBD;
import daos.implementaciones.BloqueoDAO;
import daos.implementaciones.ConexionBD;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import fachada.IBloqueoFachada;
import java.util.List;
import negocio.IBloqueoNegocio;
import negocio.implementaciones.BloqueoNegocio;

/**
 *
 * @author adell
 */
public class BloqueoFachada implements IBloqueoFachada {

    private final IBloqueoNegocio bloqueoNegocio;

    public BloqueoFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(conexionBD);
        this.bloqueoNegocio = new BloqueoNegocio(bloqueoDAO);
    }

    /**
     * Registra un nuevo bloqueo en el sistema.
     *
     * @param bloqueo Entidad BloqueoDominio con los datos del bloqueo a
     * registrar.
     * @return La entidad BloqueoDominio recién creada y persistida.
     * @throws NegocioException Si ocurre algún error durante el registro.
     */
    @Override
    public BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        return bloqueoNegocio.registrarBloqueo(bloqueo);
    }

    /**
     * Busca un bloqueo por su identificador único.
     *
     * @param id El identificador único del bloqueo.
     * @return La entidad BloqueoDominio correspondiente al ID proporcionado.
     * @throws NegocioException Si el bloqueo no existe o ocurre un error
     * durante la búsqueda.
     */
    @Override
    public BloqueoDominio buscarPorId(int id) throws NegocioException {
        return bloqueoNegocio.buscarPorId(id);
    }

    /**
     * Libera (elimina o desactiva) un bloqueo existente.
     *
     * @param id El identificador único del bloqueo a liberar.
     * @throws NegocioException Si el bloqueo no existe o no puede ser liberado.
     */
    @Override
    public void liberarBloqueo(int id) throws NegocioException {
        bloqueoNegocio.liberarBloqueo(id);
    }

    /**
     * Obtiene una lista de todos los bloqueos que están activos.
     *
     * @return Lista de entidades BloqueoDominio activas.
     * @throws NegocioException Si ocurre algún error al recuperar la lista.
     */
    @Override
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException {
        return bloqueoNegocio.obtenerBloqueosActivos();
    }

    /**
     * Busca bloqueos según los filtros indicados y devuelve una lista en
     * formato tabla.
     *
     * @param filtro Objeto que contiene los criterios para filtrar los
     * bloqueos.
     * @return Lista de TablaBloqueosDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
    @Override
    public List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return bloqueoNegocio.buscarTabla(filtro);
    }

}
