package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import dominios.AdministradorDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.Arrays;
import negocio.IAdministradorNegocio;
import org.mindrot.jbcrypt.BCrypt;


public class AdministradorNegocio implements IAdministradorNegocio {
    
    private IAdministradorDAO administradorDAO;
    
    public AdministradorNegocio (IAdministradorDAO administradorDAO){
        this.administradorDAO = administradorDAO;
    }

    @Override
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException {
        try{
            AdministradorDominio admin =  administradorDAO.buscarPorUsuario(administradorRegistroDTO);
            if (admin == null)
                return null;
            encriptarContrasena(administradorRegistroDTO);
            boolean contrasenaValida = BCrypt.checkpw(
                    administradorRegistroDTO.getContrasenaHash(), admin.getContraseña());
            return contrasenaValida ? admin : null;
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }
    
        private String encriptarContrasena(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException{
        try{
            String textoPlano = new String(administradorRegistroDTO.getContrasena());
            String hash = BCrypt.hashpw(textoPlano, BCrypt.gensalt());
            if (administradorRegistroDTO.getContrasena() != null) 
                Arrays.fill(administradorRegistroDTO.getContrasena(), '\0');
            return hash;
        } catch (Exception ex){
            throw new NegocioException("Error al guardar.");
        }
    }
}
