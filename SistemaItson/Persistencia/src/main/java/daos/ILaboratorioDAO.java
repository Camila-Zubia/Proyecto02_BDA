/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import dominios.LaboratorioDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface ILaboratorioDAO {
    
    LaboratorioDominio buscarPorId(int id) throws PersistenciaException;

    LaboratorioDominio guardar(NuevoLaboratorioDTO laboratorio) throws PersistenciaException;
    
    LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException;
    
    boolean existePorNombre(String nombre) throws PersistenciaException;
    
    List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException;
}
