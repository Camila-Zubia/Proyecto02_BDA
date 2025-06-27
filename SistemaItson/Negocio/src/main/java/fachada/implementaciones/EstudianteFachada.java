/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import dominios.EstudianteDominio;
import excepciones.NegocioException;
import fachada.IEstudianteFachada;
import java.util.List;
import negocio.IEstudianteNegocio;

/**
 *
 * @author adell
 */
public class EstudianteFachada implements IEstudianteFachada {

    private IEstudianteNegocio estudianteNegocio;

    @Override
    public List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return estudianteNegocio.buscarTabla(filtro);
    }

    @Override
    public EstudianteDominio buscarPorID(String id) throws NegocioException {
        return estudianteNegocio.buscarPorID(id);
    }

    @Override
    public boolean estaBloqueado(String id) throws NegocioException {
        return estudianteNegocio.estaBloqueado(id);
    }

    @Override
    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws NegocioException {
        return estudianteNegocio.obtenerEstudiantesConBloqueosActivos();
    }

}
