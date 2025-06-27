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
public class ComputadoraDominio implements Serializable {

    @Id()
    @Column(name = "idComputadoras")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComputadoras;

    @Column(name = "numero", nullable = false, length = 50)
    private String numero;

    @Column(name = "direccionIp", nullable = false, length = 50)
    private String direccionIp;
    
    @Column(name = "estatus", nullable = false)
    private EstatusComputadora estatus;

    @Column(name = "tipo", nullable = false)
    private TipoComputadora tipo;

    /**
     * CONEXIONES
     */
    @ManyToOne
    @JoinColumn(name = "idLaboratorio")
    private LaboratorioDominio laboratorio;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "computadora")
    private List<ComputadoraSoftwareDominio> detalles;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "computadoraReservas")
    private List<EstudianteReservaComputadoraDominio> reservas;

    public ComputadoraDominio() {
    }

    public ComputadoraDominio(String numero, String direccionIp, EstatusComputadora estatus, TipoComputadora tipo) {
        this.numero = numero;
        this.direccionIp = direccionIp;
        this.estatus = estatus;
        this.tipo = tipo;
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

    public EstatusComputadora isEstatus() {
        return estatus;
    }

    public void setEstatus(EstatusComputadora estatus) {
        this.estatus = estatus;
    }

    public TipoComputadora getTipo() {
        return tipo;
    }

    public void setTipo(TipoComputadora tipo) {
        this.tipo = tipo;
    }

    public LaboratorioDominio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioDominio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<ComputadoraSoftwareDominio> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<ComputadoraSoftwareDominio> detalles) {
        this.detalles = detalles;
    }

    public List<EstudianteReservaComputadoraDominio> getReservas() {
        return reservas;
    }

    public void setReservas(List<EstudianteReservaComputadoraDominio> reservas) {
        this.reservas = reservas;
    }

    public EstatusComputadora getEstatus() {
        return estatus;
    }
    
}
