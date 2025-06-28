/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

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
public interface IReporteFachada {

    /**
     * Genera un reporte detallado del centro de cómputo según los filtros
     * proporcionados.
     *
     * @param filtro DTO que contiene los criterios para filtrar los datos del
     * reporte.
     * @return Lista de ReporteCentroComputoDTO con la información filtrada.
     * @throws NegocioException Si ocurre algún error durante la generación del
     * reporte.
     */
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException;

    /**
     * Genera un reporte relacionado con las carreras según los filtros
     * especificados.
     *
     * @param filtro DTO que contiene los criterios para filtrar los datos del
     * reporte de carreras.
     * @return Lista de ReporteCarrerasDTO con la información filtrada.
     * @throws NegocioException Si ocurre algún error durante la generación del
     * reporte.
     */
    public List<ReporteCarrerasDTO> generarReporteCarreras(FiltroReporteCarrerasDTO filtro) throws NegocioException;

    /**
     * Genera un reporte de bloqueos aplicados según los filtros indicados.
     *
     * @param filtro DTO que contiene los criterios para filtrar los datos del
     * reporte de bloqueos.
     * @return Lista de ReporteBloqueoDTO con la información filtrada.
     * @throws NegocioException Si ocurre algún error durante la generación del
     * reporte.
     */
    public List<ReporteBloqueoDTO> generarReporteBloqueo(FiltroReporteBloqueoDTO filtro) throws NegocioException;

}
