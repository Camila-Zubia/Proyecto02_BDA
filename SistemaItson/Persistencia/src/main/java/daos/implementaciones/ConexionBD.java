package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.IConexionBD;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConexionBD implements IConexionBD{

    private final String NOMBRE_PERSISTENCE_UNIT = "conexionJPA";

    @Override
    public EntityManager crearConexion() {
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory(NOMBRE_PERSISTENCE_UNIT);
        EntityManager entityManager = emFactory.createEntityManager();
        return entityManager;
    }
    
}
