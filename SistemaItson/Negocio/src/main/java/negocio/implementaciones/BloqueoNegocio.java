/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio.implementaciones;

import daos.IBloqueoDAO;
import dominios.BloqueoDominio;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import java.util.List;
import negocio.IBloqueoNegocio;

/**
 *
 * @author adell
 */
public class BloqueoNegocio implements IBloqueoNegocio {

    private IBloqueoDAO bloqueoDAO;

    public BloqueoNegocio(IBloqueoDAO bloqueoDAO) {
        this.bloqueoDAO = bloqueoDAO;
    }

    @Override
    public BloqueoDominio registrarBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        try {
            motivoBloqueo(bloqueo);
            return bloqueoDAO.registrarBloqueo(bloqueo);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al registrar un bloqueo");
        }
    }

    @Override
    public BloqueoDominio buscarPorId(int id) throws NegocioException {
        try {
            idInvalida(id);
            return bloqueoDAO.buscarPorId(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar buscar un bloqeuo por id");
        }
    }

    @Override
    public void liberarBloqueo(int id) throws NegocioException {
        try {
            idInvalida(id);
            bloqueoDAO.liberarBloqueo(id);
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar liberar un bloqeuo por id");
        }
    }

    @Override
    public List<BloqueoDominio> obtenerBloqueosActivos() throws NegocioException {
        try {
            return bloqueoDAO.obtenerBloqueosActivos();
        } catch (PersistenciaException ex) {
            throw new NegocioException("Ha ocurrido un error al intentar liberar un bloqeuo por id");
        }
    }

    /**
     * VALIDACIONES
     */
    private void motivoBloqueo(BloqueoDominio bloqueo) throws NegocioException {
        if (bloqueo.getMotivo().isEmpty()) {
            throw new NegocioException("El motivo del bloqueo no puede estar vacio");
        }

        if (bloqueo.getMotivo().length() > 50) {
            throw new NegocioException("El motivo del bloqueo no puede ser mayor a 50 caracteres");
        }
    }

    private void idInvalida(int id) throws NegocioException {
        if (id < 0) {
            throw new NegocioException("El id no puede ser menor a 0");
        }
    }

}
