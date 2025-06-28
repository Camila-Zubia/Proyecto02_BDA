/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import DTO.EstudianteRegistroDTO;
import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import daos.IConexionBD;
import daos.IEstudianteDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.EstudianteDAO;
import dominios.EstudianteDominio;
import excepciones.NegocioException;
import fachada.IEstudianteFachada;
import java.util.List;
import negocio.IEstudianteNegocio;
import negocio.implementaciones.EstudianteNegocio;

/**
 *
 * @author adell
 */
public class EstudianteFachada implements IEstudianteFachada {

    private final IEstudianteNegocio estudianteNegocio;

    public EstudianteFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IEstudianteDAO estudianteDAO = new EstudianteDAO(conexionBD);
        this.estudianteNegocio = new EstudianteNegocio(estudianteDAO);
    }

    /**
     * Busca y devuelve una lista de estudiantes en formato tabla, filtrados
     * según los criterios proporcionados.
     *
     * @param filtro Objeto que contiene los criterios para filtrar los
     * estudiantes.
     * @return Lista de TablaEstudiantesDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
    @Override
    public List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return estudianteNegocio.buscarTabla(filtro);
    }

    /**
     * Busca un estudiante por su identificador único.
     *
     * @param id El identificador único del estudiante.
     * @return La entidad EstudianteDominio correspondiente al ID proporcionado.
     * @throws NegocioException Si el estudiante no existe o ocurre un error
     * durante la búsqueda.
     */
    @Override
    public EstudianteDominio buscarPorID(int id) throws NegocioException {
        return estudianteNegocio.buscarPorID(id);
    }

    /**
     * Verifica si un estudiante está bloqueado.
     *
     * @param id Identificador del estudiante (por ejemplo, matrícula o clave).
     * @return true si el estudiante está bloqueado, false en caso contrario.
     * @throws NegocioException Si ocurre un error durante la verificación.
     */
    @Override
    public boolean estaBloqueado(String id) throws NegocioException {
        return estudianteNegocio.estaBloqueado(id);
    }

    /**
     * Obtiene una lista de estudiantes que tienen bloqueos activos.
     *
     * @return Lista de entidades EstudianteDominio con bloqueos activos.
     * @throws NegocioException Si ocurre un error al obtener la lista.
     */
    @Override
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException {
        return estudianteNegocio.obtenerEstudiantesConBloqueosActivos();
    }

    /**
     * Inicia sesión de un estudiante con las credenciales proporcionadas.
     *
     * @param estudianteRegistroDTO DTO que contiene los datos necesarios para
     * iniciar sesión.
     * @return La entidad EstudianteDominio correspondiente al estudiante
     * autenticado.
     * @throws NegocioException Si las credenciales son incorrectas o ocurre un
     * error durante el proceso.
     */
    @Override
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException {
        return estudianteNegocio.iniciarSesion(estudianteRegistroDTO);
    }

    @Override
    public EstudianteDominio buscarPorUsuario(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException {
        return estudianteNegocio.buscarPorUsuario(estudianteRegistroDTO);
    }

}
