/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.estudianteReservaComputadoraDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author Camila Zubía
 */
public interface IReservacion {
    
    estudianteReservaComputadoraDominio registrar(estudianteReservaComputadoraDominio reservacion) throws PersistenciaException;
    
    estudianteReservaComputadoraDominio buscarPorId(int id) throws PersistenciaException;
}
