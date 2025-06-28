/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adell
 */
@Entity
@Table(name = "bloqueos")

public class BloqueoDominio implements Serializable {

    @Id()
    @Column(name = "idBloqueo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBloqueo;

    @Column(name = "FechaBloqueo", nullable = false, length = 50)
    @Temporal(TemporalType.DATE)
    private Date fechaBloqueo;
    
    @Column(name = "FechaLiberacion", length = 50)
    @Temporal(TemporalType.DATE)
    private Date fechaLiberacion;

    @Column(name = "motivo", nullable = false, length = 50)
    private String motivo;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    /**
     * CONEXIONES
     */
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private EstudianteDominio estudiante;

    
    /**
     * 
     */
    
    public BloqueoDominio() {
    }

    public BloqueoDominio(Date fechaBloqueo, Date fechaLiberacion, String motivo, boolean estatus) {
        this.fechaBloqueo = fechaBloqueo;
        this.fechaLiberacion = fechaLiberacion;
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

    public void setFechaBloqueo(Date FechaBloqueo) {
        this.fechaBloqueo = FechaBloqueo;
    }

    public Date getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(Date fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
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

    public EstudianteDominio getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDominio estudiante) {
        this.estudiante = estudiante;
    }
    
    
    
    
    
}
