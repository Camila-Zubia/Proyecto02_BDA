package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.NuevoLaboratorioDTO;
import daos.IConexionBD;
import daos.ILaboratorioDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.LaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import fachada.ILaboratorioFachada;
import negocio.ILaboratorioNegocio;
import negocio.implementaciones.LaboratorioNegocio;


public class LaboratorioFachada implements ILaboratorioFachada{
    
    private final ILaboratorioNegocio laboratorioNegocio;
    
    public LaboratorioFachada(){
        IConexionBD conexionBD = new ConexionBD();
        ILaboratorioDAO laboratorioDAO = new LaboratorioDAO(conexionBD);
        this.laboratorioNegocio = new LaboratorioNegocio(laboratorioDAO);
    }

    @Override
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        return laboratorioNegocio.guardar(nuevoLaboratorio);
    }
}
