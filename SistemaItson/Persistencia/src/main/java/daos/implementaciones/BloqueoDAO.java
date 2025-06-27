/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import excepciones.PersistenciaException;
import dominios.BloqueoDominio;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import daos.IBloqueoDAO;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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

    @Override
    public List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(BloqueoDominio.class);
            List<Predicate> predicate = new ArrayList<>();
            Root<BloqueoDominio> root = cq.from(BloqueoDominio.class);
            if (filtro.getFiltro() != null && !filtro.getFiltro().trim().isEmpty()) {

                String textoFiltro = "%" + filtro.getFiltro() + "%";

                Predicate fecha = cb.like(cb.function("CAST", String.class, root.get("FechaBloqueo")), textoFiltro);
                Predicate motivo = cb.like(cb.function("CAST", String.class, root.get("motivo")), textoFiltro);

                predicate.add(cb.or(fecha, motivo));
            }
            Predicate bloqueosActivos = cb.isTrue(root.get("estatus"));
            predicate.add(bloqueosActivos);

            cq.select(root).where(cb.and(predicate.toArray(Predicate[]::new)));
            TypedQuery<BloqueoDominio> query = manager.createQuery(cq);
            query.setFirstResult(filtro.getOffset());
            query.setMaxResults(filtro.getLimit());
            List<BloqueoDominio> resultados = query.getResultList();
            List<TablaBloqueosDTO> bloqueos = resultados.stream()
                    .map(b -> convertirTabla(b)).collect(Collectors.toList());
            return bloqueos;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al buscar la tabla de bloqueos" + ex);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    private TablaBloqueosDTO convertirTabla(BloqueoDominio bloqueo) {
        int id = bloqueo.getIdBloqueo();
        Calendar fecha = bloqueo.getFechaBloqueo();
        String motivo = bloqueo.getMotivo();
        boolean estatus = bloqueo.isEstatus();
        TablaBloqueosDTO tabla = new TablaBloqueosDTO(id, fecha, motivo, estatus);
        return tabla;
    }
}
