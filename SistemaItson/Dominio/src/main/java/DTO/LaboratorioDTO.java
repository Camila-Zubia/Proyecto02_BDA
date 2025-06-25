/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;

/**
 *
 * @author Camila Zubía
 */
public class LaboratorioDTO {
    
    private int idLaboratorios;
    private String nombre;
    private Calendar horaInicio;
    private Calendar horaFin;

    public LaboratorioDTO(String nombre, Calendar horaInicio, Calendar horaFin) {
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

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Calendar horaFin) {
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
