package foro.miaguila.api.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private String autor;

    @ManyToOne
    private Tema tema;

    private LocalDateTime fechaCreacion;
    private String estado;

    public Publicacion() {
        this.fechaCreacion = LocalDateTime.now();
        this.estado = "ACTIVO";
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public Tema getTema() { return tema; }
    public void setTema(Tema tema) { this.tema = tema; }

    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDateTime fechaCreacion) { this.fechaCreacion = fechaCreacion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}

