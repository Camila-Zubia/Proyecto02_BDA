/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import dominios.UnidadAcademicaDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author saula
 */
public interface IUnidadAcademicaDAO {
    public UnidadAcademicaDominio obtenerPorNombre(String nombre) throws PersistenciaException;
}
