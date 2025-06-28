/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Camila Zubía
 */
public class FiltroReporteCarrerasDTO {
    
    private List<String> carreras;
    private Date fechaInicio;
    private Date fechaFin;

    public FiltroReporteCarrerasDTO() {
    }

    public FiltroReporteCarrerasDTO(List<String> carreras, Date fechaInicio, Date fechaFin) {
        this.carreras = carreras;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public List<String> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<String> carreras) {
        this.carreras = carreras;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
    
}
