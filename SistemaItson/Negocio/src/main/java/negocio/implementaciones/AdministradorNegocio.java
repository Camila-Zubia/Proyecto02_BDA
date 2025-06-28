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

    /**
     * Inicia sesión de un administrador validando sus credenciales.
     *
     * Primero valida que los datos de login no sean nulos o vacíos, luego busca
     * al administrador por su usuario y verifica que la contraseña coincida
     * mediante bcrypt. Limpia la contraseña en memoria por seguridad.
     *
     * @param administradorRegistroDTO DTO con usuario y contraseña para login.
     * @return La entidad AdministradorDominio si las credenciales son
     * correctas; null si el usuario no existe o la contraseña es incorrecta.
     * @throws NegocioException Si ocurre un error durante la validación o
     * consulta.
     */
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

    /**
     * Encripta la contraseña proporcionada en el DTO usando bcrypt.
     *
     * Limpia la contraseña en memoria después de la encriptación para evitar
     * posibles fugas.
     *
     * @param administradorRegistroDTO DTO que contiene la contraseña en texto
     * plano.
     * @return La contraseña encriptada (hash).
     * @throws NegocioException Si ocurre un error durante la encriptación.
     */
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

    /**
     * Valida que las credenciales del administrador para el inicio de sesión no
     * sean nulas ni vacías.
     *
     * @param dto DTO con las credenciales a validar.
     * @throws NegocioException Si algún dato obligatorio es nulo o vacío.
     */
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
