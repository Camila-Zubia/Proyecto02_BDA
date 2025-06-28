package presentacion.reportes;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.FiltroReporteBloqueoDTO;
import DTO.FiltroReporteCarrerasDTO;
import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteBloqueoDTO;
import DTO.ReporteCarrerasDTO;
import DTO.ReporteCentroComputoDTO;
import excepciones.NegocioException;
import fachada.IReporteFachada;
import fachada.implementaciones.ReporteFachada;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class Reporte {

    private final String RUTA_CENTRO = "src/main/resources/reporteCentrosComputo.jrxml";
    private final String RUTA_CARRERAS = "src/main/resources/reporteCarreras.jrxml";
    private final String RUTA_BLOQUEO = "src/main/resources/reporteBloqueos.jrxml";

    public void generarReporteCentroComputo(FiltrosReporteCentroComputoDTO filtro) throws NegocioException {
        try {
            IReporteFachada reporteFachada = new ReporteFachada();
            List<ReporteCentroComputoDTO> reporte = reporteFachada.generarReporte(filtro);
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reporte);
            
            //mapeo de parametros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("fechaInicio", filtro.getFechaInicio());
            parametros.put("fechaFin", filtro.getFechaFin());
            parametros.put("laboratorio", filtro.getLaboratorio());
            parametros.put("carreras", filtro.getCarreras());
            
            
            InputStream jasperStream = new FileInputStream(RUTA_CENTRO);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            jasperStream.close();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

            JasperViewer.viewReport(jasperPrint, false);
            
        }catch(NegocioException | IOException | JRException ex){
            throw new NegocioException(ex.getMessage());
        }
    }
    
    public void generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws NegocioException {
        try {
            IReporteFachada reporteFachada = new ReporteFachada();
            List<ReporteCarrerasDTO> reporte = reporteFachada.generarReporteCarreras(filtro);
            
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reporte);
            
            //mapeo de parametros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("fechaInicio", filtro.getFechaInicio());
            parametros.put("fechaFin", filtro.getFechaFin());
            parametros.put("carreras", filtro.getCarreras());
            
            
            InputStream jasperStream = new FileInputStream(RUTA_CARRERAS);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            jasperStream.close();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

            JasperViewer.viewReport(jasperPrint, false);
            
        }catch(NegocioException | IOException | JRException ex){
            throw new NegocioException(ex.getMessage());
        }
    }
    
    public void generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws NegocioException {
        try {
            IReporteFachada reporteFachada = new ReporteFachada();
            List<ReporteBloqueoDTO> reporte = reporteFachada.generarReporteBloqueo(filtro);

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reporte);

            //mapeo de parametros
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("fechaInicio", filtro.getFechaInicio());
            parametros.put("fechaFin", filtro.getFechaFin());

            InputStream jasperStream = new FileInputStream(RUTA_BLOQUEO);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
            jasperStream.close();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

            JasperViewer.viewReport(jasperPrint, false);

        } catch (NegocioException | IOException | JRException ex) {
            throw new NegocioException(ex.getMessage());
        }
    }
}
