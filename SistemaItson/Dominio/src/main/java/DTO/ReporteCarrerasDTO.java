/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;

/**
 *
 * @author Camila Zubía
 */
public class ReporteCarrerasDTO {
    
     private String nombreCarrera;
     private Long minutosUsos;
     private Long cantidadAlumnos;
     private Date fecha;

    public ReporteCarrerasDTO(String nombreCarrera, Long minutosUsos, Long cantidadAlumnos, Date fecha) {
        this.nombreCarrera = nombreCarrera;
        this.minutosUsos = minutosUsos;
        this.cantidadAlumnos = cantidadAlumnos;
        this.fecha = fecha;
    }

    public String getNombreCarrera() {
        return nombreCarrera;
    }

    public void setNombreCarrera(String nombreCarrera) {
        this.nombreCarrera = nombreCarrera;
    }

    public Long getMinutosUsos() {
        return minutosUsos;
    }

    public void setMinutosUsos(Long minutosUsos) {
        this.minutosUsos = minutosUsos;
    }

    public Long getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(Long cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
     
    
}
