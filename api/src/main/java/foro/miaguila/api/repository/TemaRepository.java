package foro.miaguila.api.repository;

import foro.miaguila.api.entity.Tema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemaRepository extends JpaRepository<Tema, Long> {

    // ✅ Método para buscar temas por el id de la categoría
    List<Tema> findByCategoriaId(Long categoriaId);
}
