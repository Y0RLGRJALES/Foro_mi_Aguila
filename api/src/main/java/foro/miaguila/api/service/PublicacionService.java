package foro.miaguila.api.service;

import foro.miaguila.api.dto.request.PublicacionRequest;
import foro.miaguila.api.entity.Publicacion;
import foro.miaguila.api.entity.Tema;
import foro.miaguila.api.repository.PublicacionRepository;
import foro.miaguila.api.repository.TemaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicacionService {

    @Autowired
    private PublicacionRepository publicacionRepository;

    @Autowired
    private TemaRepository temaRepository;

    public List<Publicacion> findAll() {
        return publicacionRepository.findAll();
    }

    public List<Publicacion> listarPrimeros10() {
        return publicacionRepository.findTop10ByOrderByFechaCreacionAsc();
    }

    public List<Publicacion> listarUltimas10() {
        return publicacionRepository.findTop10ByOrderByFechaCreacionDesc();
    }

    public Publicacion findById(Long id) {
        return publicacionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada con id: " + id));
    }

    // 📝 Crear nueva publicación desde DTO
    public Publicacion crearDesdeRequest(PublicacionRequest request) {
        publicacionRepository.findByTituloAndMensaje(
                request.getTitulo(),
                request.getMensaje()
        ).ifPresent(p -> {
            throw new RuntimeException("Ya existe una publicación con el mismo título y mensaje");
        });

        // Buscar el tema por ID
        Tema tema = temaRepository.findById(request.getTemaId())
                .orElseThrow(() -> new RuntimeException("Tema no encontrado con id: " + request.getTemaId()));

        Publicacion publicacion = new Publicacion();
        publicacion.setTitulo(request.getTitulo());
        publicacion.setMensaje(request.getMensaje());
        publicacion.setAutor(request.getAutor());
        publicacion.setEstado(request.getEstado());
        publicacion.setTema(tema); // ✅ Asignar el tema correctamente

        return publicacionRepository.save(publicacion);
    }

    // 🔄 Actualizar publicación por ID
    public Publicacion actualizar(Long id, PublicacionRequest request) {
        return publicacionRepository.findById(id).map(publicacion -> {
            publicacionRepository.findByTituloAndMensaje(
                    request.getTitulo(),
                    request.getMensaje()
            ).ifPresent(p -> {
                if (!p.getId().equals(id)) {
                    throw new RuntimeException("Ya existe otra publicación con el mismo título y mensaje");
                }
            });

            // Buscar el tema por ID
            Tema tema = temaRepository.findById(request.getTemaId())
                    .orElseThrow(() -> new RuntimeException("Tema no encontrado con id: " + request.getTemaId()));

            publicacion.setTitulo(request.getTitulo());
            publicacion.setMensaje(request.getMensaje());
            publicacion.setAutor(request.getAutor());
            publicacion.setEstado(request.getEstado());
            publicacion.setTema(tema);

            return publicacionRepository.save(publicacion);
        }).orElseThrow(() -> new RuntimeException("Publicación no encontrada con id: " + id));
    }

    // 🗑️ Eliminar publicación por ID
    public void delete(Long id) {
        if (!publicacionRepository.existsById(id)) {
            throw new RuntimeException("No existe publicación con id: " + id);
        }
        publicacionRepository.deleteById(id);
    }
}
