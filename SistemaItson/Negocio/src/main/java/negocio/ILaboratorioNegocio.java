/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface ILaboratorioNegocio {
    
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException;

    public LaboratorioDTO buscarPorId(int id) throws NegocioException;
    
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException;
    
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;
    
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException;
    
    public LaboratorioDominio obtenerPorNombre(String nombre) throws NegocioException;
}
