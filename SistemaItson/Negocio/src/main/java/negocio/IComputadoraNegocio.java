/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.FiltroDTO;
import DTO.NuevaComputadoraDTO;
import DTO.TablaComputadoraDTO;
import dominios.ComputadoraDominio;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IComputadoraNegocio {
    ComputadoraDominio buscarPorId(int id) throws NegocioException;
    
    ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException;
    
    void apartarComputadora(int id) throws NegocioException;
    
    ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException;
    
    void eliminar(int id) throws NegocioException;
    
    List<ComputadoraDominio> listarComputadoras() throws NegocioException;
    
    void liberarComputadora(int id) throws NegocioException;
    
    List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;
    
    public LaboratorioDominio buscarLaboratorioPorIp(String ip) throws NegocioException;
    
    ComputadoraDominio buscarPorNumero(String numero) throws NegocioException;
}
