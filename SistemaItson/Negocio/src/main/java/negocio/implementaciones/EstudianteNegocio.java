/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import DTO.EstudianteRegistroDTO;
import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import daos.IEstudianteDAO;
import dominios.EstudianteDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IEstudianteNegocio;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author adell
 */
public class EstudianteNegocio implements IEstudianteNegocio {

    private IEstudianteDAO estudianteDAO;

    public EstudianteNegocio(IEstudianteDAO estudianteDAO) {
        this.estudianteDAO = estudianteDAO;
    }

    /**
     * Busca estudiantes según el filtro y devuelve una lista en formato tabla.
     *
     * @param filtro DTO con criterios para filtrar estudiantes.
     * @return Lista de estudiantes en formato TablaEstudiantesDTO, o null si
     * ocurre un error.
     * @throws NegocioException No se lanza directamente; se registra el error
     * internamente.
     */
    @Override
    public List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            return estudianteDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Busca un estudiante por su ID tras validar que el ID sea válido.
     *
     * @param id Identificador del estudiante.
     * @return EstudianteDominio encontrado, o null si no existe o hay error.
     * @throws NegocioException No se lanza directamente; se registra el error
     * internamente.
     */
    @Override
    public EstudianteDominio buscarPorID(int id) throws NegocioException {
        try {
            validarId(id);
            return estudianteDAO.buscarPorID(id);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Verifica si un estudiante está bloqueado.
     *
     * @param id Identificador o matrícula del estudiante.
     * @return true si está bloqueado, false si no o si ocurre un error.
     * @throws NegocioException No se lanza directamente; se registra el error
     * internamente.
     */
    @Override
    public boolean estaBloqueado(String id) throws NegocioException {
        try {
            return estudianteDAO.estaBloqueado(id);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    /**
     * Obtiene la lista de estudiantes que tienen bloqueos activos.
     *
     * @return Lista de estudiantes bloqueados o null si ocurre un error.
     * @throws NegocioException No se lanza directamente; se registra el error
     * internamente.
     */
    @Override
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException {
        try {
            return estudianteDAO.obtenerEstudiantesConBloqueosActivos();
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Inicia sesión de un estudiante validando las credenciales.
     *
     * - Si la contraseña almacenada no está hasheada con bcrypt, compara texto
     * plano y actualiza el hash. - Luego valida el usuario y la contraseña
     * usando bcrypt. - Limpia la contraseña en memoria tras la operación.
     *
     * @param dto DTO con usuario y contraseña para login.
     * @return El estudiante si las credenciales son correctas; null si no.
     * @throws NegocioException Si ocurre un error durante la autenticación.
     */
    @Override
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO dto) throws NegocioException {
        try {
            EstudianteDominio estudiante = estudianteDAO.buscarPorUsuario(dto);

            if (estudiante == null) {
                return null;
            }

            String contrasenaIngresada = new String(dto.getContrasena());
            String contraseñaBD = estudiante.getContraseña();

            if (!contraseñaBD.startsWith("$2a$")) {
                if (contrasenaIngresada.equals(contraseñaBD)) {
                    String hashNuevo = BCrypt.hashpw(contrasenaIngresada, BCrypt.gensalt());
                    estudiante.setContraseña(hashNuevo);
                    estudianteDAO.actualizarContraseña(estudiante);
                    return estudiante;
                } else {
                    return null;
                }
            }

            validarCredenciales(dto);

            if (BCrypt.checkpw(contrasenaIngresada, contraseñaBD)) {
                return estudiante;
            }
            return null;

        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al autenticar: " + ex.getMessage());
        } finally {
            Arrays.fill(dto.getContrasena(), '\0');
        }
    }

    /**
     * Valida que el ID del estudiante sea válido (mayor que cero).
     *
     * @param id ID a validar.
     * @throws NegocioException Si el ID es menor o igual a cero.
     */
    private void validarId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID de estudiante no es válido.");
        }
    }

    /**
     * Valida que el DTO de registro contenga usuario y contraseña.
     *
     * @param dto DTO con credenciales.
     * @throws NegocioException Si el DTO, usuario o contraseña son nulos.
     */
    private void validarCredenciales(EstudianteRegistroDTO dto) throws NegocioException {
        if (dto == null || dto.getUsuario() == null || dto.getContrasena() == null) {
            throw new NegocioException("Matrícula y contraseña son obligatorias.");
        }
    }


    @Override
    public EstudianteDominio buscarPorUsuario(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException {
        try {
            return estudianteDAO.buscarPorUsuario(estudianteRegistroDTO);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
            throw new NegocioException("Error al buscar por usuario: " + ex.getMessage());
        }
    }
    


}
