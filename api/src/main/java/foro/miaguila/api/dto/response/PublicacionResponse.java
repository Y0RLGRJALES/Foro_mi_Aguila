package foro.miaguila.api.dto.response;

import java.time.LocalDateTime;

public class PublicacionResponse {
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String estado;
    private LocalDateTime fechaCreacion;
    private String temaTitulo;
    private String categoriaNombre;

    public PublicacionResponse(Long id, String titulo, String mensaje, String autor,
                               String estado, LocalDateTime fechaCreacion,
                               String temaTitulo, String categoriaNombre) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.autor = autor;
        this.estado = estado;
        this.fechaCreacion = fechaCreacion;
        this.temaTitulo = temaTitulo;
        this.categoriaNombre = categoriaNombre;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getMensaje() { return mensaje; }
    public String getAutor() { return autor; }
    public String getEstado() { return estado; }
    public LocalDateTime getFechaCreacion() { return fechaCreacion; }
    public String getTemaTitulo() { return temaTitulo; }
    public String getCategoriaNombre() { return categoriaNombre; }
}
