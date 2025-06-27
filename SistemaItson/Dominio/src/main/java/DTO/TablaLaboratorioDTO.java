/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalTime;

/**
 *
 * @author Camila Zubía
 */
public class TablaLaboratorioDTO {
    private int idLaboratorios;
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;

    public TablaLaboratorioDTO(int idLaboratorios, String nombre, LocalTime horaInicio, LocalTime horaFin) {
        this.idLaboratorios = idLaboratorios;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdLaboratorios() {
        return idLaboratorios;
    }

    public void setIdLaboratorios(int idLaboratorios) {
        this.idLaboratorios = idLaboratorios;
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

    @Override
    public String toString() {
        return "TablaLaboratorioDTO{" + "idLaboratorios=" + idLaboratorios + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
}
