/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.AdministradorRegistroDTO;
import excepciones.NegocioException;

/**
 *
 * @author saula
 */
public interface IAdministradorNegocio {
    
    public boolean iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException;
}
