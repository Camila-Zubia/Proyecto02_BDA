/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import dominios.UnidadAcademicaDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IUnidadAcademicaFachada {

    /**
     * Obtiene una lista con todas las unidades académicas registradas en el
     * sistema.
     *
     * @return Lista de entidades UnidadAcademicaDominio disponibles.
     * @throws NegocioException Si ocurre algún error al recuperar la lista.
     */
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws NegocioException;

}
