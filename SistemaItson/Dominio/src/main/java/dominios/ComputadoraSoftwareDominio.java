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
@Table(name = "SoftwaresInstalados")
public class ComputadoraSoftwareDominio implements Serializable {

   @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
   
   /**
    * CONEXIONES
    */
   
   @ManyToOne
    @JoinColumn(name = "idSoftware")
    private SoftwareDominio software;
    
    @ManyToOne
    @JoinColumn(name = "idComputadora")
    private ComputadoraDominio computadora;      

    public ComputadoraSoftwareDominio() {
    }

    public ComputadoraSoftwareDominio(int id, SoftwareDominio software, ComputadoraDominio computadora) {
        this.id = id;
        this.software = software;
        this.computadora = computadora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SoftwareDominio getSoftware() {
        return software;
    }

    public void setSoftware(SoftwareDominio software) {
        this.software = software;
    }

    public ComputadoraDominio getComputadora() {
        return computadora;
    }

    public void setComputadora(ComputadoraDominio computadora) {
        this.computadora = computadora;
    }
    

   

    
    
    
    
    
}
