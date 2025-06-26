package negocio.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.NuevoLaboratorioDTO;
import daos.ILaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import negocio.ILaboratorioNegocio;


public class LaboratorioNegocio implements ILaboratorioNegocio{

    private ILaboratorioDAO laboratorioDAO;

    public LaboratorioNegocio(ILaboratorioDAO laboratorioDAO) {
        this.laboratorioDAO = laboratorioDAO;
    }
    
    
    
    @Override
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
