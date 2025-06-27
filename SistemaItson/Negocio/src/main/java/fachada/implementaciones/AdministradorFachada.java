package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.AdministradorRegistroDTO;
import daos.IAdministradorDAO;
import daos.implementaciones.AdministradorDAO;
import dominios.AdministradorDominio;
import excepciones.NegocioException;
import fachada.IAdministradorFachada;
import negocio.IAdministradorNegocio;
import negocio.implementaciones.AdministradorNegocio;


public class AdministradorFachada implements IAdministradorFachada{
    
    private IAdministradorNegocio administradorNegocio;
    
    public AdministradorFachada (){
        IAdministradorDAO administradorDAO = new AdministradorDAO();
        this.administradorNegocio = new AdministradorNegocio(administradorDAO);
    }

    @Override
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException {
        return administradorNegocio.iniciarSesion(administradorRegistroDTO);
    }
    
    
}
