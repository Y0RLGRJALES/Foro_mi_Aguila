package foro.miaguila.api.dto;

public class TemaResponse {
    private Long id;
    private String titulo;
    private Long categoriaId;

    public TemaResponse() {}

    public TemaResponse(Long id, String titulo, Long categoriaId) {
        this.id = id;
        this.titulo = titulo;
        this.categoriaId = categoriaId;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public Long getCategoriaId() { return categoriaId; }

    // Setters (necesarios para el mapper)
    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }
}
