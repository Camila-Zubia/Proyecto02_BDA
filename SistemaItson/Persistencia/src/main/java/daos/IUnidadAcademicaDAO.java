/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dominios.UnidadAcademicaDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IUnidadAcademicaDAO {

    /**
     * Obtiene una unidad académica por su nombre.
     *
     * @param nombre El nombre de la unidad académica a buscar.
     * @return La entidad UnidadAcademicaDominio que coincide con el nombre.
     * @throws PersistenciaException Si no se encuentra la unidad o ocurre un
     * error en la consulta.
     */
    public UnidadAcademicaDominio obtenerPorNombre(String nombre) throws PersistenciaException;

    /**
     * Obtiene la lista completa de unidades académicas.
     *
     * @return Lista de todas las entidades UnidadAcademicaDominio existentes.
     * @throws PersistenciaException Si ocurre un error al obtener las unidades
     * académicas.
     */
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws PersistenciaException;

}
