package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ManejadorConexiones {
    
    public static EntityManager getEntityManager (){
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("conexionJPA");
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
}
