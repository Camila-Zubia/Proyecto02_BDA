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
     
    public AdministradorDominio buscarPorUsuario(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException;
}
