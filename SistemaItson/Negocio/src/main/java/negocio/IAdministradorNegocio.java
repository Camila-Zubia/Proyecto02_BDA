/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import DTO.AdministradorRegistroDTO;
import dominios.AdministradorDominio;
import excepciones.NegocioException;

/**
 *
 * @author saula
 */
public interface IAdministradorNegocio {

    /**
     * Inicia sesión de un administrador utilizando las credenciales
     * proporcionadas.
     *
     * @param administradorRegistroDTO DTO que contiene el nombre de usuario y
     * la contraseña del administrador.
     * @return La entidad AdministradorDominio correspondiente al administrador
     * autenticado.
     * @throws NegocioException Si las credenciales son incorrectas o si ocurre
     * un error durante el proceso de autenticación.
     */
    public AdministradorDominio iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws NegocioException;
}
