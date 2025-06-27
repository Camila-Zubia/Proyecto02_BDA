/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import dominios.EstudianteReservaComputadoraDominio;
import excepciones.NegocioException;
import fachada.IReservacionFachada;
import negocio.IResevarcionNegocio;

/**
 *
 * @author adell
 */
public class ReservacionFachada implements IReservacionFachada {

    private IResevarcionNegocio reservacionNegocio;

    @Override
    public EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException {
        return reservacionNegocio.registrar(reservacion);
    }

    @Override
    public EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException {
        return reservacionNegocio.buscarPorId(id);
    }

}
