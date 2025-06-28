package DTO;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;


public class NuevoLaboratorioDTO {
    private String nombre;
    private Date horaInicio;
    private Date horaCierre;
    private char[] contrasena;
    private String unidad;
    private String contrasenaHash;

    public NuevoLaboratorioDTO() {
    }

    public NuevoLaboratorioDTO(String nombre, Date horaInicio, Date horaCierre, char[] contrasena, String unidad) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaCierre = horaCierre;
        this.contrasena = contrasena;
        this.unidad = unidad;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public char[] getContrasena() {
        return contrasena;
    }

    public void setContrasena(char[] contrasena) {
        this.contrasena = contrasena;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
    public void limpiarContrasena() {
        if (contrasena != null) Arrays.fill(contrasena, '\0');
    }
    
}
