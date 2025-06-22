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
@Table(name = "computadoras")
public class computadoraDominio implements Serializable {

    @Id()
    @Column(name = "idComputadoras")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComputadoras;

    @Column(name = "numero", nullable = false, length = 50)
    private String numero;

    @Column(name = "direccionIp", nullable = false, length = 50)
    private String direccionIp;

    @Column(name = "estatus", nullable = false)
    private boolean estatus;

    /**
     * CONEXIONES
     */
    @ManyToOne
    @JoinColumn(name = "idLaboratorio")
    private laboratorioDominio laboratorio;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "computadora")
    private List<computadoraSoftwareDominio> detalles;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "computadoraReservas")
    private List<estudianteReservaComputadoraDominio> reservas;

    public computadoraDominio() {
    }

    public computadoraDominio(String numero, String direccionIp, boolean estatus) {
        this.numero = numero;
        this.direccionIp = direccionIp;
        this.estatus = estatus;
    }

    public int getIdComputadoras() {
        return idComputadoras;
    }

    public void setIdComputadoras(int idComputadoras) {
        this.idComputadoras = idComputadoras;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public laboratorioDominio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(laboratorioDominio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<computadoraSoftwareDominio> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<computadoraSoftwareDominio> detalles) {
        this.detalles = detalles;
    }

    public List<estudianteReservaComputadoraDominio> getReservas() {
        return reservas;
    }

    public void setReservas(List<estudianteReservaComputadoraDominio> reservas) {
        this.reservas = reservas;
    }

    
    
    
    
    
}
