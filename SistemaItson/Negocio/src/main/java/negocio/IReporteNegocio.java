/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.FiltroReporteBloqueoDTO;
import DTO.FiltroReporteCarrerasDTO;
import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteBloqueoDTO;
import DTO.ReporteCarrerasDTO;
import DTO.ReporteCentroComputoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IReporteNegocio {

    /**
     * Genera un reporte del centro de cómputo basado en los filtros
     * proporcionados.
     *
     * @param filtro DTO con los criterios para filtrar la información del
     * reporte.
     * @return Lista de ReporteCentroComputoDTO con los datos resultantes del
     * reporte.
     * @throws NegocioException Si ocurre algún error durante la generación del
     * reporte.
     */
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException;

    /**
     * Genera un reporte relacionado con las carreras según los filtros
     * especificados.
     *
     * @param filtro DTO con los criterios para filtrar la información del
     * reporte de carreras.
     * @return Lista de ReporteCarrerasDTO con los datos resultantes del
     * reporte.
     * @throws NegocioException Si ocurre algún error durante la generación del
     * reporte.
     */
    public List<ReporteCarrerasDTO> generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws NegocioException;

    /**
     * Genera un reporte de bloqueos aplicados según los filtros indicados.
     *
     * @param filtro DTO con los criterios para filtrar la información del
     * reporte de bloqueos.
     * @return Lista de ReporteBloqueoDTO con los datos resultantes del reporte.
     * @throws NegocioException Si ocurre algún error durante la generación del
     * reporte.
     */
    public List<ReporteBloqueoDTO> generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws NegocioException;

}
