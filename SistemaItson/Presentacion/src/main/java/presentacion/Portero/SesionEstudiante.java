/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.Portero;

import dominios.EstudianteDominio;

/**
 *
 * @author Camila Zubía
 */
public class SesionEstudiante {
    private static EstudianteDominio estudianteActual;
    
    public static void iniciarSesion(EstudianteDominio estudiante) {
        SesionEstudiante.estudianteActual = estudiante;
    }
    
    public static EstudianteDominio getEstudianteActual() {
        return estudianteActual;
    }

    public static void cerrarSesion() {
        estudianteActual = null;
    }

    public static boolean haySesionActiva() {
        return estudianteActual != null;
    }
    
}
