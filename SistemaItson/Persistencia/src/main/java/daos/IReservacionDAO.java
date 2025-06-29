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

    /**
     * Registra una nueva reservación de computadora para un estudiante.
     *
     * @param reservacion Entidad con los datos de la reservación a guardar.
     * @return La entidad EstudianteReservaComputadoraDominio guardada.
     * @throws PersistenciaException si ocurre un error durante la operación.
     */
    EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws PersistenciaException;

    /**
     * Busca una reservación por su ID.
     *
     * @param id Identificador de la reservación.
     * @return La entidad EstudianteReservaComputadoraDominio encontrada.
     * @throws PersistenciaException si no se encuentra la reservación o ocurre
     * un error.
     */
    EstudianteReservaComputadoraDominio buscarPorId(int id) throws PersistenciaException;

}
