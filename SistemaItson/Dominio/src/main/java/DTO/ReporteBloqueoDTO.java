/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Camila Zubía
 */
public class ReporteBloqueoDTO {
    
    private String nombreAlumno;
    private String fechaBloqueo;
    private String fechaLiberacion;
    private String motivo;

    public ReporteBloqueoDTO(String nombreAlumno, String fechaBloqueo, String fechaLiberacion, String motivo) {
        this.nombreAlumno = nombreAlumno;
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
        this.motivo = motivo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(String fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    public String getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(String fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
}
