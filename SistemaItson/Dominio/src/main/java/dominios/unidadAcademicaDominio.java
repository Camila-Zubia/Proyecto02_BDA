/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adell
 */
@Entity
@Table(name = "unidadesAcademicas")

public class unidadAcademicaDominio implements Serializable {

    @Id()
    @Column(name = "idUnidadAcademica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadAcademica;
    
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    
    /**
     * CONEXIONES
     */
    @OneToMany(mappedBy = "unidadAcademica")
    private List<carreraDominio> carreras;
    
    @OneToMany(mappedBy = "unidadAcademica")
    private List<laboratorioDominio> laboratorios;

    public unidadAcademicaDominio() {
    }

    public unidadAcademicaDominio(String nombres) {
        this.nombres = nombres;
      
    }

    public int getIdUnidadAcademica() {
        return idUnidadAcademica;
    }

    public void setIdUnidadAcademica(int idUnidadAcademica) {
        this.idUnidadAcademica = idUnidadAcademica;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public List<carreraDominio> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<carreraDominio> carreras) {
        this.carreras = carreras;
    }

    public List<laboratorioDominio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<laboratorioDominio> laboratorios) {
        this.laboratorios = laboratorios;
    }
    
    
    
    
    
}
