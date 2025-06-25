/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

/**
 *
 * @author Camila Zubía
 */
public enum EstatusComputadora {
    DISPONIBLE,
    APARTADA,
    DESCONECTADA;
    
    public static EstatusComputadora fromString(String estatusStr) {
        for (EstatusComputadora estatus : values()) {
            if (estatus.name().equalsIgnoreCase(estatusStr)) {
                return estatus;
            }
        }
        throw new IllegalArgumentException("Estatus inválido: " + estatusStr);
    }
    
}
