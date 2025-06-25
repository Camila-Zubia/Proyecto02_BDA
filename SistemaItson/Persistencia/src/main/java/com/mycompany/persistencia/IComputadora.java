/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import DTO.FiltroDTO;
import dominios.computadoraDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IComputadora {
    
    computadoraDominio buscarPorId(int id) throws PersistenciaException;
    
    computadoraDominio agregar(computadoraDominio computadora) throws PersistenciaException;
    
    void apartarComputadora(int id) throws PersistenciaException;
    
    computadoraDominio modificar(computadoraDominio computadora) throws PersistenciaException;
    
    void eliminar(int id) throws PersistenciaException;
    
    List<computadoraDominio> listarComputadoras() throws PersistenciaException;
    
}
