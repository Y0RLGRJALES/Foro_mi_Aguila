package foro.miaguila.api.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String titulo;

    // Relación con Categoria (muchos temas pertenecen a una categoría)
    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // Relación con Publicaciones (un tema puede tener muchas publicaciones)
    @OneToMany(mappedBy = "tema", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Publicacion> publicaciones;

    // Constructor vacío requerido por JPA
    public Tema() {}

    // Constructor útil para inicializar rápido
    public Tema(String titulo, Categoria categoria) {
        this.titulo = titulo;
        this.categoria = categoria;
    }

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Categoria getCategoria() { return categoria; }
    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public List<Publicacion> getPublicaciones() { return publicaciones; }
    public void setPublicaciones(List<Publicacion> publicaciones) { this.publicaciones = publicaciones; }
}
