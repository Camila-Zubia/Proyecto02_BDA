/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package daos;

import javax.persistence.EntityManager;

/**
 *
 * @author saula
 */
public interface IConexionBD {
    
    public EntityManager crearConexion();
  
}
