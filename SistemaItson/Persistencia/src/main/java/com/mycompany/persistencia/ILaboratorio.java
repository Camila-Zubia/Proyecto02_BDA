/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import DTO.LaboratorioDTO;
import dominios.laboratorioDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author Camila Zubía
 */
public interface ILaboratorio {
    
    laboratorioDominio buscarPorId(int id) throws PersistenciaException;

    laboratorioDominio agregar(laboratorioDominio laboratorio) throws PersistenciaException;
    
    laboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException;
}
