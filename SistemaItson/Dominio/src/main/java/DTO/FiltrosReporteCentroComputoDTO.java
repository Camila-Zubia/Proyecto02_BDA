package DTO;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.util.Date;
import java.util.List;


public class FiltrosReporteCentroComputoDTO {
    private String laboratorio;
    private List<String> carreras;
    private Date fechaInicio;
    private Date fechaFin;

    public FiltrosReporteCentroComputoDTO(String laboratorio, List<String> carreras, Date fechaInicio, Date fechaFin) {
        this.laboratorio = laboratorio;
        this.carreras = carreras;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public FiltrosReporteCentroComputoDTO() {
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
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
