package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import daos.IConexionBD;
import dominios.AdministradorDominio;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;

public class AdministradorDAO implements IAdministradorDAO {

    private final IConexionBD conexionBD;

    public AdministradorDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    /**
     * Método que busca un administrador por su nombre de usuario.
     *
     * @param administradorRegistroDTO Objeto que contiene el usuario a buscar.
     * @return El administrador encontrado, o null si no existe.
     * @throws PersistenciaException En caso de error durante la búsqueda.
     */
    @Override
    public AdministradorDominio buscarPorUsuario(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        AdministradorDominio admin = null;
        try {
            admin = manager.find(AdministradorDominio.class, administradorRegistroDTO.getUsuario());
        } catch (Exception ex) {
            // Manejo de error
        } finally {
            manager.close();
        }
        return admin;
    }

}
