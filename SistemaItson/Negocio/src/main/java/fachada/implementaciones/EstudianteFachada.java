/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import DTO.EstudianteRegistroDTO;
import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import daos.IConexionBD;
import daos.IEstudianteDAO;
import daos.implementaciones.ConexionBD;
import daos.implementaciones.EstudianteDAO;
import dominios.EstudianteDominio;
import excepciones.NegocioException;
import fachada.IEstudianteFachada;
import java.util.List;
import negocio.IEstudianteNegocio;
import negocio.implementaciones.EstudianteNegocio;

/**
 *
 * @author adell
 */
public class EstudianteFachada implements IEstudianteFachada {

    private final IEstudianteNegocio estudianteNegocio;

    public EstudianteFachada(){
        IConexionBD conexionBD = new ConexionBD();
        IEstudianteDAO estudianteDAO = new EstudianteDAO(conexionBD);
        this.estudianteNegocio = new EstudianteNegocio(estudianteDAO);
    }
    
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

    @Override
    public EstudianteDominio iniciarSesion(EstudianteRegistroDTO estudianteRegistroDTO) throws NegocioException {
        return estudianteNegocio.iniciarSesion(estudianteRegistroDTO);
    }

}
