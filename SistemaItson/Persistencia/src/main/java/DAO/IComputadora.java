/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import dominios.computadoraDominio;

/**
 *
 * @author Camila Zubía
 */
public interface IComputadora {
    
    computadoraDominio buscarPorId(int id) throws PersistenciaException;
    
    computadoraDominio agregar(computadoraDominio computadora) throws PersistenciaException;
    
    void apartarComputadora(int id) throws PersistenciaException;
    
}
