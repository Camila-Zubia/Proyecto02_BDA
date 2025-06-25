/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dominios.computadoraDominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camila Zubía
 */
public class ComputadoraDAO implements IComputadora{
    
    private EntityManagerFactory factory;

    public ComputadoraDAO() {
        this.factory = Persistence.createEntityManagerFactory("factory");
    }

    @Override
    public computadoraDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = factory.createEntityManager();
        try{
            computadoraDominio computadora = manager.find(computadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            return computadora;
        }catch (PersistenciaException ex) {
            throw new PersistenciaException("Error al buscar la computadora por ID" + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public computadoraDominio agregar(computadoraDominio computadora) throws PersistenciaException {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            manager.persist(computadora);
            manager.getTransaction().commit();
            return computadora;
        } catch (Exception ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al guardar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public void apartarComputadora(int id) throws PersistenciaException {
        EntityManager manager = factory.createEntityManager();
        try {
            manager.getTransaction().begin();
            computadoraDominio computadora = manager.find(computadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            computadora.setEstatus(false);
            manager.getTransaction().commit();
        } catch (Exception ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al apartar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
}
