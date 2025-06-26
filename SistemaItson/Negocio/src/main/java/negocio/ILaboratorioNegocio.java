/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.NuevoLaboratorioDTO;
import dominios.LaboratorioDominio;
import excepciones.NegocioException;

/**
 *
 * @author saula
 */
public interface ILaboratorioNegocio {
    
    public LaboratorioDominio guardar(NuevoLaboratorioDTO nuevoLaboratorio) throws NegocioException;

}
