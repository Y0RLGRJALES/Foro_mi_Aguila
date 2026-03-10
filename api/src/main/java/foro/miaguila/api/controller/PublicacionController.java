package foro.miaguila.api.controller;

import foro.miaguila.api.dto.request.PublicacionRequest;
import foro.miaguila.api.dto.response.PublicacionResponse;
import foro.miaguila.api.mapper.PublicacionMapper;
import foro.miaguila.api.service.PublicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publicaciones")
public class PublicacionController {

    @Autowired
    private PublicacionService service;

    @Autowired
    private PublicacionMapper mapper;

    // 📋 Listar todas las publicaciones
    @GetMapping
    public ResponseEntity<List<PublicacionResponse>> listar() {
        var publicaciones = service.findAll();
        var response = publicaciones.stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    // 📋 Listar primeras 10 (más antiguas)
    @GetMapping("/top10")
    public ResponseEntity<List<PublicacionResponse>> listarTop10() {
        var publicaciones = service.listarPrimeros10();
        var response = publicaciones.stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    // 📋 Listar últimas 10 (más recientes)
    @GetMapping("/ultimas10")
    public ResponseEntity<List<PublicacionResponse>> listarUltimas10() {
        var publicaciones = service.listarUltimas10();
        var response = publicaciones.stream()
                .map(mapper::toResponse)
                .toList();
        return ResponseEntity.ok(response);
    }

    // 🔍 Detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<PublicacionResponse> detalle(@PathVariable Long id) {
        var publicacion = service.findById(id);
        var response = mapper.toResponse(publicacion);
        return ResponseEntity.ok(response);
    }

    // 📝 Crear nueva publicación
    @PostMapping
    public ResponseEntity<PublicacionResponse> crear(@RequestBody PublicacionRequest request) {
        var publicacion = service.crearDesdeRequest(request);
        var response = mapper.toResponse(publicacion);
        return ResponseEntity.ok(response);
    }

    // 🔄 Actualizar publicación por ID
    @PutMapping("/{id}")
    public ResponseEntity<PublicacionResponse> actualizar(
            @PathVariable("id") Long id,
            @RequestBody PublicacionRequest request) {

        if (id == null) {
            throw new IllegalArgumentException("El id de la publicación no puede ser null");
        }

        var publicacionActualizada = service.actualizar(id, request);
        var response = mapper.toResponse(publicacionActualizada);
        return ResponseEntity.ok(response);
    }

    // 🗑️ Eliminar publicación por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}