/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;
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
@Table(name = "carreras")
public class carreraDominio implements Serializable {

    @Id()
    @Column(name = "idCarrera")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCarrera;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "TiempoLimiteDiario", nullable = false, length = 50)
    @Temporal(TemporalType.DATE)
    private Calendar TiempoLimiteDiario;

    /**
     * CONEXIONES
     */
    @OneToMany(mappedBy = "carrera")
    private List<estudianteDominio> estudiantes;
    
    @ManyToOne
    @JoinColumn(name = "idUnidadAcademica")
    private unidadAcademicaDominio unidadAcademica;

    
    
    
    /**
     * 
     */
    
    public carreraDominio() {
    }

    public carreraDominio(String nombre, Calendar TiempoLimiteDiario) {
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

    public Calendar getTiempoLimiteDiario() {
        return TiempoLimiteDiario;
    }

    public void setTiempoLimiteDiario(Calendar TiempoLimiteDiario) {
        this.TiempoLimiteDiario = TiempoLimiteDiario;
    }

    public List<estudianteDominio> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<estudianteDominio> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public unidadAcademicaDominio getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(unidadAcademicaDominio unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
    
    
}
