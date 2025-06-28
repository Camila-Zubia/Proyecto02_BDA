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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author adell
 */
@Entity
@Table(name = "unidadesAcademicas")

public class UnidadAcademicaDominio implements Serializable {

    @Id()
    @Column(name = "idUnidadAcademica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUnidadAcademica;
    
    @Column(name = "nombres", nullable = false, length = 50)
    private String nombres;
    
    /**
     * CONEXIONES
     */
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "unidadAcademica")
    private List<CarreraDominio> carreras;
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "unidadAcademica")
    private List<LaboratorioDominio> laboratorios;

    public UnidadAcademicaDominio() {
    }

    public UnidadAcademicaDominio(String nombres) {
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

    public List<CarreraDominio> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<CarreraDominio> carreras) {
        this.carreras = carreras;
    }

    public List<LaboratorioDominio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<LaboratorioDominio> laboratorios) {
        this.laboratorios = laboratorios;
    }
    
    
    @Override
    public String toString() {
        return this.nombres;
    }

}
