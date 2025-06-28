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

    @Override
    public List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            return estudianteDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

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

    @Override
    public boolean estaBloqueado(String id) throws NegocioException {
        try {
            return estudianteDAO.estaBloqueado(id);
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException {
        try {
            return estudianteDAO.obtenerEstudiantesConBloqueosActivos();
        } catch (PersistenciaException ex) {
            Logger.getLogger(EstudianteNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

     @Override
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO dto) throws NegocioException {
        try {
            EstudianteDominio estudiante = estudianteDAO.buscarPorUsuario(dto);

            if (estudiante == null) return null;
            System.out.println(estudiante.getIdEstudiante());
            
            String contrasenaIngresada = new String(dto.getContrasena());
            System.out.println(contrasenaIngresada);
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
     * VALIDACIONES
     *
     */
    private void validarId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID de estudiante no es válido.");
        }
    }

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
