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
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
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

    /**
     * Busca una computadora por su identificador único.
     *
     * @param id Identificador de la computadora a buscar.
     * @return La entidad ComputadoraDominio correspondiente al ID.
     * @throws NegocioException Si el ID es inválido o si ocurre un error
     * durante la búsqueda.
     */
    @Override
    public ComputadoraDominio buscarPorId(int id) throws NegocioException {
        try {
            validarId(id);
            return computadoraDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar la computadora por id");
        }
    }

    /**
     * Registra una nueva computadora después de validar sus datos.
     *
     * @param computadoraDTO DTO con los datos para crear la computadora.
     * @return La entidad ComputadoraDominio creada.
     * @throws NegocioException Si los datos no son válidos o hay un error en el
     * registro.
     */
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

    /**
     * Aparta (reserva) una computadora por su ID.
     *
     * @param id Identificador de la computadora a apartar.
     * @throws NegocioException Si el ID es inválido o hay error en la
     * operación.
     */
    @Override
    public void apartarComputadora(int id) throws NegocioException {
        try {
            validarId(id);
            computadoraDAO.apartarComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al apartar una computadora por id");
        }
    }

    /**
     * Modifica la información de una computadora.
     *
     * @param computadora Entidad con los datos actualizados.
     * @return La entidad ComputadoraDominio modificada.
     * @throws NegocioException Si ocurre un error durante la modificación.
     */
    @Override
    public ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException {
        try {
            return computadoraDAO.modificar(computadora);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al modificar una computadora");
        }
    }

    /**
     * Elimina una computadora por su ID.
     *
     * @param id Identificador de la computadora a eliminar.
     * @throws NegocioException Si ocurre un error durante la eliminación.
     */
    @Override
    public void eliminar(int id) throws NegocioException {
        try {
            computadoraDAO.eliminar(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al eliminar una computadora por id");
        }
    }

    /**
     * Lista todas las computadoras registradas.
     *
     * @return Lista de entidades ComputadoraDominio.
     * @throws NegocioException Si ocurre un error al obtener la lista.
     */
    @Override
    public List<ComputadoraDominio> listarComputadoras() throws NegocioException {
        try {
            return computadoraDAO.listarComputadoras();
        } catch (PersistenciaException ex) {
            ex.printStackTrace(); 
            throw new NegocioException("Ha ocurrido un error al obtener la lista de computadoras");
        }
    }

    /**
     * Libera una computadora apartada por su ID.
     *
     * @param id Identificador de la computadora a liberar.
     * @throws NegocioException Si ocurre un error al liberar la computadora.
     */
    @Override
    public void liberarComputadora(int id) throws NegocioException {
        try {
            computadoraDAO.liberarComputadora(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al liberar una computadora por id");
        }
    }

    /**
     * Busca computadoras según filtro y devuelve datos en formato tabla.
     *
     * @param filtro DTO con criterios para filtrar.
     * @return Lista de TablaComputadoraDTO que cumplen el filtro.
     * @throws NegocioException Si el filtro es nulo o ocurre un error durante
     * la búsqueda.
     */
    @Override
    public List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        try {
            validarFiltro(filtro);
            return computadoraDAO.buscarTabla(filtro);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al buscar en la tabla de computadoras");
        }
    }

    /* ====================
   VALIDACIONES PRIVADAS
   ==================== */
    /**
     * Valida que el ID sea mayor que cero.
     *
     * @param id ID a validar.
     * @throws NegocioException Si el ID es menor o igual a cero.
     */
    private void validarId(int id) throws NegocioException {
        if (id <= 0) {
            throw new NegocioException("El ID debe ser mayor que cero.");
        }
    }

    /**
     * Valida que el filtro no sea nulo.
     *
     * @param filtro Filtro a validar.
     * @throws NegocioException Si el filtro es nulo.
     */
    private void validarFiltro(FiltroDTO filtro) throws NegocioException {
        if (filtro == null) {
            throw new NegocioException("El filtro no puede ser nulo.");
        }
    }

    /**
     * Valida que la dirección IP esté presente y tenga formato válido.
     *
     * @param dto DTO con la dirección IP a validar.
     * @throws NegocioException Si la IP es nula, vacía o formato inválido.
     */
    private void validarIp(NuevaComputadoraDTO dto) throws NegocioException {
        if (dto.getDireccionIp() == null || dto.getDireccionIp().isBlank()) {
            throw new NegocioException("La dirección IP es obligatoria.");
        } else if (!dto.getDireccionIp().matches("^\\d{1,3}(\\.\\d{1,3}){3}$")) {
            throw new NegocioException("La dirección IP no tiene un formato válido.");
        }
    }

    /**
     * Valida los datos básicos de una nueva computadora.
     *
     * @param dto DTO con los datos a validar.
     * @throws NegocioException Si algún dato obligatorio es nulo o inválido.
     */
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

    /**
     * Valida que el número de computadora no supere los 50 caracteres.
     *
     * @param computadoraDTO DTO con el número a validar.
     * @throws NegocioException Si el número es mayor a 50 caracteres.
     */
    private void validarNumeroComputadora(NuevaComputadoraDTO computadoraDTO) throws NegocioException {
        if (computadoraDTO.getNumero().length() > 50) {
            throw new NegocioException("El número de la computadora no puede ser mayor a 50 caracteres");
        }
    }

    /**
     * Valida que la dirección IP no supere los 50 caracteres.
     *
     * @param computadoraDTO DTO con la IP a validar.
     * @throws NegocioException Si la IP es mayor a 50 caracteres.
     */
    private void validarIpComputadora(NuevaComputadoraDTO computadoraDTO) throws NegocioException {
        if (computadoraDTO.getDireccionIp().length() > 50) {
            throw new NegocioException("La dirección IP no puede ser mayor a 50 caracteres");
        }
    }

    @Override
    public LaboratorioDominio buscarLaboratorioPorIp(String ip) throws NegocioException {
        try {
            return computadoraDAO.buscarLaboratorioPorIp(ip);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error buscar de que laboratorio es una computadora");
        }
    }

    @Override
    public ComputadoraDominio buscarPorNumero(String numero) throws NegocioException {
        try {
            return computadoraDAO.buscarPorNumero(numero);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error buscar la computadora por numero");
        }
    }

}
