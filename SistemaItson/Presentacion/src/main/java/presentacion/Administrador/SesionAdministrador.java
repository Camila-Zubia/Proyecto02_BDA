package presentacion.Administrador;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import dominios.AdministradorDominio;


public class SesionAdministrador {

    private static AdministradorDominio administradorActual;
    
    public static void iniciarSesion (AdministradorDominio administrador){
        SesionAdministrador.administradorActual = administrador;
    }
    
    public static AdministradorDominio getAdministradorActual() {
        return administradorActual;
    }
    
    public static void cerrarSesion() {
        administradorActual = null;
    }
    
     public static boolean haySesionActiva() {
        return administradorActual != null;
    }
}
