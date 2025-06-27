/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import DTO.AdministradorRegistroDTO;
import excepciones.PersistenciaException;

/**
 *
 * @author saula
 */
public interface IAdministradorDAO {
     
    public boolean iniciarSesion(AdministradorRegistroDTO administradorRegistroDTO) throws PersistenciaException;
}
