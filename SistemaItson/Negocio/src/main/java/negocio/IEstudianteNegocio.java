/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

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
public interface IEstudianteNegocio {

    /**
     * Busca y devuelve una lista de estudiantes en formato tabla, aplicando los
     * filtros proporcionados.
     *
     * @param filtro Objeto DTO con los criterios de filtrado.
     * @return Lista de objetos TablaEstudiantesDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    /**
     * Busca un estudiante por su identificador único.
     *
     * @param id El identificador del estudiante.
     * @return La entidad EstudianteDominio correspondiente al ID proporcionado.
     * @throws NegocioException Si el estudiante no existe o si ocurre un error
     * durante la búsqueda.
     */
    EstudianteDominio buscarPorID(int id) throws NegocioException;

    /**
     * Verifica si un estudiante se encuentra bloqueado.
     *
     * @param id Identificador del estudiante (por ejemplo, matrícula o clave).
     * @return true si el estudiante está bloqueado, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante la verificación.
     */
    boolean estaBloqueado(String id) throws NegocioException;

    /**
     * Obtiene una lista de estudiantes que actualmente tienen bloqueos activos.
     *
     * @return Lista de entidades EstudianteDominio con bloqueos activos.
     * @throws NegocioException Si ocurre un error al recuperar la información.
     */
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException;

    /**
     * Inicia sesión de un estudiante usando las credenciales proporcionadas.
     *
     * @param estudianteRegistroDTO DTO que contiene los datos necesarios para
     * autenticación (como matrícula y contraseña).
     * @return La entidad EstudianteDominio correspondiente al estudiante
     * autenticado.
     * @throws NegocioException Si las credenciales son incorrectas o si ocurre
     * un error durante la autenticación.
     */
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException;
   
    public EstudianteDominio buscarPorUsuario(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException;

}
