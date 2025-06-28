/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import DTO.FiltroDTO;
import DTO.NuevaComputadoraDTO;
import DTO.TablaComputadoraDTO;
import com.mycompany.persistencia.IComputadoraDAO;
import daos.IConexionBD;
import daos.implementaciones.ComputadoraDAO;
import daos.implementaciones.ConexionBD;
import dominios.ComputadoraDominio;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import fachada.IComputadoraFachada;
import java.util.List;
import negocio.IComputadoraNegocio;
import negocio.implementaciones.ComputadoraNegocio;

/**
 *
 * @author adell
 */
public class ComputadoraFachada implements IComputadoraFachada{
    
    private IComputadoraNegocio computadoraNegocio;
    
    public ComputadoraFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(conexionBD);
        this.computadoraNegocio = new ComputadoraNegocio(computadoraDAO);
    }
    
    @Override
    public ComputadoraDominio buscarPorId(int id) throws NegocioException {
        return computadoraNegocio.buscarPorId(id);
    }

    @Override
    public ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException {
        return computadoraNegocio.agregar(computadoraDTO);
    }

    @Override
    public void apartarComputadora(int id) throws NegocioException {
        computadoraNegocio.apartarComputadora(id);
    }

    @Override
    public ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException {
        return computadoraNegocio.modificar(computadora);
    }

    @Override
    public void eliminar(int id) throws NegocioException {
        computadoraNegocio.eliminar(id);
    }

    @Override
    public List<ComputadoraDominio> listarComputadoras() throws NegocioException {
        return computadoraNegocio.listarComputadoras();
    }

    @Override
    public void liberarComputadora(int id) throws NegocioException {
        computadoraNegocio.liberarComputadora(id);
    }

    @Override
    public List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return computadoraNegocio.buscarTabla(filtro);
    }

    @Override
    public LaboratorioDominio buscarLaboratorioPorIp(String ip) throws NegocioException {
        return computadoraNegocio.buscarLaboratorioPorIp(ip);
    }

    @Override
    public ComputadoraDominio buscarPorNumero(String numero) throws NegocioException {
        return computadoraNegocio.buscarPorNumero(numero);
    }
    
}
