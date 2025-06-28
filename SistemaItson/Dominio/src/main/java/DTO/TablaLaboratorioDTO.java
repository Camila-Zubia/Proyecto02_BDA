/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.time.LocalTime;
import java.util.Date;

/**
 *
 * @author Camila Zubía
 */
public class TablaLaboratorioDTO {
    private int idLaboratorios;
    private String nombre;
    private Date horaInicio;
    private Date horaFin;

    public TablaLaboratorioDTO(int idLaboratorios, String nombre, Date horaInicio, Date horaFin) {
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

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    @Override
    public String toString() {
        return "TablaLaboratorioDTO{" + "idLaboratorios=" + idLaboratorios + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + '}';
    }
}
