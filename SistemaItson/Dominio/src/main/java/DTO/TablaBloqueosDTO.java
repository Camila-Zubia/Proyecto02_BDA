/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Camila Zubía
 */
public class TablaBloqueosDTO {
    
    private int idBloqueo;
    private Date fechaBloqueo;
    private String motivo;
    private boolean estatus;

    public TablaBloqueosDTO(int idBloqueo, Date fechaBloqueo, String motivo, boolean estatus) {
        this.idBloqueo = idBloqueo;
        this.fechaBloqueo = fechaBloqueo;
        this.motivo = motivo;
        this.estatus = estatus;
    }

    public int getIdBloqueo() {
        return idBloqueo;
    }

    public void setIdBloqueo(int idBloqueo) {
        this.idBloqueo = idBloqueo;
    }

    public Date getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(Date fechaBloqueo) {
        this.fechaBloqueo = fechaBloqueo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "TablaBloqueos{" + "idBloqueo=" + idBloqueo + ", fechaBloqueo=" + fechaBloqueo + ", motivo=" + motivo + ", estatus=" + estatus + '}';
    }
}
