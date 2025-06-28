/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.FiltroReporteBloqueoDTO;
import DTO.FiltroReporteCarrerasDTO;
import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteBloqueoDTO;
import DTO.ReporteCarrerasDTO;
import DTO.ReporteCentroComputoDTO;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IReporteDAO {

    public List<ReporteCentroComputoDTO> generarReporteCentroComputo
        (FiltrosReporteCentroComputoDTO filtro) throws PersistenciaException;
        
    public List<ReporteCarrerasDTO> generarReporteCarreras
        (FiltroReporteCarrerasDTO filtro) throws PersistenciaException;
        
    public List<ReporteBloqueoDTO> generarReporteBloqueo
        (FiltroReporteBloqueoDTO filtro) throws PersistenciaException;
}
