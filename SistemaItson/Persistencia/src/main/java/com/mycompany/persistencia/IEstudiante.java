/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.EstudianteDominio;
import excepciones.PersistenciaException;


/**
 *
 * @author Camila Zubía
 */
public interface IEstudiante {
    
<<<<<<< HEAD
     EstudianteDominio buscarPorID(int id) throws PersistenciaException;
=======
     estudianteDominio buscarPorID(int id) throws PersistenciaException;
>>>>>>> parent of b1d0fa5 (bloqueos)
     
     boolean estaBloqueado(int id) throws PersistenciaException;
    
}
