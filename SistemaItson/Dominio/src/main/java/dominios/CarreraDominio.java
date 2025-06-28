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
@Table(name = "carreras")
public class CarreraDominio implements Serializable {

    @Id()
    @Column(name = "idCarrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "TiempoLimiteDiario", nullable = false, length = 50)
    private int TiempoLimiteDiario;

    /**
     * CONEXIONES
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "carrera")
    private List<EstudianteDominio> estudiantes;
    
    @ManyToOne
    @JoinColumn(name = "idUnidadAcademica")
    private UnidadAcademicaDominio unidadAcademica;

    
    
    
    /**
     * 
     */
    
    public CarreraDominio() {
    }

    public CarreraDominio(String nombre, int TiempoLimiteDiario) {
        this.nombre = nombre;
        this.TiempoLimiteDiario = TiempoLimiteDiario;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoLimiteDiario() {
        return TiempoLimiteDiario;
    }

    public void setTiempoLimiteDiario(int TiempoLimiteDiario) {
        this.TiempoLimiteDiario = TiempoLimiteDiario;
    }

    public List<EstudianteDominio> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDominio> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public UnidadAcademicaDominio getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(UnidadAcademicaDominio unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }

    @Override
    public String toString() {
        return  nombre;
    }
    
    
}
