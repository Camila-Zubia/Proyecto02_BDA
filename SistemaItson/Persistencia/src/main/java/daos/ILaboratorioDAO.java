/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.LaboratorioDTO;
import dominios.LaboratorioDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author Camila Zubía
 */
public interface ILaboratorioDAO {
    
    LaboratorioDominio buscarPorId(int id) throws PersistenciaException;

    LaboratorioDominio agregar(LaboratorioDominio laboratorio) throws PersistenciaException;
    
    LaboratorioDominio modificar(LaboratorioDTO laboratorio) throws PersistenciaException;
}
