/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import DTO.FiltroDTO;
import DTO.NuevaComputadoraDTO;
import DTO.TablaComputadoraDTO;
import com.mycompany.persistencia.IComputadoraDAO;
import dominios.ComputadoraDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio.IComputadoraNegocio;

/**
 *
 * @author adell
 */
public class ComputadoraNegocio implements IComputadoraNegocio{
    
    private IComputadoraDAO computadoraDAO;

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO) {
        this.computadoraDAO = computadoraDAO;
    }
    
    
    @Override
    public ComputadoraDominio buscarPorId(int id) throws NegocioException {
        try {
            return computadoraDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar la computadora por id");
        }
    }

    @Override
    public ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException {
        try {
            return computadoraDAO.agregar(computadoraDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al registrar una computadora");
        }
    }

    @Override
    public void apartarComputadora(int id) throws NegocioException {
        try {
            computadoraDAO.apartarComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al apartar una computadora por id");
        }
    }

    @Override
    public ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException {
        try {
            return computadoraDAO.modificar(computadora);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al modificar una computadora");
        }
    }

    @Override
    public void eliminar(int id) throws NegocioException {
        try {
            computadoraDAO.eliminar(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al eliminar una computadora por id");
        }
    }

    @Override
    public List<ComputadoraDominio> listarComputadoras() throws NegocioException {
        try {
            return computadoraDAO.listarComputadoras();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al obtener la lista de computadoras");
        }
    }

    @Override
    public void liberarComputadora(int id) throws NegocioException {
        try {
            computadoraDAO.liberarComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al liberar una computadora por id");
        }
    }

    @Override
    public List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            return computadoraDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar en la tabla de computadoras");
        }
    }
    
}
