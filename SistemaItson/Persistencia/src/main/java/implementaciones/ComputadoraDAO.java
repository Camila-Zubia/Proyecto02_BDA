/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implementaciones;

import excepciones.PersistenciaException;
import com.mycompany.persistencia.IComputadora;
import dominios.EstatusComputadora;
import dominios.computadoraDominio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Camila Zubía
 */
public class ComputadoraDAO implements IComputadora{

    @Override
    public computadoraDominio buscarPorId(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
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
        EntityManager manager = ManejadorConexiones.getEntityManager();
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
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            computadoraDominio computadora = manager.find(computadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            computadora.setEstatus(EstatusComputadora.APARTADA);
            manager.getTransaction().commit();
        } catch (PersistenciaException ex) {
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

    @Override
    public computadoraDominio modificar(computadoraDominio computadora) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            computadoraDominio computadoraEncontrada = manager.find(computadoraDominio.class, computadora.getIdComputadoras());
            if (computadoraEncontrada == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + computadora.getIdComputadoras());
            }
            computadoraEncontrada.setNumero(computadora.getNumero());
            computadoraEncontrada.setDireccionIp(computadora.getDireccionIp());
            manager.getTransaction().commit();
            return computadoraEncontrada;
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al modificar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public void eliminar(int id) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        try {
            manager.getTransaction().begin();
            computadoraDominio computadora = manager.find(computadoraDominio.class, id);
            if (computadora == null) {
                throw new PersistenciaException("No se encontró la computadora con ID: " + id);
            }
            computadora.setEstatus(EstatusComputadora.DESCONECTADA);
            manager.getTransaction().commit();
        } catch (PersistenciaException ex) {
            if (manager != null && manager.getTransaction().isActive()) {
                manager.getTransaction().rollback();
            }
            throw new PersistenciaException("Error al eliminar la computadora: " + ex.getMessage());
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }
    
}
