/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dominios.UnidadAcademicaDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author saula
 */
public interface IUnidadAcademicaNegocio {
    
    public List<UnidadAcademicaDominio> obtenerUnidadesAcademicas() throws NegocioException;
}
