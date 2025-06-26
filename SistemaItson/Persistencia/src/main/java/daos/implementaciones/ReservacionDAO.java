/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import dominios.EstudianteReservaComputadoraDominio;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;
import com.mycompany.persistencia.IReservacionDAO;

/**
 *
 * @author Camila Zubía
 */
public class ReservacionDAO implements IReservacionDAO{

    @Override
    public EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(reservacion);
            ComputadoraDAO compuDAO = new ComputadoraDAO();
            compuDAO.apartarComputadora(reservacion.getComputadoraReservas().getIdComputadoras());
            manager.getTransaction().commit();
            return reservacion;
        } catch (Exception ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar la reservacion: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public EstudianteReservaComputadoraDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            EstudianteReservaComputadoraDominio reservacion = manager.find(EstudianteReservaComputadoraDominio.class, id);
            if (reservacion == null) {
                throw new PersistenciaException("No se encontró la reservacion con ID: " + id);
            }
            return reservacion;
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("Error al buscar la reservacion por ID" + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
}
