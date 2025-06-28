package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.FiltroReporteBloqueoDTO;
import DTO.FiltroReporteCarrerasDTO;
import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteBloqueoDTO;
import DTO.ReporteCarrerasDTO;
import DTO.ReporteCentroComputoDTO;
import daos.IConexionBD;
import daos.IReporteDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.ReporteDAO;
import excepciones.NegocioException;
import fachada.IReporteFachada;
import java.util.List;
import negocio.IReporteNegocio;
import negocio.implementaciones.ReporteNegocio;

public class ReporteFachada implements IReporteFachada {

    private final IReporteNegocio reporteNegocio;

    public ReporteFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IReporteDAO laboratorioDAO = new ReporteDAO(conexionBD);
        this.reporteNegocio = new ReporteNegocio(laboratorioDAO);
    }

    /**
     * Genera un reporte del centro de cómputo según los filtros proporcionados.
     *
     * @param filtro DTO con los criterios de búsqueda para el reporte.
     * @return Lista de ReporteCentroComputoDTO con los resultados del reporte.
     * @throws NegocioException Si ocurre un error durante la generación del
     * reporte.
     */
    @Override
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException {
        return reporteNegocio.generarReporte(filtro);
    }

    /**
     * Genera un reporte relacionado con las carreras utilizando los filtros
     * proporcionados.
     *
     * @param filtro DTO con los parámetros para filtrar la información del
     * reporte.
     * @return Lista de ReporteCarrerasDTO con los datos generados.
     * @throws NegocioException Si ocurre un error durante la generación del
     * reporte.
     */
    @Override
    public List<ReporteCarrerasDTO> generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws NegocioException {
        return reporteNegocio.generarReporteCarreras(filtro);
    }

    /**
     * Genera un reporte sobre los bloqueos aplicados a estudiantes, basado en
     * los filtros indicados.
     *
     * @param filtro DTO con los parámetros para aplicar los filtros en el
     * reporte de bloqueos.
     * @return Lista de ReporteBloqueoDTO con la información generada.
     * @throws NegocioException Si ocurre un error durante la generación del
     * reporte.
     */
    @Override
    public List<ReporteBloqueoDTO> generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws NegocioException {
        return reporteNegocio.generarReporteBloqueo(filtro);
    }

}
