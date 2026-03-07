package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;

    public Nota(String id, String titulo, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = LocalDateTime.now();
    }

    // Getters y Setters

    public String getid() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getFechaCreacionFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return fechaCreacion.format(formatter);
    }

    @Override
    public String toString(){
        return titulo;
    }

}