package DTO;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;


public class ReporteCentroComputoDTO {
    private String nombreLaboratorio;
    private String numeroComputadora;
    private Long cantidadAlumnos;
    private Long minutosUsos;
    private Long minutosInactividad;
    private Date fecha;

    public ReporteCentroComputoDTO(String nombreLaboratorio, String numeroComputadora, Long cantidadAlumnos, Long minutosUsos, Long minutosInactividad, Date fecha) {
        this.nombreLaboratorio = nombreLaboratorio;
        this.numeroComputadora = numeroComputadora;
        this.cantidadAlumnos = cantidadAlumnos;
        this.minutosUsos = minutosUsos;
        this.minutosInactividad = minutosInactividad;
        this.fecha = fecha;
    }

    public String getNombreLaboratorio() {
        return nombreLaboratorio;
    }

    public void setNombreLaboratorio(String nombreLaboratorio) {
        this.nombreLaboratorio = nombreLaboratorio;
    }

    public String getNumeroComputadora() {
        return numeroComputadora;
    }

    public void setNumeroComputadora(String numeroComputadora) {
        this.numeroComputadora = numeroComputadora;
    }

    public Long getCantidadAlumnos() {
        return cantidadAlumnos;
    }

    public void setCantidadAlumnos(Long cantidadAlumnos) {
        this.cantidadAlumnos = cantidadAlumnos;
    }

    public Long getMinutosUsos() {
        return minutosUsos;
    }

    public void setMinutosUsos(Long minutosUsos) {
        this.minutosUsos = minutosUsos;
    }

    public Long getMinutosInactividad() {
        return minutosInactividad;
    }

    public void setMinutosInactividad(Long minutosInactividad) {
        this.minutosInactividad = minutosInactividad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
   
}
