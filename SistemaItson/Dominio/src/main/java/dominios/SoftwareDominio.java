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
@Table(name = "softwares")

public class SoftwareDominio implements Serializable {

    @Id()
    @Column(name = "idSoftware")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSoftware;
    
    @Column(name = "nombre", nullable = false, length = 50)
    private String nombres;
    
    @Column(name = "version", nullable = false, length = 50)
    private String version;
    
    /**
     * CONEXIONES
     */
    
    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "software")
    private List<ComputadoraSoftwareDominio> detalles;

    public SoftwareDominio() {
    }

    public SoftwareDominio(String nombres, String version) {
        this.nombres = nombres;
        this.version = version;
    }

    public int getIdSoftware() {
        return idSoftware;
    }

    public void setIdSoftware(int idSoftware) {
        this.idSoftware = idSoftware;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<ComputadoraSoftwareDominio> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ComputadoraSoftwareDominio> detalles) {
        this.detalles = detalles;
    }
    
    
    
    
    
    
}
