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
    public EstudianteDominio buscarPorID(String id) throws NegocioException {
         try {
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
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException {
        try {
            EstudianteDominio estudiante = estudianteDAO.buscarPorUsuario(estudianteRegistroDTO);
            if (estudiante == null) {
                return null;
            }
            encriptarContrasena(estudianteRegistroDTO);
            boolean contrasenaValida = BCrypt.checkpw(
                    estudianteRegistroDTO.getContrasenaHash(), estudiante.getContraseña());
            return contrasenaValida ? estudiante : null;
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
    
    private String encriptarContrasena(EstudianteRegistroDTO administradorRegistroDTO) throws NegocioException {
        try {
            String textoPlano = new String(administradorRegistroDTO.getContrasena());
            String hash = BCrypt.hashpw(textoPlano, BCrypt.gensalt());
            if (administradorRegistroDTO.getContrasena() != null) {
                Arrays.fill(administradorRegistroDTO.getContrasena(), '\0');
            }
            return hash;
        } catch (Exception ex) {
            throw new NegocioException("Error al guardar.");
        }
    }
    
}
