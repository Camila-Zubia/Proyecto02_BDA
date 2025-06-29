/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import dominios.LaboratorioDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface ILaboratorioDAO {

    /**
     * Busca un laboratorio por su ID.
     *
     * @param id Identificador del laboratorio.
     * @return DTO con los datos del laboratorio encontrado.
     * @throws PersistenciaException si no se encuentra el laboratorio o ocurre
     * un error.
     */
    LaboratorioDTO buscarPorId(int id) throws PersistenciaException;

    /**
     * Guarda un nuevo laboratorio en la base de datos.
     *
     * @param laboratorio DTO con los datos del nuevo laboratorio.
     * @return La entidad LaboratorioDominio guardada.
     * @throws PersistenciaException si ocurre un error durante el guardado.
     */
    LaboratorioDominio guardar(NuevoLaboratorioDTO laboratorio) throws PersistenciaException;

    /**
     * Modifica los datos de un laboratorio existente.
     *
     * @param laboratorio DTO con los datos actualizados del laboratorio.
     * @return La entidad LaboratorioDominio modificada.
     * @throws PersistenciaException si no se encuentra el laboratorio o ocurre
     * un error.
     */
    LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException;

    /**
     * Verifica si existe un laboratorio con el nombre dado.
     *
     * @param nombre Nombre del laboratorio a verificar.
     * @return true si existe un laboratorio con ese nombre, false en caso
     * contrario.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    boolean existePorNombre(String nombre) throws PersistenciaException;

    /**
     * Busca laboratorios con paginación y filtro de texto.
     *
     * @param filtro DTO con los criterios de búsqueda, paginación y texto a
     * filtrar.
     * @return Lista de DTOs con los laboratorios que coinciden con el filtro.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException;

    /**
     * Obtiene todos los laboratorios registrados.
     *
     * @return Lista de entidades LaboratorioDominio.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    List<LaboratorioDominio> obtenerLaboratorios() throws PersistenciaException;

    /**
     * Obtiene un laboratorio por su nombre.
     *
     * @param nombre Nombre del laboratorio.
     * @return Entidad LaboratorioDominio encontrada.
     * @throws PersistenciaException si no se encuentra el laboratorio o ocurre
     * un error.
     */
    LaboratorioDominio obtenerPorNombre(String nombre) throws PersistenciaException;

}
