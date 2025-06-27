package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import negocio.IAdministradorNegocio;


public class AdministradorNegocio implements IAdministradorNegocio {
    
    private IAdministradorDAO administradorDAO;
    
    public AdministradorNegocio (IAdministradorDAO administradorDAO){
        this.administradorDAO = administradorDAO;
    }

    @Override
    public boolean iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException {
        try{
            return administradorDAO.iniciarSesion(administradorRegistroDTO);
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }
}
