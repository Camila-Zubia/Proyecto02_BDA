/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import daos.IBloqueoDAO;
import daos.implementaciones.BloqueoDAO;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import fachada.IBloqueoFachada;
import java.util.List;
import negocio.IBloqueoNegocio;
import negocio.implementaciones.BloqueoNegocio;

/**
 *
 * @author adell
 */
public class BloqueoFachada implements IBloqueoFachada {

    private IBloqueoNegocio bloqueoNegocio;

    public BloqueoFachada() {
        IBloqueoDAO bloqueoDAO = new BloqueoDAO();
        this.bloqueoNegocio = new BloqueoNegocio(bloqueoDAO);
    }

    @Override
    public BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        return bloqueoNegocio.registrarBloqueo(bloqueo);
    }

    @Override
    public BloqueoDominio buscarPorId(int id) throws NegocioException {
        return bloqueoNegocio.buscarPorId(id);
    }

    @Override
    public void liberarBloqueo(int id) throws NegocioException {
        bloqueoNegocio.liberarBloqueo(id);
    }

    @Override
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException {
        return bloqueoNegocio.obtenerBloqueosActivos();
    }

}
