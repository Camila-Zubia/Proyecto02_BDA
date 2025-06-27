/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adell
 */
@Entity
@Table(name = "estudiantes")
public class EstudianteDominio implements Serializable {

    @Id()
    @Column(name = "idEstudiante")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idEstudiante;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = false, length = 50)
    private String apellidoMaterno;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    @Column(name = "contraseña", nullable = false, length = 50)
    private String contraseña;
    
    /**
     *  CONEXIONES
     */
    @OneToMany(mappedBy = "estudiante")
    private List<BloqueoDominio> bloqueos;

    @ManyToOne
    @JoinColumn(name = "idCarrera")
    private CarreraDominio carrera;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "estudianteReserva")
    private List<EstudianteReservaComputadoraDominio> reservas;

    public EstudianteDominio() {
    }

    public EstudianteDominio(String nombres, String apellidoPaterno, String apellidoMaterno, boolean estatus, String contraseña) {
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estatus = estatus;
        this.contraseña = contraseña;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public List<BloqueoDominio> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(List<BloqueoDominio> bloqueos) {
        this.bloqueos = bloqueos;
    }

    public CarreraDominio getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDominio carrera) {
        this.carrera = carrera;
    }

    public List<EstudianteReservaComputadoraDominio> getReservas() {
        return reservas;
    }

    public void setReservas(List<EstudianteReservaComputadoraDominio> reservas) {
        this.reservas = reservas;
    }

    
    /**
     * 
     */
     
     
     
}
