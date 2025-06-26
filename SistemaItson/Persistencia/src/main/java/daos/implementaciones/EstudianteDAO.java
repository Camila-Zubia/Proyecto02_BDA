/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import excepciones.PersistenciaException;
import dominios.BloqueoDominio;
import dominios.EstudianteDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import daos.IEstudianteDAO;

/**
 *
 * @author Camila Zubía
 */
public class EstudianteDAO implements IEstudianteDAO {

    @Override
    public EstudianteDominio buscarPorID(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            EstudianteDominio estudiante = manager.find(EstudianteDominio.class, id);
            if (estudiante == null) {
                throw new PersistenciaException("No se encontró el estudiante con ID: " + id);
            }
            return estudiante;
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("Error al buscar el estudiante por ID" + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public boolean estaBloqueado(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            String consulta = "SELECT b FROM bloqueoDominio b WHERE b.estudiante.id = :idEstudiante AND b.estatus = true";
            TypedQuery<BloqueoDominio> query = manager.createQuery(consulta, BloqueoDominio.class);
            query.setParameter("idEstudiante", id);
            List<BloqueoDominio> resultados = query.getResultList();
            return !resultados.isEmpty();
        } catch (Exception ex) {
            throw new PersistenciaException("Error al verificar si el estudiante esta bloqueado" + ex);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() {
        EntityManager em = ManejadorConexiones.getEntityManager();

        try {
            String consulta = "SELECT DISTINCT e FROM estudianteDominio e JOIN e.bloqueos b WHERE b.estatus = true";
            TypedQuery<EstudianteDominio> query = em.createQuery(consulta, EstudianteDominio.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

}
