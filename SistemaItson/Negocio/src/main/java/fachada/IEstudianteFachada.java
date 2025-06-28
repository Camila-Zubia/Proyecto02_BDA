/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.EstudianteRegistroDTO;
import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import dominios.EstudianteDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IEstudianteFachada {

    /**
     * Busca y devuelve una lista de estudiantes en formato tabla, filtrados
     * según los criterios proporcionados.
     *
     * @param filtro Objeto que contiene los criterios para filtrar los
     * estudiantes.
     * @return Lista de TablaEstudiantesDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
    public List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    /**
     * Busca un estudiante por su identificador único.
     *
     * @param id El identificador único del estudiante.
     * @return La entidad EstudianteDominio correspondiente al ID proporcionado.
     * @throws NegocioException Si el estudiante no existe o ocurre un error
     * durante la búsqueda.
     */
    public EstudianteDominio buscarPorID(int id) throws NegocioException;

    /**
     * Verifica si un estudiante está bloqueado.
     *
     * @param id Identificador del estudiante (puede ser matrícula o clave).
     * @return true si el estudiante está bloqueado, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante la verificación.
     */
    boolean estaBloqueado(String id) throws NegocioException;


    
    
    public EstudianteDominio buscarPorUsuario(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException;

    /**
     * Obtiene una lista de estudiantes que tienen bloqueos activos.
     *
     * @return Lista de entidades EstudianteDominio con bloqueos activos.
     * @throws NegocioException Si ocurre un error al obtener la lista.
     */
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException;

    /**
     * Inicia sesión de un estudiante con los datos proporcionados.
     *
     * @param estudianteRegistroDTO DTO que contiene las credenciales o datos
     * para iniciar sesión.
     * @return La entidad EstudianteDominio correspondiente al estudiante
     * autenticado.
     * @throws NegocioException Si las credenciales son incorrectas o ocurre un
     * error durante el proceso.
     */
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException;


}
