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
public class NuevaComputadoraDTO {
    
    private String numero;
    private String direccionIp;
    private EstatusComputadora estatus;
    private TipoComputadora tipo;
    private String laboratorio;

    public NuevaComputadoraDTO(String numero, String direccionIp, EstatusComputadora estatus, TipoComputadora tipo, String laboratorio) {
        this.numero = numero;
        this.direccionIp = direccionIp;
        this.estatus = estatus;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
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

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    
    
}
