/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

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
public interface IComputadoraNegocio {

    /**
     * Busca una computadora por su identificador único.
     *
     * @param id El identificador único de la computadora a buscar.
     * @return La entidad ComputadoraDominio correspondiente al ID
     * proporcionado.
     * @throws NegocioException Si ocurre un error durante la búsqueda o si la
     * computadora no existe.
     */
    ComputadoraDominio buscarPorId(int id) throws NegocioException;

    /**
     * Agrega una nueva computadora al sistema.
     *
     * @param computadoraDTO Objeto DTO que contiene los datos necesarios para
     * registrar una nueva computadora.
     * @return La entidad ComputadoraDominio que ha sido registrada.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * registro.
     */
    ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws NegocioException;

    /**
     * Aparta (reserva) una computadora específica para uso exclusivo.
     *
     * @param id El identificador único de la computadora a apartar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * apartada.
     */
    void apartarComputadora(int id) throws NegocioException;

    /**
     * Modifica la información de una computadora existente.
     *
     * @param computadora Objeto ComputadoraDominio con los nuevos datos a
     * aplicar.
     * @return La entidad ComputadoraDominio actualizada.
     * @throws NegocioException Si ocurre un error durante la modificación.
     */
    ComputadoraDominio modificar(ComputadoraDominio computadora) throws NegocioException;

    /**
     * Elimina una computadora del sistema por su identificador.
     *
     * @param id El identificador único de la computadora a eliminar.
     * @throws NegocioException Si la computadora no existe o no puede ser
     * eliminada.
     */
    void eliminar(int id) throws NegocioException;

    /**
     * Obtiene una lista de todas las computadoras registradas en el sistema.
     *
     * @return Lista de entidades ComputadoraDominio disponibles.
     * @throws NegocioException Si ocurre un error al obtener la información.
     */
    List<ComputadoraDominio> listarComputadoras() throws NegocioException;

    /**
     * Libera una computadora que ha sido apartada o se encuentra en uso.
     *
     * @param id El identificador único de la computadora a liberar.
     * @throws NegocioException Si la computadora no puede ser liberada o no
     * existe.
     */
    void liberarComputadora(int id) throws NegocioException;

    /**
     * Busca computadoras aplicando los filtros especificados y devuelve la
     * información en formato tabla.
     *
     * @param filtro DTO con los criterios de búsqueda para filtrar las
     * computadoras.
     * @return Lista de TablaComputadoraDTO que cumplen con los filtros
     * aplicados.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    
    public LaboratorioDominio buscarLaboratorioPorIp(String ip) throws NegocioException;
    
    ComputadoraDominio buscarPorNumero(String numero) throws NegocioException;

}
