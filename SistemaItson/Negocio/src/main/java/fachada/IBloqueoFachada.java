/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author adell
 */
public interface IBloqueoFachada {
    
    /**
     * metodo para registrar un bloqueo
     * @param bloqueo hace referencia al bloqueo a registrar
     * @return devuelve un bloqueo dominio
     * @throws NegocioException tipo de excepcion a lanzar en caso de error
     */
    BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException;
    
    /**
     * metodo que busca un bloqueo por su id
     * @param id id del bloqueo a buscar
     * @return devuelve un bloqueo dominio
     * @throws NegocioException tipo de excepcion a lanzar en caso de error
     */
    BloqueoDominio buscarPorId(int id) throws NegocioException;
    
    /**
     * metodo para liberar un bloqueo con su id
     * @param id id del bloqueo que se va a desbloquear
     * @throws NegocioException  tipo de excepcion a lanzar en caso de error
     */
    void liberarBloqueo(int id) throws NegocioException;
    
    /**
     * metodo que obtiene los bloqueos activos
     * @return devuelve una lista de bloqueo dominio
     * @throws NegocioException  tipo de excepcion a lanzar en caso de error
     */
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException;
    
    /**
     * Metodo que facilita la insercion de bloqueos dominios a una jtable
     * @param filtro filtro
     * @return devuelve una lista de tabla bloqueo
     * @throws NegocioException tipo de excepcion a lanzar en caso de error
     */
    List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException;
}
