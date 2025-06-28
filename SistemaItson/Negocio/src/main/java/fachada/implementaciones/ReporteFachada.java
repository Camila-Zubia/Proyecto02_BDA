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
    
    public ReporteFachada(){
        IConexionBD conexionBD = new ConexionBD();
        IReporteDAO laboratorioDAO = new ReporteDAO(conexionBD);
        this.reporteNegocio = new ReporteNegocio(laboratorioDAO);
    }

    @Override
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException {
        return reporteNegocio.generarReporte(filtro);
    }

    @Override
    public List<ReporteCarrerasDTO> generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws NegocioException {
        return reporteNegocio.generarReporteCarreras(filtro);
    }

    @Override
    public List<ReporteBloqueoDTO> generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws NegocioException {
        return reporteNegocio.generarReporteBloqueo(filtro);
    }
    
    
}
