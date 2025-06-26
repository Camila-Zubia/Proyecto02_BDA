/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.EstudianteDominio;
import excepciones.PersistenciaException;
import java.util.List;


/**
 *
 * @author Camila Zubía
 */
public interface IEstudiante {


     
     EstudianteDominio buscarPorID(int id) throws PersistenciaException;
     
     boolean estaBloqueado(int id) throws PersistenciaException;
    


    public List<EstudianteDominio> obtenerEstudiantesConBloqueosActivos() throws PersistenciaException;


}
