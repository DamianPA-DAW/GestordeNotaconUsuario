package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombreUsuario;
    private String passwordHash;
    private List<Nota> notas;

    public Usuario(String nombreUsuario, String passwordHash) {
        this.nombreUsuario = nombreUsuario;
        this.passwordHash = passwordHash;
        this.notas = new ArrayList<>();
    }

    // Getters y setters
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return nombreUsuario;
    }
}