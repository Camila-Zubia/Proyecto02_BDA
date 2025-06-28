package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.IConexionBD;
import daos.IUnidadAcademicaDAO;
import dominios.UnidadAcademicaDominio;
import excepciones.PersistenciaException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


public class UnidadAcademicaDAO implements IUnidadAcademicaDAO{

    private final IConexionBD conexionBD;

    public UnidadAcademicaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    
    @Override
    public UnidadAcademicaDominio obtenerPorNombre(String nombre) throws PersistenciaException{
        EntityManager manager = conexionBD.crearConexion();
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery<UnidadAcademicaDominio> query = cb.createQuery(UnidadAcademicaDominio.class);
            Root<UnidadAcademicaDominio> root = query.from(UnidadAcademicaDominio.class);
            query.select(root).where(cb.equal(
                    cb.lower(root.get("nombre")), 
                    nombre.toLowerCase()));
            return manager.createQuery(query).getSingleResult();
        }catch(NoResultException ex){
            throw new PersistenciaException("Ocurrió un error al obtener la unidad académica.");
        }finally{
            manager.close();
        }
    }
    
    @Override
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws PersistenciaException{
        EntityManager manager = conexionBD.crearConexion();
        try{
            CriteriaBuilder cb = manager.getCriteriaBuilder();
            CriteriaQuery<UnidadAcademicaDominio> query = cb.createQuery(UnidadAcademicaDominio.class);
            Root<UnidadAcademicaDominio> root = query.from(UnidadAcademicaDominio.class);
            query.select(root);
            return manager.createQuery(query).getResultList();
        }catch(NoResultException ex){
            throw new PersistenciaException("Ocurrió un error al obtener la unidad académica.");
        }finally{
            manager.close();
        }
    }
}
