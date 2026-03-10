package foro.miaguila.api.dto;

public class TemaRequest {
    private String titulo;
    private Long categoriaId;

    public TemaRequest() {}

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
