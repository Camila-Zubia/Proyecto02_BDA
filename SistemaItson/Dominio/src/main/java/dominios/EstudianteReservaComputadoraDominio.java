/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import java.time.LocalTime;
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
@Table(name = "reservas")
public class EstudianteReservaComputadoraDominio implements Serializable {

    @Id()
    @Column(name = "idReserva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReserva;
    
    @Column(name = "tiempoReserva", nullable = false, length = 50)
    private int tiempoReserva;
    
    @Column(name = "fechaInicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalTime fechaInicio;

    @Column(name = "fechaLiberacion")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalTime fechaLiberacion;

    
    /**
     * CONEXIONES
     */
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private EstudianteDominio estudianteReserva;
    
    @ManyToOne
    @JoinColumn(name = "idComputadora")
    private ComputadoraDominio computadoraReservas;

    public EstudianteReservaComputadoraDominio() {
    }

    public EstudianteReservaComputadoraDominio(int tiempoReserva, LocalTime fechaInicio, LocalTime fechaLiberacion) {
        this.tiempoReserva = tiempoReserva;
        this.fechaInicio = fechaInicio;
        this.fechaLiberacion = fechaLiberacion;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getTiempoReserva() {
        return tiempoReserva;
    }

    public void setTiempoReserva(int tiempoReserva) {
        this.tiempoReserva = tiempoReserva;
    }

    public LocalTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalTime getFechaLiberacion() {
        return fechaLiberacion;
    }

    public void setFechaLiberacion(LocalTime fechaLiberacion) {
        this.fechaLiberacion = fechaLiberacion;
    }

    public EstudianteDominio getEstudianteReserva() {
        return estudianteReserva;
    }

    public void setEstudianteReserva(EstudianteDominio estudianteReserva) {
        this.estudianteReserva = estudianteReserva;
    }

    public ComputadoraDominio getComputadoraReservas() {
        return computadoraReservas;
    }

    public void setComputadoraReservas(ComputadoraDominio computadoraReservas) {
        this.computadoraReservas = computadoraReservas;
    }
    
    
    

}
