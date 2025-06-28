/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import com.mycompany.persistencia.IReservacionDAO;
import dominios.EstudianteReservaComputadoraDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IResevarcionNegocio;

/**
 *
 * @author adell
 */
public class ReservacionNegocio implements IResevarcionNegocio {

    private IReservacionDAO reservacionDAO;

    public ReservacionNegocio(IReservacionDAO reservacionDAO) {
        this.reservacionDAO = reservacionDAO;
    }

    /**
     * Registra una nueva reservación de computadora para un estudiante.
     *
     * @param reservacion Objeto dominio con los datos de la reservación.
     * @return El objeto dominio registrado.
     * @throws NegocioException Si ocurre un error en la persistencia al
     * registrar.
     */
    @Override
    public EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException {
        try {
            return reservacionDAO.registrar(reservacion);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al registrar una reservacion");
        }
    }

    /**
     * Busca una reservación de computadora por su ID.
     *
     * @param id Identificador único de la reservación.
     * @return El objeto dominio de la reservación encontrada.
     * @throws NegocioException Si ocurre un error en la persistencia al buscar.
     */
    @Override
    public EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException {
        try {
            return reservacionDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar una reservacion por id");
        }
    }

}
