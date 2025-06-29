/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.EstudianteRegistroDTO;
import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import dominios.EstudianteDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IEstudianteDAO {

    /**
     * Busca estudiantes con paginación y filtro de texto.
     *
     * @param filtro Objeto con criterios de búsqueda, paginación y texto a
     * filtrar.
     * @return Lista de DTOs con datos de estudiantes que coinciden con el
     * filtro.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException;

    /**
     * Busca un estudiante por su ID.
     *
     * @param id Identificador del estudiante.
     * @return El estudiante encontrado.
     * @throws PersistenciaException si no se encuentra el estudiante o hay
     * error en la consulta.
     */
    EstudianteDominio buscarPorID(int id) throws PersistenciaException;

    /**
     * Verifica si un estudiante está bloqueado.
     *
     * @param id Identificador del estudiante (idEscolar).
     * @return true si el estudiante tiene bloqueos activos, false si no.
     * @throws PersistenciaException si hay error durante la consulta.
     */
    boolean estaBloqueado(String id) throws PersistenciaException;

    /**
     * Obtiene una lista de estudiantes que tienen bloqueos activos.
     *
     * @return Lista de estudiantes con bloqueos activos.
     * @throws PersistenciaException si ocurre un error durante la consulta.
     */
    List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws PersistenciaException;

    /**
     * Busca un estudiante por su usuario (idEscolar).
     *
     * @param estudianteRegistroDTO DTO que contiene el usuario a buscar.
     * @return El estudiante encontrado.
     * @throws PersistenciaException si no se encuentra el estudiante o hay
     * error en la consulta.
     */
    EstudianteDominio buscarPorUsuario(EstudianteRegistroDTO estudianteRegistroDTO) throws PersistenciaException;

    /**
     * Actualiza la contraseña de un estudiante.
     *
     * @param estudiante Entidad estudiante con la contraseña actualizada.
     * @throws PersistenciaException si ocurre un error durante la
     * actualización.
     */
    void actualizarContraseña(EstudianteDominio estudiante) throws PersistenciaException;

}
