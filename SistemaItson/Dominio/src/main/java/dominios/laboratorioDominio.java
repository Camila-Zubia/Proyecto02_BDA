/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author adell
 */
@Entity
@Table(name = "laboratorios")

public class laboratorioDominio implements Serializable {
    @Id()
    @Column(name = "idLaboratorios")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLaboratorios;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;
    
    @Column(name = "contraseña", nullable = false, length = 50)
    private String contraseña;
    
    @Column(name = "horaInicio", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar horaInicio;
    
    @Column(name = "horaFin", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar horaFin;
    
    /**
     * CONEXIONES
     */
    
    @ManyToOne
    @JoinColumn(name = "idUnidadAcademica")
    private unidadAcademicaDominio unidadAcademica;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "laboratorio")
    private List<computadoraDominio> computadoras;

    public laboratorioDominio() {
    }

    public laboratorioDominio(String nombre, String contraseña, Calendar horaInicio, Calendar horaFin) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getIdLaboratorios() {
        return idLaboratorios;
    }

    public void setIdLaboratorios(int idLaboratorios) {
        this.idLaboratorios = idLaboratorios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Calendar getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Calendar horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Calendar getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Calendar horaFin) {
        this.horaFin = horaFin;
    }

    public unidadAcademicaDominio getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(unidadAcademicaDominio unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    public List<computadoraDominio> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<computadoraDominio> computadoras) {
        this.computadoras = computadoras;
    }
    
    
    
    
}
