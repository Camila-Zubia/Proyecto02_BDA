package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020
import DTO.FiltroReporteBloqueoDTO;
import DTO.FiltroReporteCarrerasDTO;
import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteBloqueoDTO;
import DTO.ReporteCarrerasDTO;
import DTO.ReporteCentroComputoDTO;
import daos.IReporteDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import negocio.IReporteNegocio;

public class ReporteNegocio implements IReporteNegocio {

    private final IReporteDAO reporteDAO;

    public ReporteNegocio(IReporteDAO reporte) {
        this.reporteDAO = reporte;
    }

    /**
     * Genera un reporte de centro de cómputo basado en los filtros
     * proporcionados.
     *
     * @param filtro DTO con los criterios para filtrar el reporte.
     * @return Lista de DTOs con los datos del reporte de centro de cómputo.
     * @throws NegocioException Si ocurre un error al generar el reporte.
     */
    @Override
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException {
        try {
            return reporteDAO.generarReporteCentroComputo(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar el reporte", ex);
        }
    }

    /**
     * Genera un reporte de carreras basado en los filtros proporcionados.
     *
     * @param filtro DTO con los criterios para filtrar el reporte de carreras.
     * @return Lista de DTOs con los datos del reporte de carreras.
     * @throws NegocioException Si ocurre un error al generar el reporte.
     */
    @Override
    public List<ReporteCarrerasDTO> generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws NegocioException {
        try {
            return reporteDAO.generarReporteCarreras(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar el reporte", ex);
        }
    }

    /**
     * Genera un reporte de bloqueos basado en los filtros proporcionados.
     *
     * @param filtro DTO con los criterios para filtrar el reporte de bloqueos.
     * @return Lista de DTOs con los datos del reporte de bloqueos.
     * @throws NegocioException Si ocurre un error al generar el reporte.
     */
    @Override
    public List<ReporteBloqueoDTO> generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws NegocioException {
        try {
            return reporteDAO.generarReporteBloqueo(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar el reporte", ex);
        }
    }

}
