/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.FiltroDTO;
import DTO.NuevaComputadoraDTO;
import DTO.TablaComputadoraDTO;
import dominios.ComputadoraDominio;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IComputadoraFachada {

    /**
     * Busca una computadora por su identificador.
     *
     * @param id El identificador único de la computadora a buscar.
     * @return La entidad ComputadoraDominio correspondiente al ID
     * proporcionado.
     * @throws NegocioException Si ocurre algún error durante la búsqueda o la
     * computadora no existe.
     */
    public ComputadoraDominio buscarPorId(int id) throws NegocioException;

    /**
     * Agrega una nueva computadora al sistema.
     *
     * @param computadoraDTO Objeto que contiene los datos necesarios para crear
     * una nueva computadora.
     * @return La entidad ComputadoraDominio recién creada y persistida.
     * @throws NegocioException Si ocurre algún error durante la creación.
     */
    public ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException;

    /**
     * Marca una computadora como apartada, reservando su uso.
     *
     * @param id El identificador único de la computadora que se desea apartar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * apartada.
     */
    public void apartarComputadora(int id) throws NegocioException;

    /**
     * Modifica los datos de una computadora existente.
     *
     * @param computadora La entidad ComputadoraDominio con los datos
     * actualizados.
     * @return La entidad ComputadoraDominio actualizada y persistida.
     * @throws NegocioException Si ocurre algún error durante la modificación.
     */
    public ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException;

    /**
     * Elimina una computadora del sistema.
     *
     * @param id El identificador único de la computadora a eliminar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * eliminada.
     */
    public void eliminar(int id) throws NegocioException;

    /**
     * Obtiene una lista con todas las computadoras registradas en el sistema.
     *
     * @return Lista de entidades ComputadoraDominio disponibles.
     * @throws NegocioException Si ocurre algún error al recuperar la lista.
     */
    public List<ComputadoraDominio> listarComputadoras() throws NegocioException;

    /**
     * Libera una computadora que se encontraba apartada o en uso, dejándola
     * disponible.
     *
     * @param id El identificador único de la computadora a liberar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * liberada.
     */
    public void liberarComputadora(int id) throws NegocioException;

    /**
     * Busca y devuelve una lista de computadoras en formato tabla, filtradas
     * según los criterios proporcionados.
     *
     * @param filtro Objeto que contiene los criterios para filtrar las
     * computadoras.
     * @return Lista de TablaComputadoraDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
    List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    
    public LaboratorioDominio buscarLaboratorioPorIp(String ip) throws NegocioException;
    
    ComputadoraDominio buscarPorNumero(String numero) throws NegocioException;



}
