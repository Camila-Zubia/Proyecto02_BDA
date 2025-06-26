/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.persistencia;

import dominios.BloqueoDominio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public interface IBloqueo {
    
    BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws PersistenciaException;
    
    BloqueoDominio buscarPorId(int id) throws PersistenciaException;
    
    void liberarBloqueo(int id) throws PersistenciaException;
    
    //List<bloqueoDominio> buscarTabla() throws PersistenciaException;
    
    public List<BloqueoDominio> obtenerBloqueosActivos() throws PersistenciaException;
    
}
