/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.AdministradorRegistroDTO;
import dominios.AdministradorDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author saula
 */
public interface IAdministradorDAO {

    /**
     * Busca un administrador por su usuario.
     *
     * @param administradorRegistroDTO DTO que contiene el usuario a buscar.
     * @return AdministradorDominio encontrado o null si no existe.
     * @throws PersistenciaException Si ocurre un error durante la consulta.
     */
    public AdministradorDominio buscarPorUsuario(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException;
}
