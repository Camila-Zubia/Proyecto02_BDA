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
public class ComputadoraNegocio implements IComputadoraNegocio {

    private IComputadoraDAO computadoraDAO;

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO) {
        this.computadoraDAO = computadoraDAO;
    }

    @Override
    public ComputadoraDominio buscarPorId(int id) throws NegocioException {
        try {
            validarId(id);
            return computadoraDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar la computadora por id");
        }
    }

    @Override
    public ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException {
        try {
            validarIp(computadoraDTO);
            validarIpComputadora(computadoraDTO);
            validarNumeroComputadora(computadoraDTO);
            validarNuevaComputadora(computadoraDTO);
            return computadoraDAO.agregar(computadoraDTO);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al registrar una computadora");
        }
    }

    @Override
    public void apartarComputadora(int id) throws NegocioException {
        try {
            validarId(id);
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
            validarFiltro(filtro);
            return computadoraDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar en la tabla de computadoras");
        }
    }

    /**
     *
     * VALIDACIONES
     */
    private void validarId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID debe ser mayor que cero.");
        }
    }

    private void validarFiltro(FiltroDTO filtro) throws NegocioException {
        if (filtro == null) {
            throw new NegocioException("El filtro no puede ser nulo.");
        }
    }

    private void validarIp(NuevaComputadoraDTO dto) throws NegocioException {
        if (dto.getDireccionIp() == null || dto.getDireccionIp().isBlank()) {
            throw new NegocioException("La dirección IP es obligatoria.");
        } else if (!dto.getDireccionIp().matches("^\\d{1,3}(\\.\\d{1,3}){3}$")) {
            throw new NegocioException("La dirección IP no tiene un formato válido.");
        }
    }

    private void validarNuevaComputadora(NuevaComputadoraDTO dto) throws NegocioException {
        if (dto == null) {
            throw new NegocioException("La computadora no puede ser nula.");
        }

        if (dto.getNumero() == null || dto.getNumero().isBlank()) {
            throw new NegocioException("El número de la computadora es obligatorio.");
        }

        if (dto.getTipo() == null) {
            throw new NegocioException("El tipo de computadora es obligatorio.");
        }

        if (dto.getLaboratorio() == null || dto.getLaboratorio().isBlank()) {
            throw new NegocioException("El nombre del laboratorio es obligatorio.");
        }
    }

    private void validarNumeroComputadora(NuevaComputadoraDTO computadoraDTO) throws NegocioException {

        if (computadoraDTO.getNumero().length() > 50) {
            throw new NegocioException("El numero de la computadora no puede ser mayor a 50 caracteres");

        }
    }

    private void validarIpComputadora(NuevaComputadoraDTO computadoraDTO) throws NegocioException {

        if (computadoraDTO.getDireccionIp().length() > 50) {
            throw new NegocioException("El numero de la computadora no puede ser mayor a 50 caracteres");

        }
    }

}
