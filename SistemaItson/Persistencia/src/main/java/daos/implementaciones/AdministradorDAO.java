package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import dominios.AdministradorDominio;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;


public class AdministradorDAO implements IAdministradorDAO{

    @Override
    public AdministradorDominio buscarPorUsuario(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException {
        EntityManager manager = ManejadorConexiones.getEntityManager();
        AdministradorDominio admin = null;
        try{
            admin = manager.find(AdministradorDominio.class, administradorRegistroDTO.getUsuario());
        }catch(Exception ex){
            
        }finally{
            manager.close();
        }
        return admin;
    }

}
