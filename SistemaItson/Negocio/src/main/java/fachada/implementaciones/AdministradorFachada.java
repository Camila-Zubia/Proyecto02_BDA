package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import daos.IConexionBD;
import daos.implementaciones.AdministradorDAO;
import daos.implementaciones.ConexionBD;
import dominios.AdministradorDominio;
import excepciones.NegocioException;
import fachada.IAdministradorFachada;
import negocio.IAdministradorNegocio;
import negocio.implementaciones.AdministradorNegocio;


public class AdministradorFachada implements IAdministradorFachada{
    
    private final IAdministradorNegocio administradorNegocio;
    
    public AdministradorFachada (){
        IConexionBD conexionBD = new ConexionBD();
        IAdministradorDAO administradorDAO = new AdministradorDAO(conexionBD);
        this.administradorNegocio = new AdministradorNegocio(administradorDAO);
    }

    @Override
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException {
        return administradorNegocio.iniciarSesion(administradorRegistroDTO);
    }
    
    
}
