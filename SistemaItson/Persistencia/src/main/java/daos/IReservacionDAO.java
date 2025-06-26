/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.EstudianteReservaComputadoraDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author Camila Zubía
 */
public interface IReservacionDAO {
    
    EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws PersistenciaException;
    
    EstudianteReservaComputadoraDominio buscarPorId(int id) throws PersistenciaException;
}
