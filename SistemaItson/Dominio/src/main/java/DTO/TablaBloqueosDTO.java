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
public class TablaBloqueosDTO {
    
    private int idBloqueo;
    private Calendar fechaBloqueo;
    private String motivo;
    private boolean estatus;

    public TablaBloqueosDTO(int idBloqueo, Calendar fechaBloqueo, String motivo, boolean estatus) {
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

    public Calendar getFechaBloqueo() {
        return fechaBloqueo;
    }

    public void setFechaBloqueo(Calendar fechaBloqueo) {
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
