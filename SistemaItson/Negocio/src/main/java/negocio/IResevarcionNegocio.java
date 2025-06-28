/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package negocio;

import dominios.EstudianteReservaComputadoraDominio;
import excepciones.NegocioException;

/**
 *
 * @author adell
 */
public interface IResevarcionNegocio {

    /**
     * Registra una nueva reservación de computadora para un estudiante.
     *
     * @param reservacion Entidad EstudianteReservaComputadoraDominio con los
     * datos de la reservación a registrar.
     * @return La entidad EstudianteReservaComputadoraDominio recién creada y
     * persistida.
     * @throws NegocioException Si ocurre algún error durante el registro.
     */
    EstudianteReservaComputadoraDominio registrar(EstudianteReservaComputadoraDominio reservacion) throws NegocioException;

    /**
     * Busca una reservación de computadora para estudiante por su identificador
     * único.
     *
     * @param id El identificador único de la reservación.
     * @return La entidad EstudianteReservaComputadoraDominio correspondiente al
     * ID proporcionado.
     * @throws NegocioException Si la reservación no existe o ocurre un error
     * durante la búsqueda.
     */
    EstudianteReservaComputadoraDominio buscarPorId(int id) throws NegocioException;

}
