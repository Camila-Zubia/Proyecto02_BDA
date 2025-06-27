/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import daos.IConexionBD;
import excepciones.PersistenciaException;
import dominios.BloqueoDominio;
import dominios.EstudianteDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import daos.IEstudianteDAO;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Camila Zubía
 */
public class EstudianteDAO implements IEstudianteDAO {

    private final IConexionBD conexionBD;

    public EstudianteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    @Override
    public EstudianteDominio buscarPorID(String id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
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
    public boolean estaBloqueado(String id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
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
        EntityManager em = conexionBD.crearConexion();

        try {
            String consulta = "SELECT DISTINCT e FROM estudianteDominio e JOIN e.bloqueos b WHERE b.estatus = true";
            TypedQuery<EstudianteDominio> query = em.createQuery(consulta, EstudianteDominio.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(EstudianteDominio.class);
            List<Predicate> predicate = new ArrayList<>();
            Root<EstudianteDominio> root = cq.from(EstudianteDominio.class);
            if (filtro.getFiltro() != null && !filtro.getFiltro().trim().isEmpty()) {

                String textoFiltro = "%" + filtro.getFiltro() + "%";

                Predicate nombre = cb.like(cb.function("CAST", String.class, root.get("nombres")), textoFiltro);
                Predicate apellidoP = cb.like(cb.function("CAST", String.class, root.get("apellidoPaterno")), textoFiltro);
                Predicate apellidoM = cb.like(cb.function("CAST", String.class, root.get("apellidoMaterno")), textoFiltro);

                predicate.add(cb.or(nombre, apellidoP, apellidoM));
            }
            Predicate inscrito = cb.isTrue(root.get("estatus"));
            predicate.add(inscrito);

            cq.select(root).where(cb.and(predicate.toArray(Predicate[]::new)));
            TypedQuery<EstudianteDominio> query = manager.createQuery(cq);
            query.setFirstResult(filtro.getOffset());
            query.setMaxResults(filtro.getLimit());
            List<EstudianteDominio> resultados = query.getResultList();
            List<TablaEstudiantesDTO> estudiantes = resultados.stream()
                    .map(e -> convertirTabla(e)).collect(Collectors.toList());
            return estudiantes;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al buscar la tabla de estudiantes" + ex);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    private TablaEstudiantesDTO convertirTabla(EstudianteDominio estudiante) {
        String id = estudiante.getIdEstudiante();
        String nombre = estudiante.getNombres();
        String apellidoP = estudiante.getApellidoPaterno();
        String apellidoM = estudiante.getApellidoMaterno();
        boolean estatus = estudiante.isEstatus();
        TablaEstudiantesDTO tabla = new TablaEstudiantesDTO(id, nombre, apellidoP, apellidoM, estatus);
        return tabla;
    }
}
