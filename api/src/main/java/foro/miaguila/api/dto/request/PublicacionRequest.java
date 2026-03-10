package foro.miaguila.api.dto.request;

public class PublicacionRequest {
    private String titulo;
    private String mensaje;
    private String autor;
    private String estado;
    private Long temaId;

    // Getters y setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Long getTemaId() { return temaId; }
    public void setTemaId(Long temaId) { this.temaId = temaId; }
}
