/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Camila Zubía
 */
public class EstudianteRegistroDTO {
    private String usuario;
    private char[] contrasena;
    private String contrasenaHash;

    public EstudianteRegistroDTO(String usuario, char[] contrasena) {
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public char[] getContrasena() {
        return contrasena;
    }

    public void setContrasena(char[] contrasena) {
        this.contrasena = contrasena;
    }

    public String getContrasenaHash() {
        return contrasenaHash;
    }

    public void setContrasenaHash(String contrasenaHash) {
        this.contrasenaHash = contrasenaHash;
    }
    
}
