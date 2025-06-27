/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import DTO.FiltroDTO;
import daos.ILaboratorioDAO;
import excepciones.PersistenciaException;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import daos.IConexionBD;
import daos.IUnidadAcademicaDAO;
import dominios.LaboratorioDominio;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Camila Zubía
 */
public class LaboratorioDAO implements ILaboratorioDAO{

    private final IUnidadAcademicaDAO unidadAcademicaDAO;
    private final IConexionBD conexionBD;
    
    public LaboratorioDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
        this.unidadAcademicaDAO = new UnidadAcademicaDAO(this.conexionBD);
    }
    
    @Override
    public LaboratorioDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            LaboratorioDominio laboratorio = manager.find(LaboratorioDominio.class, id);
            if (laboratorio == null) {
                throw new PersistenciaException("No se encontró el laboratorio con ID: " + id);
            }
            return laboratorio;
        } catch (PersistenciaException ex) {
            throw new PersistenciaException("Error al buscar el laboratorio por ID" + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            LaboratorioDominio laboratorio = new LaboratorioDominio();
            laboratorio.setNombre(nuevoLaboratorio.getNombre());
            laboratorio.setHoraInicio(nuevoLaboratorio.getHoraInicio());
            laboratorio.setHoraFin(nuevoLaboratorio.getHoraCierre());
            laboratorio.setContraseña(nuevoLaboratorio.getContrasenaHash());
            laboratorio.setUnidadAcademica(
                    unidadAcademicaDAO.obtenerPorNombre(nuevoLaboratorio.getUnidad()));
            manager.persist(laboratorio);
            manager.getTransaction().commit();
            return laboratorio;
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar el laboratorio: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            manager.getTransaction().begin();
            LaboratorioDominio labEncontrado = manager.find(LaboratorioDominio.class, laboratorio.getIdLaboratorios());
            if (labEncontrado == null) {
                throw new PersistenciaException("No se encontró el laboratorio con ID: " + laboratorio.getIdLaboratorios());
            }
            labEncontrado.setNombre(laboratorio.getNombre());
            labEncontrado.setHoraInicio(laboratorio.getHoraInicio());
            labEncontrado.setHoraInicio(laboratorio.getHoraFin());
            manager.getTransaction().commit();
            return labEncontrado;
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar el laboratorio: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
    @Override
    public boolean existePorNombre(String nombre) throws PersistenciaException{
        EntityManager manager = conexionBD.crearConexion();
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<LaboratorioDominio> root = query.from(LaboratorioDominio.class);
        
        Predicate condicion = cb.equal(
                cb.lower(root.get("nombre")), 
                nombre.toLowerCase());
        query.select(cb.count(root)).where(condicion);
        
        Long resultado = manager.createQuery(query).getSingleResult();
        return resultado > 0;
    }

    @Override
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
        try {
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery cq = cb.createQuery(LaboratorioDominio.class);
            List<Predicate> predicate = new ArrayList<>();
            Root<LaboratorioDominio> root = cq.from(LaboratorioDominio.class);
            if (filtro.getFiltro() != null && !filtro.getFiltro().trim().isEmpty()) {

                String textoFiltro = "%" + filtro.getFiltro() + "%";

                Predicate nombre = cb.like(cb.function("CAST", String.class, root.get("nombre")), textoFiltro);
                Predicate horaInicio = cb.like(cb.function("CAST", String.class, root.get("horaInicio")), textoFiltro);
                Predicate horaFin = cb.like(cb.function("CAST", String.class, root.get("horaFin")), textoFiltro);

                predicate.add(cb.or(nombre, horaInicio, horaFin));
            }

            cq.select(root).where(cb.and(predicate.toArray(Predicate[]::new)));
            TypedQuery<LaboratorioDominio> query = manager.createQuery(cq);
            query.setFirstResult(filtro.getOffset());
            query.setMaxResults(filtro.getLimit());
            List<LaboratorioDominio> resultados = query.getResultList();
            List<TablaLaboratorioDTO> laboratorios = resultados.stream()
                    .map(e -> convertirTabla(e)).collect(Collectors.toList());
            return laboratorios;
        } catch (Exception ex) {
            throw new PersistenciaException("Error al buscar la tabla de estudiantes" + ex);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    private TablaLaboratorioDTO convertirTabla(LaboratorioDominio lab) {
        int id = lab.getIdLaboratorios();
        String nombre = lab.getNombre();
        LocalTime horaInicio = lab.getHoraInicio();
        LocalTime horaFin = lab.getHoraFin();
        TablaLaboratorioDTO tabla = new TablaLaboratorioDTO(id, nombre, horaInicio, horaFin);
        return tabla;
    }
}
