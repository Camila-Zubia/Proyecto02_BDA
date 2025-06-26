/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.ComputadoraDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IComputadora {
    
    ComputadoraDominio buscarPorId(int id) throws PersistenciaException;
    
    ComputadoraDominio agregar(ComputadoraDominio computadora) throws PersistenciaException;
    
    void apartarComputadora(int id) throws PersistenciaException;
    
    ComputadoraDominio modificar(ComputadoraDominio computadora) throws PersistenciaException;
    
    void eliminar(int id) throws PersistenciaException;
    
    List<ComputadoraDominio> listarComputadoras() throws PersistenciaException;
    
    void liberarComputadora(int id) throws PersistenciaException;
    
}
