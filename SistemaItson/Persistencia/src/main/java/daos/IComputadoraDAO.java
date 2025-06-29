/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import DTO.FiltroDTO;
import DTO.NuevaComputadoraDTO;
import DTO.TablaComputadoraDTO;
import dominios.ComputadoraDominio;
import dominios.LaboratorioDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IComputadoraDAO {

    /**
     * Busca una computadora por su ID.
     *
     * @param id ID de la computadora.
     * @return ComputadoraDominio encontrada.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    ComputadoraDominio buscarPorId(int id) throws PersistenciaException;

    /**
     * Busca una computadora por su número identificador.
     *
     * @param numero Número de la computadora.
     * @return ComputadoraDominio encontrada.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    ComputadoraDominio buscarPorNumero(String numero) throws PersistenciaException;

    /**
     * Agrega una nueva computadora usando datos de DTO.
     *
     * @param computadoraDTO DTO con los datos de la computadora.
     * @return ComputadoraDominio creada y persistida.
     * @throws PersistenciaException Si ocurre un error al guardar.
     */
    ComputadoraDominio agregar(NuevaComputadoraDTO computadoraDTO) throws PersistenciaException;

    /**
     * Cambia el estatus de la computadora a apartada.
     *
     * @param id ID de la computadora a apartar.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    void apartarComputadora(int id) throws PersistenciaException;

    /**
     * Modifica los datos de una computadora existente.
     *
     * @param computadora Objeto con datos modificados.
     * @return ComputadoraDominio actualizado.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    ComputadoraDominio modificar(ComputadoraDominio computadora) throws PersistenciaException;

    /**
     * Marca una computadora como desconectada (eliminada lógicamente).
     *
     * @param id ID de la computadora a eliminar.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    void eliminar(int id) throws PersistenciaException;

    /**
     * Lista todas las computadoras.
     *
     * @return Lista de todas las computadoras.
     * @throws PersistenciaException Si hay error en la consulta.
     */
    List<ComputadoraDominio> listarComputadoras() throws PersistenciaException;

    /**
     * Libera una computadora, cambiando su estatus a disponible.
     *
     * @param id ID de la computadora a liberar.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    void liberarComputadora(int id) throws PersistenciaException;

    /**
     * Busca computadoras con filtros y paginación para tabla.
     *
     * @param filtro Parámetros de filtro, offset y límite.
     * @return Lista de TablaComputadoraDTO con resultados.
     * @throws PersistenciaException Si ocurre error en la consulta.
     */
    List<TablaComputadoraDTO> buscarTabla(FiltroDTO filtro) throws PersistenciaException;

    /**
     * Busca el laboratorio asociado a una computadora por IP.
     *
     * @param ip Dirección IP de la computadora.
     * @return LaboratorioDominio asociado.
     * @throws PersistenciaException Si no se encuentra o hay error.
     */
    LaboratorioDominio buscarLaboratorioPorIp(String ip) throws PersistenciaException;

}
