package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import daos.IUnidadAcademicaDAO;
import dominios.UnidadAcademicaDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import negocio.IUnidadAcademicaNegocio;


public class UnidadAcademicaNegocio implements IUnidadAcademicaNegocio{
    private final IUnidadAcademicaDAO unidadAcademicaDAO;
    
    public UnidadAcademicaNegocio(IUnidadAcademicaDAO unidadAcademicaDAO){
        this.unidadAcademicaDAO = unidadAcademicaDAO;
    }
    
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws NegocioException{
        try{
            return unidadAcademicaDAO.obtenerUnidadesAcademicas();
        }catch(PersistenciaException ex){
            throw new NegocioException(ex.getMessage());
        }
    }
}
