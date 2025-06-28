package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteCentroComputoDTO;
import daos.IReporteDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import negocio.IReporteNegocio;


public class ReporteNegocio implements IReporteNegocio {
    
    private final IReporteDAO reporteDAO;
    
    public ReporteNegocio(IReporteDAO reporte){
        this.reporteDAO = reporte;
    }
    
    @Override
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException {
        try {
            return reporteDAO.generarReporteCentroComputo(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error al generar el reporte", ex);
        }
    }
}
