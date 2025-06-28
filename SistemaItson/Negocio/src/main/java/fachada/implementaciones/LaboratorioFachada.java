package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import daos.IConexionBD;
import daos.ILaboratorioDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.LaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import fachada.ILaboratorioFachada;
import java.util.List;
import negocio.ILaboratorioNegocio;
import negocio.implementaciones.LaboratorioNegocio;

public class LaboratorioFachada implements ILaboratorioFachada {

    private final ILaboratorioNegocio laboratorioNegocio;

    public LaboratorioFachada() {
        IConexionBD conexionBD = new ConexionBD();
        ILaboratorioDAO laboratorioDAO = new LaboratorioDAO(conexionBD);
        this.laboratorioNegocio = new LaboratorioNegocio(laboratorioDAO);
    }

    /**
     * Guarda un nuevo laboratorio en el sistema.
     *
     * @param nuevoLaboratorio DTO que contiene los datos necesarios para
     * registrar el laboratorio.
     * @return La entidad LaboratorioDominio recién registrada.
     * @throws NegocioException Si ocurre algún error durante el proceso de
     * guardado.
     */
    @Override
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        return laboratorioNegocio.guardar(nuevoLaboratorio);
    }

    /**
     * Busca un laboratorio por su identificador único.
     *
     * @param id Identificador del laboratorio.
     * @return El DTO LaboratorioDTO correspondiente al ID proporcionado.
     * @throws NegocioException Si el laboratorio no existe o hay un error al
     * buscarlo.
     */
    @Override
    public LaboratorioDTO buscarPorId(int id) throws NegocioException {
        return laboratorioNegocio.buscarPorId(id);
    }

    /**
     * Modifica los datos de un laboratorio existente.
     *
     * @param laboratorio DTO con los nuevos datos del laboratorio.
     * @return La entidad LaboratorioDominio con los datos actualizados.
     * @throws NegocioException Si ocurre un error durante la modificación.
     */
    @Override
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException {
        return laboratorioNegocio.modificar(laboratorio);
    }

    /**
     * Busca laboratorios según los criterios del filtro y devuelve la
     * información en formato tabla.
     *
     * @param filtro Objeto con los parámetros para aplicar los filtros.
     * @return Lista de TablaLaboratorioDTO que cumplen con los criterios.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
    @Override
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return laboratorioNegocio.buscarTabla(filtro);
    }

    /**
     * Obtiene todos los laboratorios registrados en el sistema.
     *
     * @return Lista de entidades LaboratorioDominio.
     * @throws NegocioException Si ocurre un error al recuperar la información.
     */
    @Override
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException {
        return laboratorioNegocio.obtenerLaboratorios();
    }

    /**
     * Busca un laboratorio por su nombre.
     *
     * @param nombre El nombre del laboratorio a buscar.
     * @return La entidad LaboratorioDominio correspondiente al nombre
     * proporcionado.
     * @throws NegocioException Si el laboratorio no se encuentra o hay un error
     * al buscarlo.
     */
    @Override
    public LaboratorioDominio obtenerPorNombre(String nombre) throws NegocioException {
        return laboratorioNegocio.obtenerPorNombre(nombre);
    }

}
