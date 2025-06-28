/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IBloqueoNegocio {

    /**
     * Registra un nuevo bloqueo en el sistema.
     *
     * @param bloqueo Entidad BloqueoDominio que contiene los datos del bloqueo
     * a registrar.
     * @return La entidad BloqueoDominio registrada.
     * @throws NegocioException Si ocurre algún error durante el proceso de
     * registro.
     */
    BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException;

    /**
     * Busca un bloqueo por su identificador único.
     *
     * @param id El identificador único del bloqueo.
     * @return La entidad BloqueoDominio correspondiente al ID proporcionado.
     * @throws NegocioException Si el bloqueo no existe o ocurre un error
     * durante la búsqueda.
     */
    BloqueoDominio buscarPorId(int id) throws NegocioException;

    /**
     * Libera (desactiva o elimina) un bloqueo existente.
     *
     * @param id El identificador único del bloqueo a liberar.
     * @throws NegocioException Si el bloqueo no puede ser liberado o no existe.
     */
    void liberarBloqueo(int id) throws NegocioException;

    /**
     * Obtiene todos los bloqueos que actualmente están activos.
     *
     * @return Lista de entidades BloqueoDominio activas.
     * @throws NegocioException Si ocurre un error al recuperar la información.
     */
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException;

    /**
     * Busca bloqueos aplicando los filtros indicados y devuelve una lista en
     * formato tabla.
     *
     * @param filtro DTO que contiene los parámetros para filtrar los bloqueos.
     * @return Lista de TablaBloqueosDTO que cumplen con los filtros aplicados.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

}
