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
    private int idEstudiante;
    
    @Column(name = "idEscolar", nullable = false, length = 10)
    private String idEscolar;

    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;

    @Column(name = "apellidoPaterno", nullable = false, length = 50)
    private String apellidoPaterno;

    @Column(name = "apellidoMaterno", nullable = true, length = 50)
    private String apellidoMaterno;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    @Column(name = "contraseña", nullable = false, length = 150)
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

    public String getIdEscolar() {
        return idEscolar;
    }

    public void setIdEscolar(String idEscolar) {
        this.idEscolar = idEscolar;
    }

    public int getIdEstudiante() {
        return idEstudiante;
    }

    public EstudianteDominio(String idEscolar, String nombres, String apellidoPaterno, String apellidoMaterno, boolean estatus, String contraseña, List<BloqueoDominio> bloqueos, CarreraDominio carrera, List<EstudianteReservaComputadoraDominio> reservas) {
        this.idEscolar = idEscolar;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estatus = estatus;
        this.contraseña = contraseña;
        this.bloqueos = bloqueos;
        this.carrera = carrera;
        this.reservas = reservas;
    }

    public EstudianteDominio(String idEscolar, String nombres, String apellidoPaterno, String apellidoMaterno, boolean estatus, String contraseña, CarreraDominio carrera) {
        this.idEscolar = idEscolar;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estatus = estatus;
        this.contraseña = contraseña;
        this.carrera = carrera;
    }
    
    

    public void setIdEstudiante(int idEstudiante) {
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
