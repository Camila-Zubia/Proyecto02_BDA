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
    public UnidadAcademicaDominio obtenerPorNombre(String nombre) throws PersistenciaException;
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws PersistenciaException;
}
