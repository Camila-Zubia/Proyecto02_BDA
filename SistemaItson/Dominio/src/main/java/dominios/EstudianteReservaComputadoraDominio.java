/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
    
    @Column(name = "minutosReserva", nullable = false, length = 50)
    private int minutosReserva;
    
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

    public EstudianteReservaComputadoraDominio(int idReserva, int minutosReserva, EstudianteDominio estudianteReserva, ComputadoraDominio computadoraReservas) {
        this.idReserva = idReserva;
        this.minutosReserva = minutosReserva;
        this.estudianteReserva = estudianteReserva;
        this.computadoraReservas = computadoraReservas;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getMinutosReserva() {
        return minutosReserva;
    }

    public void setMinutosReserva(int minutosReserva) {
        this.minutosReserva = minutosReserva;
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
