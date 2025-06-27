/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fachada.implementaciones;

import DTO.FiltroDTO;
import DTO.TablaBloqueosDTO;
import daos.IBloqueoDAO;
import daos.IConexionBD;
import daos.implementaciones.BloqueoDAO;
import daos.implementaciones.ConexionBD;
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

    private final IBloqueoNegocio bloqueoNegocio;

    public BloqueoFachada() {
        IConexionBD conexionBD = new ConexionBD();
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(conexionBD);
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

    @Override
    public List<TablaBloqueosDTO> buscarTabla(FiltroDTO filtro) throws NegocioException {
        return bloqueoNegocio.buscarTabla(filtro);
    }

}
