/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.bloqueoDominio;
import excepciones.PersistenciaException;

/**
 *
 * @author Camila Zubía
 */
public interface IBloqueo {
    
    bloqueoDominio registrarBloqueo(bloqueoDominio bloqueo) throws PersistenciaException;
    
    bloqueoDominio buscarPorId(int id) throws PersistenciaException;
    
    void liberarBloqueo(int id) throws PersistenciaException;
    
    //List<bloqueoDominio> buscarTabla() throws PersistenciaException;
    
}
