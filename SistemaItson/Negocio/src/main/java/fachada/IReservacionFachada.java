/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import dominios.EstudianteReservaComputadoraDominio;
import excepciones.NegocioException;

/**
 *
 * @author adell
 */
public interface IReservacionFachada {
    EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException;

    EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException;
}
