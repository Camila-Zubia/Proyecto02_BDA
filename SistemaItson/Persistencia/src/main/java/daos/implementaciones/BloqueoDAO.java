/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import excepciones.PersistenciaException;
import dominios.BloqueoDominio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import daos.IBloqueoDAO;

/**
 *
 * @author Camila Zubía
 */
public class BloqueoDAO implements IBloqueoDAO {

    @Override
    public BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(bloqueo);
            manager.getTransaction().commit();
            return bloqueo;
        } catch (Exception ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al registrar el bloqueo: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public BloqueoDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            BloqueoDominio bloqueo = manager.find(BloqueoDominio.class, id);
            if (bloqueo == null) {
                throw new PersistenciaException("No se encontró el bloqueo con ID: " + id);
            }
            return bloqueo;
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("Error al buscar el bloqueo por ID" + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public void liberarBloqueo(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            BloqueoDominio bloqueo = manager.find(BloqueoDominio.class, id);
            if (bloqueo == null) {
                throw new PersistenciaException("No se encontró el bloqueo con ID: " + id);
            }
            bloqueo.setEstatus(false);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al liberar el bloqueo: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public List<BloqueoDominio> obtenerBloqueosActivos() throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();

        try {
            String consulta = "SELECT b FROM bloqueoDominio b WHERE b.estatus = true";

            TypedQuery<BloqueoDominio> query = manager.createQuery(consulta, BloqueoDominio.class);
            return query.getResultList();

        } catch (Exception e) {
            throw new PersistenciaException("Error al consultar bloqueos activos" + e.getMessage());
        } finally {
            manager.close();
        }
    }

}
