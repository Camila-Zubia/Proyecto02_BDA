/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.FiltroDTO;
import DTO.TablaComputadoraDTO;
import dominios.ComputadoraDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IComputadoraFachada {
    ComputadoraDominio buscarPorId(int id) throws NegocioException;
    
    ComputadoraDominio agregar(ComputadoraDominio computadora) throws NegocioException;
    
    void apartarComputadora(int id) throws NegocioException;
    
    ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException;
    
    void eliminar(int id) throws NegocioException;
    
    List<ComputadoraDominio> listarComputadoras() throws NegocioException;
    
    void liberarComputadora(int id) throws NegocioException;
    
    List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;
}
