/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominios;

/**
 *
 * @author Camila Zubía
 */
public enum TipoComputadora {
    PORTERO,
    ESTUDIANTE;
    
    public static TipoComputadora fromString(String tipoStr) {
        for (TipoComputadora tipo : values()) {
            if (tipo.name().equalsIgnoreCase(tipoStr)) {
                return tipo;
            }
        }
        throw new IllegalArgumentException("Tipo inválido: " + tipoStr);
    }
    
}
