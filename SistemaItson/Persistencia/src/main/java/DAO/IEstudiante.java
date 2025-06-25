/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import dominios.estudianteDominio;


/**
 *
 * @author Camila Zubía
 */
public interface IEstudiante {
    
     estudianteDominio buscarPorID(int id) throws PersistenciaException;
     
     boolean estaBloqueado(int id) throws PersistenciaException;
    
}
