/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.PersistenciaException;
import com.mycompany.persistencia.ILaboratorio;
import DTO.LaboratorioDTO;
import dominios.laboratorioDominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camila Zubía
 */
public class LaboratorioDAO implements ILaboratorio{

    @Override
    public laboratorioDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            laboratorioDominio laboratorio = manager.find(laboratorioDominio.class, id);
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
    public laboratorioDominio agregar(laboratorioDominio laboratorio) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(laboratorio);
            manager.getTransaction().commit();
            return laboratorio;
        } catch (Exception ex) {
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
    public laboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            laboratorioDominio labEncontrado = manager.find(laboratorioDominio.class, laboratorio.getIdLaboratorios());
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
}
