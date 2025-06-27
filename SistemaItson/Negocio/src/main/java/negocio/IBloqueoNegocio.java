/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IBloqueoNegocio {

    BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException;

    BloqueoDominio buscarPorId(int id) throws NegocioException;

    void liberarBloqueo(int id) throws NegocioException;

    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException;
    
    List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;
}
