package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import daos.IConexionBD;
import daos.IUnidadAcademicaDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.UnidadAcademicaDAO;
import dominios.UnidadAcademicaDominio;
import excepciones.NegocioException;
import fachada.IUnidadAcademicaFachada;
import java.util.List;
import negocio.IUnidadAcademicaNegocio;
import negocio.implementaciones.UnidadAcademicaNegocio;

public class UnidadAcademicaFachada implements IUnidadAcademicaFachada {

    private final IUnidadAcademicaNegocio unidadAcademicaNegocio;

    public UnidadAcademicaFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IUnidadAcademicaDAO reservacionDAO = new UnidadAcademicaDAO(conexionBD);
        this.unidadAcademicaNegocio = new UnidadAcademicaNegocio(reservacionDAO);
    }

    /**
     * Obtiene una lista de todas las unidades académicas registradas en el
     * sistema.
     *
     * @return Lista de entidades UnidadAcademicaDominio disponibles.
     * @throws NegocioException Si ocurre algún error al recuperar la
     * información.
     */
    @Override
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws NegocioException {
        return unidadAcademicaNegocio.obtenerUnidadesAcademicas();
    }

}
