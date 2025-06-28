/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

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
public interface ILaboratorioNegocio {

    /**
     * Guarda un nuevo laboratorio en el sistema a partir de los datos
     * proporcionados.
     *
     * @param nuevoLaboratorio DTO que contiene los datos necesarios para
     * registrar un nuevo laboratorio.
     * @return La entidad LaboratorioDominio registrada.
     * @throws NegocioException Si ocurre un error durante el proceso de
     * guardado.
     */
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException;

    /**
     * Busca un laboratorio por su identificador único.
     *
     * @param id Identificador del laboratorio a buscar.
     * @return El DTO LaboratorioDTO correspondiente al laboratorio encontrado.
     * @throws NegocioException Si el laboratorio no existe o si ocurre un error
     * durante la búsqueda.
     */
    public LaboratorioDTO buscarPorId(int id) throws NegocioException;

    /**
     * Modifica los datos de un laboratorio existente.
     *
     * @param laboratorio DTO con los datos actualizados del laboratorio.
     * @return La entidad LaboratorioDominio modificada.
     * @throws NegocioException Si ocurre un error durante la modificación o si
     * el laboratorio no existe.
     */
    public LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws NegocioException;

    /**
     * Busca laboratorios utilizando criterios especificados en un filtro y
     * devuelve los resultados en formato tabla.
     *
     * @param filtro Objeto DTO con los criterios de filtrado.
     * @return Lista de TablaLaboratorioDTO que cumplen con los filtros
     * aplicados.
     * @throws NegocioException Si ocurre un error durante la búsqueda.
     */
    public List<TablaLaboratorioDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    /**
     * Obtiene todos los laboratorios registrados en el sistema.
     *
     * @return Lista de entidades LaboratorioDominio disponibles.
     * @throws NegocioException Si ocurre un error al recuperar los
     * laboratorios.
     */
    public List<LaboratorioDominio> obtenerLaboratorios() throws NegocioException;

    /**
     * Obtiene un laboratorio por su nombre.
     *
     * @param nombre Nombre del laboratorio a buscar.
     * @return La entidad LaboratorioDominio correspondiente al nombre
     * proporcionado.
     * @throws NegocioException Si el laboratorio no existe o si ocurre un error
     * durante la búsqueda.
     */
    public LaboratorioDominio obtenerPorNombre(String nombre) throws NegocioException;

}
