package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.NuevoLaboratorioDTO;
import daos.ILaboratorioDAO;
import daos.implementaciones.LaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import fachada.ILaboratorioFachada;
import negocio.ILaboratorioNegocio;
import negocio.implementaciones.LaboratorioNegocio;


public class LaboratorioFachada implements ILaboratorioFachada{
    
    private ILaboratorioNegocio laboratorioNegocio;
    
    public LaboratorioFachada(){
        ILaboratorioDAO laboratorioDAO = new LaboratorioDAO();
        this.laboratorioNegocio = new LaboratorioNegocio(laboratorioDAO);
    }

    @Override
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
