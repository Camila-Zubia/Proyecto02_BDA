/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.EstudianteRegistroDTO;
import DTO.FiltroDTO;
import DTO.TablaEstudiantesDTO;
import dominios.EstudianteDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IEstudianteDAO {

    List<TablaEstudiantesDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException;

    EstudianteDominio buscarPorID(String id) throws PersistenciaException;

    boolean estaBloqueado(String id) throws PersistenciaException;

    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws PersistenciaException;

    public EstudianteDominio buscarPorUsuario(EstudianteRegistroDTO estudianteRegistroDTO) throws PersistenciaException;

}
