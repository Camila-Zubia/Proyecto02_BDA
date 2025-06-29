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
    
    /**
 * Crea y devuelve una nueva instancia de EntityManager para interactuar con la base de datos.
 *
 * @return EntityManager instancia para realizar operaciones JPA.
 */
public EntityManager crearConexion();

  
}
