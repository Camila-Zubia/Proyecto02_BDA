package fachada.implementaciones;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import daos.IConexionBD;
import daos.ILaboratorioDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.LaboratorioDAO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import fachada.ILaboratorioFachada;
import java.util.List;
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

    @Override
    public LaboratorioDTO buscarPorId(int id) throws NegocioException {
        return laboratorioNegocio.buscarPorId(id);
    }

    @Override
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException {
        return laboratorioNegocio.modificar(laboratorio);
    }

    @Override
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return laboratorioNegocio.buscarTabla(filtro);
    }

    @Override
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException {
        return laboratorioNegocio.obtenerLaboratorios();
    }

    @Override
    public LaboratorioDominio obtenerPorNombre(String nombre) throws NegocioException {
        return laboratorioNegocio.obtenerPorNombre(nombre);
    }
}
