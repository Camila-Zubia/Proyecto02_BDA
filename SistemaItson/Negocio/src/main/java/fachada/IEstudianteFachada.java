/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import dominios.EstudianteDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IEstudianteFachada {
    List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;

    EstudianteDominio buscarPorID(String id) throws NegocioException;

    boolean estaBloqueado(String id) throws NegocioException;

    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException;
}
