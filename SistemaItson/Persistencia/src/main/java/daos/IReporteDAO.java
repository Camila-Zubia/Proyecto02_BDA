/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.FiltrosReporteCentroComputoDTO;
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
}
