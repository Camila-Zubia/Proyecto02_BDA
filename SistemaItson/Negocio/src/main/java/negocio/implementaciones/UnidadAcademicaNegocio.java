package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import daos.IUnidadAcademicaDAO;
import dominios.UnidadAcademicaDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import negocio.IUnidadAcademicaNegocio;

public class UnidadAcademicaNegocio implements IUnidadAcademicaNegocio {

    private final IUnidadAcademicaDAO unidadAcademicaDAO;

    public UnidadAcademicaNegocio(IUnidadAcademicaDAO unidadAcademicaDAO) {
        this.unidadAcademicaDAO = unidadAcademicaDAO;
    }

    /**
     * Obtiene la lista de todas las unidades académicas registradas.
     *
     * @return Lista de objetos dominio de unidades académicas.
     * @throws NegocioException Si ocurre un error al acceder a la persistencia.
     */
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws NegocioException {
        try {
            return unidadAcademicaDAO.obtenerUnidadesAcademicas();
        } catch (PersistenciaException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }

}
