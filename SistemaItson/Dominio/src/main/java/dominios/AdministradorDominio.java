package dominios;

//@author SAUL ISAAC APODACA BALDENEGRO 00000252020

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class AdministradorDominio implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAdministrador")
    private int id;

    @Column(name = "usuario", length = 50, nullable = false, unique = true)
    private String usuario;
    
    @Column(name = "contraseña", length = 50, nullable = false)
    private String contraseña;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUnidad")
    private unidadAcademicaDominio unidadAcademica;

    public AdministradorDominio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public unidadAcademicaDominio getUnidadAcademica() {
        return unidadAcademica;
    }

    public void setUnidadAcademica(unidadAcademicaDominio unidadAcademica) {
        this.unidadAcademica = unidadAcademica;
    }
    
}
