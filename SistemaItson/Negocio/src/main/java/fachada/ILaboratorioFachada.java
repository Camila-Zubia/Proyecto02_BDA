/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.FiltroDTO;
import DTO.LaboratorioDTO;
import DTO.NuevoLaboratorioDTO;
import DTO.TablaLaboratorioDTO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface ILaboratorioFachada {

    /**
     * Guarda un nuevo laboratorio en el sistema.
     *
     * @param nuevoLaboratorio DTO que contiene los datos necesarios para crear
     * un nuevo laboratorio.
     * @return La entidad LaboratorioDominio recién creada y persistida.
     * @throws NegocioException Si ocurre algún error durante la creación.
     */
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException;

    /**
     * Busca un laboratorio por su identificador único.
     *
     * @param id El identificador único del laboratorio.
     * @return El DTO LaboratorioDTO correspondiente al ID proporcionado.
     * @throws NegocioException Si el laboratorio no existe o ocurre un error
     * durante la búsqueda.
     */
    public LaboratorioDTO buscarPorId(int id) throws NegocioException;

    /**
     * Modifica los datos de un laboratorio existente.
     *
     * @param laboratorio DTO que contiene los datos actualizados del
     * laboratorio.
     * @return La entidad LaboratorioDominio actualizada y persistida.
     * @throws NegocioException Si ocurre algún error durante la modificación.
     */
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException;

    /**
     * Busca y devuelve una lista de laboratorios en formato tabla, filtrados
     * según los criterios proporcionados.
     *
     * @param filtro Objeto que contiene los criterios para filtrar los
     * laboratorios.
     * @return Lista de TablaLaboratorioDTO que cumplen con el filtro.
     * @throws NegocioException Si ocurre algún error durante la búsqueda.
     */
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    /**
     * Obtiene una lista con todos los laboratorios registrados en el sistema.
     *
     * @return Lista de entidades LaboratorioDominio disponibles.
     * @throws NegocioException Si ocurre algún error al recuperar la lista.
     */
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException;

    /**
     * Obtiene un laboratorio por su nombre.
     *
     * @param nombre El nombre del laboratorio.
     * @return La entidad LaboratorioDominio correspondiente al nombre
     * proporcionado.
     * @throws NegocioException Si el laboratorio no existe o ocurre un error
     * durante la búsqueda.
     */
    public LaboratorioDominio obtenerPorNombre(String nombre) throws NegocioException;

}
