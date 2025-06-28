/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.FiltrosReporteCentroComputoDTO;
import DTO.ReporteCentroComputoDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IReporteFachada {
        
    public List<ReporteCentroComputoDTO> generarReporte(FiltrosReporteCentroComputoDTO filtro) throws NegocioException;

}
