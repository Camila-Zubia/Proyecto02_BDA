/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import com.mycompany.persistencia.IReservacionDAO;
import daos.IConexionBD;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.ReservacionDAO;
import dominios.EstudianteReservaComputadoraDominio;
import excepciones.NegocioException;
import fachada.IReservacionFachada;
import negocio.IResevarcionNegocio;
import negocio.implementaciones.ReservacionNegocio;

/**
 *
 * @author adell
 */
public class ReservacionFachada implements IReservacionFachada {

    private final IResevarcionNegocio reservacionNegocio;

    public ReservacionFachada (){
        IConexionBD conexionBD = new ConexionBD();
        IReservacionDAO reservacionDAO = new ReservacionDAO(conexionBD);
        this.reservacionNegocio = new ReservacionNegocio(reservacionDAO);
    }
    @Override
    public EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException {
        return reservacionNegocio.registrar(reservacion);
    }

    @Override
    public EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException {
        return reservacionNegocio.buscarPorId(id);
    }

}
