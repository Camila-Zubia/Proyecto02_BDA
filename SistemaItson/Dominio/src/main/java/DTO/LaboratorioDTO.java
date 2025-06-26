/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalTime;
import java.util.Calendar;

/**
 *
 * @author Camila Zubía
 */
public class LaboratorioDTO {
    
    private int idLaboratorios;
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public LaboratorioDTO(String nombre, LocalTime horaInicio, LocalTime horaFin) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getIdLaboratorios() {
        return idLaboratorios;
    }

    @Override
    public String toString() {
        return "LaboratorioDTO{" + "nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
    
}
