/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import dominios.EstatusComputadora;
import dominios.TipoComputadora;

/**
 *
 * @author Camila Zubía
 */
public class TablaComputadoraDTO {
    
    private int idComputadora;
    private String numero;
    private String direccionIp;
    private EstatusComputadora estatus;
    private TipoComputadora tipo;

    public TablaComputadoraDTO(int idComputadora, String numero, String direccionIp, EstatusComputadora estatus, TipoComputadora tipo) {
        this.idComputadora = idComputadora;
        this.numero = numero;
        this.direccionIp = direccionIp;
        this.estatus = estatus;
        this.tipo = tipo;
    }

    public int getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(int idComputadora) {
        this.idComputadora = idComputadora;
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

    public EstatusComputadora getEstatus() {
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

    @Override
    public String toString() {
        return "TablaComputadoraDTO{" + "idComputadora=" + idComputadora + ", numero=" + numero + ", direccionIp=" + direccionIp + ", estatus=" + estatus + ", tipo=" + tipo + '}';
    }
}
