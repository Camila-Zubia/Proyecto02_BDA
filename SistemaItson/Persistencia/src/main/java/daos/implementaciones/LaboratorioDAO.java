/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos.implementaciones;

import daos.ILaboratorioDAO;
import excepciones.PersistenciaException;
import DTO.LaboratorioDTO;
import dominios.LaboratorioDominio;
import javax.persistence.EntityManager;

/**
 *
 * @author Camila Zubía
 */
public class LaboratorioDAO implements ILaboratorioDAO{

    @Override
    public LaboratorioDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
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
    public LaboratorioDominio agregar(LaboratorioDominio laboratorio) throws PersistenciaException {
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
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
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
}
