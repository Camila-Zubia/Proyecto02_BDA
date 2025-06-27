package daos.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import excepciones.PersistenciaException;


public class AdministradorDAO implements IAdministradorDAO{

    @Override
    public boolean iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException {
        return false;
    }

}
