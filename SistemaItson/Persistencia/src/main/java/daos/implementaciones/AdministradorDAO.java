package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import daos.IConexionBD;
import dominios.AdministradorDominio;
import excepciones.PersistenciaException;
import javax.persistence.EntityManager;


public class AdministradorDAO implements IAdministradorDAO{

    private final IConexionBD conexionBD;
    
    public AdministradorDAO (IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    @Override
    public AdministradorDominio buscarPorUsuario(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException {
        EntityManager manager = conexionBD.crearConexion();
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
