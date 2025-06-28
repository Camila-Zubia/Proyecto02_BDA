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
    /**
     * Metodo de iniciar sesion de administrador
     * @param administradorRegistroDTO dto del administrador
     * @return devuelve un admnistrador dominio
     * @throws NegocioException tipo de excepcion a lanzar en caso de error
     */
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException;
}
