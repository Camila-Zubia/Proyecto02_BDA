/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import dominios.BloqueoDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IBloqueoDAO {

    /**
     * Registra un nuevo bloqueo en la base de datos.
     *
     * @param bloqueo Objeto BloqueoDominio a registrar.
     * @return BloqueoDominio registrado con ID generado.
     * @throws PersistenciaException Si ocurre un error al guardar.
     */
    BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws PersistenciaException;

    /**
     * Busca un bloqueo por su ID.
     *
     * @param id ID del bloqueo a buscar.
     * @return BloqueoDominio encontrado.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    BloqueoDominio buscarPorId(int id) throws PersistenciaException;

    /**
     * Libera un bloqueo, cambiando su estatus y fecha de liberación.
     *
     * @param id ID del bloqueo a liberar.
     * @throws PersistenciaException Si no se encuentra o hay error al liberar.
     */
    void liberarBloqueo(int id) throws PersistenciaException;

    /**
     * Busca bloqueos con filtros y paginación para mostrar en tabla.
     *
     * @param filtro DTO con parámetros de filtro, offset y límite.
     * @return Lista de TablaBloqueosDTO con los resultados.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException;

    /**
     * Obtiene todos los bloqueos activos.
     *
     * @return Lista de bloqueos activos.
     * @throws PersistenciaException Si ocurre un error en la consulta.
     */
    List<BloqueoDominio> obtenerBloqueosActivos() throws PersistenciaException;

}
