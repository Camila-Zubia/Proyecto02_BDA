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

    public ReservacionFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IReservacionDAO reservacionDAO = new ReservacionDAO(conexionBD);
        this.reservacionNegocio = new ReservacionNegocio(reservacionDAO);
    }

    /**
     * Registra una nueva reservación de computadora realizada por un
     * estudiante.
     *
     * @param reservacion Entidad EstudianteReservaComputadoraDominio con los
     * datos de la reservación.
     * @return La entidad EstudianteReservaComputadoraDominio registrada.
     * @throws NegocioException Si ocurre un error durante el registro de la
     * reservación.
     */
    @Override
    public EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException {
        return reservacionNegocio.registrar(reservacion);
    }

    /**
     * Busca una reservación de computadora por su identificador único.
     *
     * @param id El identificador único de la reservación.
     * @return La entidad EstudianteReservaComputadoraDominio correspondiente al
     * ID proporcionado.
     * @throws NegocioException Si no se encuentra la reservación o si ocurre un
     * error durante la búsqueda.
     */
    @Override
    public EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException {
        return reservacionNegocio.buscarPorId(id);
    }

}
