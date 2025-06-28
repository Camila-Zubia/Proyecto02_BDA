package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import dominios.AdministradorDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.Arrays;
import negocio.IAdministradorNegocio;
import org.mindrot.jbcrypt.BCrypt;

public class AdministradorNegocio implements IAdministradorNegocio {

    private IAdministradorDAO administradorDAO;

    public AdministradorNegocio(IAdministradorDAO administradorDAO) {
        this.administradorDAO = administradorDAO;
    }

    @Override
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException {
        validarCredencialesLogin(administradorRegistroDTO); // Validación básica

        try {
            AdministradorDominio admin = administradorDAO.buscarPorUsuario(administradorRegistroDTO);
            if (admin == null) {
                return null;
            }
            String contrasenaPlano = new String(administradorRegistroDTO.getContrasena());
            boolean contrasenaValida = BCrypt.checkpw(contrasenaPlano, admin.getContraseña());
            Arrays.fill(administradorRegistroDTO.getContrasena(), '\0'); 
            return contrasenaValida ? admin : null;
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

    private String encriptarContrasena(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException {
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

    private void validarCredencialesLogin(AdministradorRegistroDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("No se recibieron datos del administrador.");
        }
        if (dto.getUsuario() == null || dto.getUsuario().isBlank()) {
            throw new NegocioException("El nombre de usuario es obligatorio.");
        }
        if (dto.getContrasena() == null || dto.getContrasena().length == 0) {
            throw new NegocioException("La contraseña es obligatoria.");
        }
    }

}
