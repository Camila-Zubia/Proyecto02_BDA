package DTO;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

public class AdministradorRegistroDTO {
    private String usuario;
    private char[] contrasena;
    private String contrasenaHash;

    public AdministradorRegistroDTO() {
    }

    public AdministradorRegistroDTO(String usuario, char[] contrasena) {
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
