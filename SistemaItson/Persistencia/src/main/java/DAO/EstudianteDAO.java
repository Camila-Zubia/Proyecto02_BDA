/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dominios.bloqueoDominio;
import dominios.estudianteDominio;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author Camila Zubía
 */
public class EstudianteDAO implements IEstudiante{
    
    private EntityManagerFactory factory;

    public EstudianteDAO() {
        this.factory = Persistence.createEntityManagerFactory("factory");
    }

    @Override
    public estudianteDominio buscarPorID(int id) throws PersistenciaException {
        EntityManager manager = factory.createEntityManager();
        try {
            estudianteDominio estudiante = manager.find(estudianteDominio.class, id);
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
        EntityManager manager = factory.createEntityManager();
        String consulta = "SELECT b FROM bloqueoDominio b WHERE b.idEstudiante = :id AND b.estatus = true";
        TypedQuery<bloqueoDominio> query = manager.createQuery(consulta, bloqueoDominio.class);
        query.setParameter("idEstudiante", id);
        List<bloqueoDominio> resultados = query.getResultList();
        return !resultados.isEmpty();
    }
    
}
