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

    @Override
    public EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException {
        try {
            return reservacionDAO.registrar(reservacion);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al registrar una reservacion");
        }
    }

    @Override
    public EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException {
        try {
            return reservacionDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar una reservacion por id");
        }
    }

}
