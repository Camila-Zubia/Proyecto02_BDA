/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fachada;

import DTO.AdministradorRegistroDTO;
import dominios.AdministradorDominio;
import excepciones.NegocioException;

/**
 *
 * @author saula
 */
public interface IAdministradorFachada {
    
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException;
}
