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
public class ComputadoraFachada implements IComputadoraFachada {

    private IComputadoraNegocio computadoraNegocio;

    public ComputadoraFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(conexionBD);
        this.computadoraNegocio = new ComputadoraNegocio(computadoraDAO);
    }

    /**
     * Busca una computadora por su identificador único.
     *
     * @param id El identificador único de la computadora a buscar.
     * @return La entidad ComputadoraDominio correspondiente al ID
     * proporcionado.
     * @throws NegocioException Si ocurre algún error durante la búsqueda o la
     * computadora no existe.
     */
    @Override
    public ComputadoraDominio buscarPorId(int id) throws NegocioException {
        return computadoraNegocio.buscarPorId(id);
    }

    /**
     * Agrega una nueva computadora al sistema.
     *
     * @param computadoraDTO DTO que contiene los datos necesarios para crear
     * una nueva computadora.
     * @return La entidad ComputadoraDominio recién creada y persistida.
     * @throws NegocioException Si ocurre algún error durante la creación.
     */
    @Override
    public ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException {
        return computadoraNegocio.agregar(computadoraDTO);
    }

    /**
     * Marca una computadora como apartada, reservando su uso.
     *
     * @param id El identificador único de la computadora que se desea apartar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * apartada.
     */
    @Override
    public void apartarComputadora(int id) throws NegocioException {
        computadoraNegocio.apartarComputadora(id);
    }

    /**
     * Modifica los datos de una computadora existente.
     *
     * @param computadora La entidad ComputadoraDominio con los datos
     * actualizados.
     * @return La entidad ComputadoraDominio actualizada y persistida.
     * @throws NegocioException Si ocurre algún error durante la modificación.
     */
    @Override
    public ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException {
        return computadoraNegocio.modificar(computadora);
    }

    /**
     * Elimina una computadora del sistema.
     *
     * @param id El identificador único de la computadora a eliminar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * eliminada.
     */
    @Override
    public void eliminar(int id) throws NegocioException {
        computadoraNegocio.eliminar(id);
    }

    /**
     * Obtiene una lista con todas las computadoras registradas en el sistema.
     *
     * @return Lista de entidades ComputadoraDominio disponibles.
     * @throws NegocioException Si ocurre algún error al recuperar la lista.
     */
    @Override
    public List<ComputadoraDominio> listarComputadoras() throws NegocioException {
        return computadoraNegocio.listarComputadoras();
    }

    /**
     * Libera una computadora que se encontraba apartada o en uso, dejándola
     * disponible.
     *
     * @param id El identificador único de la computadora a liberar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * liberada.
     */
    @Override
    public void liberarComputadora(int id) throws NegocioException {
        computadoraNegocio.liberarComputadora(id);
    }

    /**
     * Busca y devuelve una lista de computadoras en formato tabla, filtradas
     * según los criterios proporcionados.
     *
     * @param filtro Objeto que contiene los criterios para filtrar las
     * computadoras.
     * @return Lista de TablaComputadoraDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
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
