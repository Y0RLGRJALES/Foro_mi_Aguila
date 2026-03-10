package foro.miaguila.api.service;

import foro.miaguila.api.entity.Categoria;
import foro.miaguila.api.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service

public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas las categorías
    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    // Buscar categoría por ID
    public Categoria findById(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
    }

    // Guardar nueva categoría
    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Eliminar categoría
    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}