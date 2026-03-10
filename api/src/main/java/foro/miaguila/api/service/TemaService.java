package foro.miaguila.api.service;

import foro.miaguila.api.dto.TemaRequest;
import foro.miaguila.api.dto.TemaResponse;
import foro.miaguila.api.entity.Categoria;
import foro.miaguila.api.entity.Tema;
import foro.miaguila.api.repository.CategoriaRepository;
import foro.miaguila.api.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemaService {

    @Autowired
    private TemaRepository temaRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<TemaResponse> findAll() {
        return temaRepository.findAll().stream()
                .map(t -> new TemaResponse(t.getId(), t.getTitulo(), t.getCategoria().getId()))
                .toList();
    }

    public TemaResponse findById(Long id) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tema no encontrado"));
        return new TemaResponse(tema.getId(), tema.getTitulo(), tema.getCategoria().getId());
    }

    public TemaResponse save(TemaRequest dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Tema tema = new Tema();
        tema.setTitulo(dto.getTitulo());
        tema.setCategoria(categoria);

        Tema saved = temaRepository.save(tema);
        return new TemaResponse(saved.getId(), saved.getTitulo(), saved.getCategoria().getId());
    }

    public TemaResponse update(Long id, TemaRequest dto) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tema no encontrado"));

        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        tema.setTitulo(dto.getTitulo());
        tema.setCategoria(categoria);

        Tema updated = temaRepository.save(tema);
        return new TemaResponse(updated.getId(), updated.getTitulo(), updated.getCategoria().getId());
    }

    public void delete(Long id) {
        Tema tema = temaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tema no encontrado"));
        temaRepository.delete(tema);
    }
}
